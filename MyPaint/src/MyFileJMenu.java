import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class MyFileJMenu extends JMenu {

    protected JMenuItem openOption;
    protected JMenuItem saveOption;
    protected JMenuItem saveAsOption;
    protected JMenuItem quitOption;

    public MyFileJMenu(){

        super("File");

        //OPEN
        openOption = new JMenuItem("Open");

        openOption.setMnemonic(KeyEvent.VK_O);

        openOption.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK) );

        //SAVE
        saveOption = new JMenuItem("Save");

        saveOption.setMnemonic(KeyEvent.VK_S);

        saveOption.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK) );

        //SAVE AS
        saveAsOption = new JMenuItem("Save As...");

        saveAsOption.setMnemonic(KeyEvent.VK_A);

        saveAsOption.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_S, InputEvent.SHIFT_DOWN_MASK | InputEvent.CTRL_DOWN_MASK ) );


        //QUIT
        quitOption = new JMenuItem("Quit");

        quitOption.setMnemonic(KeyEvent.VK_Q);

        quitOption.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK ) );


        this.add(openOption);

        this.add(saveOption);

        this.add(saveAsOption);

        this.addSeparator();

        this.add(quitOption);

    }

    public void addFileJMenuListener(ActionListener actionListener){

        openOption.addActionListener(actionListener);

        saveOption.addActionListener(actionListener);

        saveAsOption.addActionListener(actionListener);

        quitOption.addActionListener(actionListener);

    }

}
