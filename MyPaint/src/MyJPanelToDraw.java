import Enumeracje.DrawingState;
import Enumeracje.FileState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class MyJPanelToDraw extends JPanel {


    protected static Color penColor;

    protected static ArrayList<MyShape> shapes;

    protected static ArrayList<MyLine> lines;

    protected static MyLine lineTmp;

    private boolean isDKeyPressed = false;



    public MyJPanelToDraw() {

        //ODBIERANIE EVENTOW KLAWIATURY
        this.setFocusable(true);

        penColor = Color.BLACK;

        shapes = new ArrayList<>();

        lines = new ArrayList<>();


        //SPRAWDZENIE CZY PRZYCISK D JEST NACISNIETY DO USUNIECIA ELEMENTU

        this.addKeyListener( new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if ( e.getKeyCode() == KeyEvent.VK_D)
                    isDKeyPressed = true;
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if ( e.getKeyCode() == KeyEvent.VK_D)
                    isDKeyPressed = false;
            }
        });


        //SPRAWDZENIE AKCJI MYSZKI

        this.addMouseListener( new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {

                if ( isDKeyPressed ) {

                    String[] opcje = new String[]{"TAK", "NIE"};

                    int res = JOptionPane.showOptionDialog (
                            null,
                            "Czy chcesz usunąć element?",
                            "Usuniecie Elementu",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            opcje,
                            opcje[0]
                    );

                    isDKeyPressed = false;

                    if ( res == 0 ) {
                        removeShapeAtPosition(e.getX(), e.getY());

                        FileState.currentFileState = FileState.MODIFIED;
                        MyPanel.pasekStanu.adjustToolBar();

                        repaint();
                    }

                } else if ( DrawingState.currentDrawingState != null ) {

                    switch (DrawingState.currentDrawingState) {

                        case CIRCLE:

                            shapes.add(new MyShape(new Ellipse2D.Double(e.getX()-15, e.getY()-15, 30, 30), generateColor()));
                            repaint();

                            break;

                        case SQUARE:

                            shapes.add(new MyShape(new Rectangle2D.Double(e.getX()-15, e.getY()-15, 30, 30), generateColor()));
                            repaint();

                            break;

                        case PEN:

                            lineTmp = new MyLine(penColor);
                            lineTmp.addPoint(e.getPoint());

                    }

                    FileState.currentFileState = FileState.MODIFIED;

                    MyPanel.pasekStanu.adjustToolBar();

                }

            }

            @Override
            public void mouseReleased(MouseEvent e) {

                if (DrawingState.currentDrawingState == DrawingState.PEN) {
                    lines.add(lineTmp);
                }

            }

        } );


        this.addMouseMotionListener(new MouseAdapter() {

            @Override
            public void mouseDragged(MouseEvent e) {

                if (DrawingState.currentDrawingState == DrawingState.PEN) {
                    lineTmp.addPoint(e.getPoint());
                    repaint();
                }

            }

        } );

    }


    public void clear() {

        if ( shapes != null )
            shapes.clear();

        if ( lines != null )
            lines.clear();

        if ( lineTmp != null )
            lineTmp.clear();

        repaint();

    }


    private Color generateColor() {

        int red = (int)(Math.random()*256);
        int green = (int)(Math.random()*256);
        int blue = (int)(Math.random()*256);

        return new Color(red,green,blue);
    }


    public void paintComponent (Graphics g) {

        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;


        for ( MyShape myShape : shapes ) {
            g2d.setColor(myShape.color);
            g2d.fill(myShape.shape);
        }


        if ( !lines.isEmpty() )
            for (MyLine l : lines)
                drawLine(g2d, l);


        if ( lineTmp != null )
            drawLine(g2d, lineTmp);


    }


    private void drawLine ( Graphics2D g2d, MyLine l ) {

        for (int i = 0; i < l.getPoints().size() - 2; i++) {

            g2d.setColor(l.getColor());

            g2d.drawLine(l.getIndex(i).x, l.getIndex(i).y, l.getIndex(i + 1).x, l.getIndex(i + 1).y);

            repaint();

        }

    }


    private void removeShapeAtPosition(int x, int y) {
        shapes.removeIf(s -> s.shape.contains(x, y));
    }

}
