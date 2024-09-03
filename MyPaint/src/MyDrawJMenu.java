import Enumeracje.DrawingState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class MyDrawJMenu extends JMenu {

    protected JMenu figureMenu;
    protected JRadioButtonMenuItem figureCircleOption;
    protected JRadioButtonMenuItem figureSquareOption;
    protected JRadioButtonMenuItem figurePenOption;
    protected JMenuItem colorOption;
    protected JMenuItem clearOption;


    public MyDrawJMenu(){

        super("Draw");

        //CIRCLE
        figureCircleOption = new JRadioButtonMenuItem("Circle");

        figureCircleOption.setMnemonic(KeyEvent.VK_C);

        figureCircleOption.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK) );

        figureCircleOption.addActionListener(actionEvent -> {

            DrawingState.currentDrawingState = DrawingState.CIRCLE;

            MyPanel.pasekStanu.adjustToolBar();

        });

        //SQUARE
        figureSquareOption = new JRadioButtonMenuItem("Square");

        figureSquareOption.setMnemonic(KeyEvent.VK_R);

        figureSquareOption.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK) );

        figureSquareOption.addActionListener(actionEvent -> {

            DrawingState.currentDrawingState = DrawingState.SQUARE;

            MyPanel.pasekStanu.adjustToolBar();

        });

        //PEN
        figurePenOption = new JRadioButtonMenuItem("Pen");

        figurePenOption.setMnemonic(KeyEvent.VK_E);

        figurePenOption.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK) );

        figurePenOption.addActionListener(actionEvent -> {

            DrawingState.currentDrawingState = DrawingState.PEN;

            MyPanel.pasekStanu.adjustToolBar();

        });

        //GROUP OF SHAPES
        ButtonGroup shapesGroup = new ButtonGroup();
        shapesGroup.add(figureCircleOption);
        shapesGroup.add(figureSquareOption);
        shapesGroup.add(figurePenOption);

        //FIGURE MENU
        figureMenu = new JMenu("Figure");

        figureMenu.setMnemonic(KeyEvent.VK_F);

        figureMenu.add(figureCircleOption);
        figureMenu.add(figureSquareOption);
        figureMenu.add(figurePenOption);

        //COLOR
        colorOption = new JMenuItem("Color");

        colorOption.setMnemonic(KeyEvent.VK_C);

        colorOption.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK) );

        colorOption.addActionListener(actionEvent -> {
            MyJPanelToDraw.penColor = JColorChooser.showDialog(null, "Choose Color", Color.BLACK);
        });

        //CLEAR
        clearOption = new JMenuItem("Clear");

        clearOption.setMnemonic(KeyEvent.VK_L);

        clearOption.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK) );

         clearOption.addActionListener(actionEvent ->
             MyPanel.obszarRysowania.clear()
         );


        this.add(figureMenu);
        this.add(colorOption);
        this.addSeparator();
        this.add(clearOption);

    }

}
