/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cvbuilder;

import cvbuilder.Model.UserGroup;
import cvbuilder.View.MainViewer;

/**
 *
 * @author 
 */
public class App {

    /**
     * @param args the command line arguments
     */
    /*Main method that defines the window size, activated the readfile method and sets the correct display properties.*/
    public static void main(String[] args) {
        UserGroup.getInstance().readCSVFile("data/cv_repo_3.csv");
        MainViewer Window =MainViewer.getInstance();
        Window.setVisible(true);
        Window.setSize(900,1000);
        Window.setDefaultCloseOperation(Window.EXIT_ON_CLOSE);
    }
    
}
