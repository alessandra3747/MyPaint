import Enumeracje.FileState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.List;


public class MyFileJMenuListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        JMenuItem myOption = (JMenuItem) e.getSource();

        switch (myOption.getText()) {

            case "Open":

                JFileChooser fc = new JFileChooser();

                int openResult = fc.showOpenDialog(null);

                if ( openResult == JFileChooser.APPROVE_OPTION ) {

                    SwingApp.myFile = fc.getSelectedFile();

                    FileState.currentFileState = FileState.SAVED;

                    openFile(SwingApp.myFile);

                    SwingApp.getInstance().setTitle("Simple Draw : " + SwingApp.myFile.getName());
                }

                break;

            case "Save":

                if (SwingApp.myFile == null)
                    saveAsFile();
                else
                    saveFile();

                FileState.currentFileState = FileState.SAVED;

                if (SwingApp.myFile != null)
                  SwingApp.getInstance().setTitle("Simple Draw : " + SwingApp.myFile.getName());

                break;

            case "Save As...":

                saveAsFile();

                FileState.currentFileState = FileState.SAVED;

                SwingApp.getInstance().setTitle("Simple Draw : " + SwingApp.myFile.getName());

                break;

            case "Quit":

                quitFile();

                System.exit(0);

                break;

        }

        MyPanel.pasekStanu.adjustToolBar();

        MyPanel.obszarRysowania.repaint();

    }


    private void saveFile() {

        try ( ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(SwingApp.myFile)) ) {

            out.writeObject(MyJPanelToDraw.shapes);

            out.writeObject(MyJPanelToDraw.lines);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void saveAsFile() {

        JFileChooser fc = new JFileChooser();

        int saveResult = fc.showSaveDialog(null);

        if ( saveResult == JFileChooser.APPROVE_OPTION ) {

            SwingApp.myFile = fc.getSelectedFile();

            saveFile();

        }

    }

    private void openFile(File file) {

        try ( ObjectInputStream in = new ObjectInputStream(new FileInputStream(file)) ) {

            List<MyShape> shapesTmp = (List<MyShape>) in.readObject();
            List<MyLine> linesTmp = (List<MyLine>) in.readObject();

            MyJPanelToDraw.shapes.clear();
            MyJPanelToDraw.shapes.addAll(shapesTmp);

            MyJPanelToDraw.lines.clear();
            MyJPanelToDraw.lines.addAll(linesTmp);

            if ( MyJPanelToDraw.lineTmp != null )
                MyJPanelToDraw.lineTmp.clear();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void quitFile() {

        String[] opcje = new String[]{"TAK", "NIE"};

        int res = JOptionPane.showOptionDialog (
                null,
                "Czy chcesz zapisać plik?",
                "Zapis Pliku",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcje,
                opcje[0]
        );

        if ( res == 0 ) {
            if (SwingApp.myFile == null)
                saveAsFile();
            else
                saveFile();
        }

    }


}
