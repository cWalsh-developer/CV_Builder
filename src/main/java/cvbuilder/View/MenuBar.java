/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import cvbuilder.Model.UserGroup;
import cvbuilder.Model.UserProfiles;
import cvbuilder.Model.Reference;
import java.awt.Component;

/**
 *
 * @author Connor
 */
public class MenuBar extends JMenuBar implements ActionListener
{
    //Creating a menu and menu items to store inside the menu
    JMenu file = new JMenu("File");
    JMenuItem open = new JMenuItem("Open");
    JMenuItem save = new JMenuItem("Save");
    JMenuItem quit = new JMenuItem("Quit");
    Component mainTabPanel;
    /*A constructor that adds menu items to a menu and adds the menu to the menu bar which is displayed in the MainViewer
    Action Commands and Listeners are set to wire up functionality to each menu item*/
    public MenuBar()
    {
        this.file.add(this.open);
        this.file.add(this.save);
        this.file.add(this.quit);
        this.add(file);
        this.open.setActionCommand("Open");
        this.save.setActionCommand("Save");
        this.quit.setActionCommand("Quit");
        this.open.addActionListener(this);
        this.save.addActionListener(this);
        this.quit.addActionListener(this);
    }
/*Creating functionality to close the window when "quit" is selected and
    functionality to replace the window content with a new CSV file content*/
    @Override
    public void actionPerformed(ActionEvent e) 
    {
       if(e.getActionCommand().equals("Quit"))
       {
           System.exit(0);
       }
       else if(e.getActionCommand().equals("Open"))
       {
           JFileChooser filePicked = new JFileChooser();
           int returnValue = filePicked.showOpenDialog(this);
           if(returnValue == JFileChooser.APPROVE_OPTION)
           {
               UserGroup.getInstance().getUserInfo().clear();
               UserGroup.getInstance().getRefereeInfo().clear();
               UserGroup.getInstance().setUser(new UserProfiles());
               UserGroup.getInstance().setReferees(new Reference());
               UserGroup.getInstance().readCSVFile(filePicked.getSelectedFile().toString());
               MainViewer.getInstance().setMainTab(new TabPanel("Main"));
           }
       }
    }
}
