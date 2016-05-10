package Display;

import GameEngine.GameIO;

import javax.swing.*;
import java.awt.*;

//todo make this the only access backend programmers have to the graphics library. Should contain everything without
// having to import the support classes.
public class Display extends  JFrame
{
    private JTextArea textField;
    public Display(String title, int width, int height)
    {

        textField = new JTextArea();



        textField.setFont(new Font("monospaced", Font.PLAIN, 12));
        textField.setRows(90);
        textField.setColumns(90);
        textField.setVisible(true);
        textField.setLineWrap(true);
        textField.setEditable(false);
        textField.setBackground(Color.black);
        textField.setForeground(Color.green);
        textField.addKeyListener(new GameIO());
        super.add(textField);
        super.setTitle(title);
        super.setSize(width,height);
        super.setVisible(true);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(false);
    }

    public void cycleFrames(String insert)
    {
        textField.setText(insert);
    }

}