package Display;

import javax.swing.*;
import java.awt.*;
   
/**
 * Developer tool for creating windows and graphics
 */
public class DisplayEditor extends JFrame
{
    JTextArea textField;
    JFrame frame;
    public DisplayEditor(String title, int width, int height)
    {
        // Creates the toolbar
        frame = new JFrame("toolbar");
        frame.setSize(200,200);
        frame.setVisible(true);
        
        // Sets up the toolbars buttons and adds them to the frame
        JButton saveButton, loadButton;
        
        saveButton = new JButton();
        loadButton = new JButton();
        
        frame.add(saveButton);
        frame.add(loadButton);
        //saveButton.addActionListener();
        // Sets up the text area in the super frame
        textField = new JTextArea();
        textField.setRows(90);
        textField.setColumns(90);
        textField.setVisible(true);
        textField.setLineWrap(true);
        textField.setEditable(true);
        textField.setBackground(Color.black);
        textField.setForeground(Color.green);
        
 
        super.add(textField);
        super.setTitle(title);
        super.setSize(width,height);
        super.setVisible(true);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(false);
    }
    


// ACTION LISTENERS.
// TODO FIGURE OUT WHY THIS ISNT WORKING WHEN YOU HAVE INTERNET
    private class saveFile
    {
    
    
      public void actionPerformed()
      {
      
         // TODO ADD CODE TO OUT PUT A FORMATTED FILE
      
      }
    }
    private class loadFile
    {
    
      public void actionPerformed()
      {
      
         // TODO ADD CODE TO LOAD IN A FORMATTED FILE
      
      }
    }
}