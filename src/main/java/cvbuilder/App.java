/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cvbuilder;

import cvbuilder.Model.UserGroup;
import cvbuilder.View.MainViewer;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Connor
 * 
 */
public class App {

    //Creating a WindowListener to pass to the main viewer as a parameter which will ask the users for confirmation before closing the application.
    private static WindowListener exitListener = new WindowAdapter()
    {
        @Override
        public void windowClosing(WindowEvent e)
        {
           int confirmClosure = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit 'CV Builder'?", "ARE YOU SURE?", 
                   JOptionPane.YES_NO_OPTION, 
                   JOptionPane.QUESTION_MESSAGE);
           if(confirmClosure == JOptionPane.YES_OPTION)
           {
                MainViewer.getInstance().setDefaultCloseOperation(MainViewer.getInstance().EXIT_ON_CLOSE);
           }
           else
           {
               MainViewer.getInstance().setDefaultCloseOperation(MainViewer.getInstance().DO_NOTHING_ON_CLOSE);
           }
        }
    };
    /**
     * @param args the command line arguments
     */
    /*Main method that defines the window size, activated the readfile method and sets the correct display properties.*/
    public static void main(String[] args) {
        UserGroup.getInstance().readCSVFile("data/cv_repo_3.csv");
        MainViewer Window =MainViewer.getInstance();
        Window.setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        //Setting display size depending on screen size
        if(dim.getWidth()>=1920 && dim.getHeight()>=1080)
        {
            //Laptop display size
            Window.setSize(900,1000);
        }
        else
        {
            //Larger desktop screen display size
            Window.setSize(900,750);
        }
        //Setting display location to always open the app in the centre of the screen
        Window.setLocation(dim.width/2-Window.getSize().width/2,dim.height/2-Window.getSize().height/2);
        Window.addWindowListener(exitListener);
        
    }
    
}
