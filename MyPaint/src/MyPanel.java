import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {


    protected JMenuBar menuBar;

    protected MyFileJMenu menuFile;

    protected MyDrawJMenu menuDraw;

    protected static MyJPanelToDraw obszarRysowania;

    protected static MyJToolBar pasekStanu;


    public MyPanel() {

        this.setLayout(new BorderLayout());

        obszarRysowania = new MyJPanelToDraw();
        this.add(obszarRysowania, BorderLayout.CENTER);


        menuBar = new JMenuBar();

        menuFile = new MyFileJMenu();

        menuFile.addFileJMenuListener(new MyFileJMenuListener());

        menuDraw = new MyDrawJMenu();

        menuBar.add(menuFile);
        menuBar.add(menuDraw);

        this.add(menuBar, BorderLayout.NORTH);


        pasekStanu = new MyJToolBar();
        this.add(pasekStanu, BorderLayout.SOUTH);

    }


}
