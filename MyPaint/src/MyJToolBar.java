import Enumeracje.DrawingState;
import Enumeracje.FileState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class MyJToolBar extends JToolBar {


    protected  JLabel fileStateDisplay;
    protected  JLabel drawingStateDisplay;


    public MyJToolBar(){

        this.setLayout(new BorderLayout());

        //STAN PLIKU
        fileStateDisplay = new JLabel(FileState.currentFileState.name());

        fileStateDisplay.setFont(new Font(null, Font.BOLD, 18));


        //TRYB RYSOWANIA
        drawingStateDisplay = new JLabel();

        if( DrawingState.currentDrawingState != null) {
            drawingStateDisplay.setText(DrawingState.currentDrawingState.name());
        }
        drawingStateDisplay.setFont(new Font(null, Font.BOLD, 18));



        this.add(fileStateDisplay, BorderLayout.EAST);

        this.add(fileStateDisplay, BorderLayout.WEST);


        this.addComponentListener(new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent e) {
                adjustToolBar();
            }

            @Override
            public void componentMoved(ComponentEvent e) {
                adjustToolBar();
            }

            @Override
            public void componentShown(ComponentEvent e) {
                adjustToolBar();
            }

            @Override
            public void componentHidden(ComponentEvent e) {
                adjustToolBar();
            }
        });

    }

    protected void adjustToolBar(){

        if( DrawingState.currentDrawingState != null) {
            drawingStateDisplay.setText(DrawingState.currentDrawingState.name());
        }

        fileStateDisplay.setText(FileState.currentFileState.name());


        if (this.getOrientation() == HORIZONTAL) {

            this.removeAll();
            this.add(fileStateDisplay, BorderLayout.EAST);
            this.add(drawingStateDisplay, BorderLayout.WEST);

        } else if (this.getOrientation() == VERTICAL) {

            this.removeAll();
            this.add(fileStateDisplay, BorderLayout.SOUTH);
            this.add(drawingStateDisplay, BorderLayout.NORTH);

        }

        this.revalidate();
        this.repaint();

    }

}
