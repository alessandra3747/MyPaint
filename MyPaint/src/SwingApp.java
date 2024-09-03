import javax.swing.*;
import java.awt.*;
import java.io.File;

public class SwingApp extends JFrame{

    protected static File myFile;

    private static SwingApp swingAppInstance;


    //SINGLE TONE
    public static SwingApp getInstance() {

        if (swingAppInstance == null)
            swingAppInstance = new SwingApp();

        return swingAppInstance;
    }



    public SwingApp(){

        SwingUtilities.invokeLater( this::createGui );

    }




    protected void createGui() {

        this.setTitle("Simple Draw");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setPreferredSize(new Dimension(1000,800));

        this.setResizable(false);

        MyPanel myPanel = new MyPanel();

        this.setContentPane(myPanel);

        this.pack();

        this.setLocationRelativeTo(null);

        this.setVisible(true);
    }

}
