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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Connor
 */
public class MenuBar extends JMenuBar implements ActionListener
{
    //Creating a menu and menu items to store inside the menu
    JMenu file = new JMenu("File");
    JMenuItem open = new JMenuItem("Open");
    JMenuItem print = new JMenuItem("Print");
    JMenuItem save = new JMenuItem("Save Custom CV");
    JMenuItem saveAll = new JMenuItem("Save All");
    JMenuItem quit = new JMenuItem("Quit");
    StringBuilder cvBuild = new StringBuilder();
    
    /*A constructor that adds menu items to a menu and adds the menu to the menu bar which is displayed in the MainViewer
    Action Commands and Listeners are set to wire up functionality to each menu item*/

    /**
     * Menu Bar Constructor
     */

    public MenuBar()
    {
        this.file.add(this.open);
        this.file.add(this.print);
        this.file.add(this.save);
        this.file.add(this.saveAll);
        this.file.add(this.quit);
        this.add(file);
        this.open.setActionCommand("Open");
        this.print.setActionCommand("Print");
        this.save.setActionCommand("Save");
        this.saveAll.setActionCommand("SaveAll");
        this.quit.setActionCommand("Quit");
        this.print.addActionListener(this);
        this.open.addActionListener(this);
        this.save.addActionListener(this);
        this.saveAll.addActionListener(this);
        this.quit.addActionListener(this);
    }
/*Creating functionality to close the window when "quit" is selected and
    functionality to replace the window content with a new CSV file content
    
    Save action command logic controls what happens when a user is wanted to save their custon CV
    SaveAll action command is controlling the data manipulation to store it into another repository/file
    
    Error checks ensure proper file types are used*/

    /**
     *
     * @param e
     */

    @Override
    public void actionPerformed(ActionEvent e) 
    {
       if(e.getActionCommand().equals("Quit"))
       {
           int confirmClosure = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit 'CV Builder'?", "ARE YOU SURE?", 
                   JOptionPane.YES_NO_OPTION, 
                   JOptionPane.QUESTION_MESSAGE);
           if(confirmClosure == JOptionPane.YES_OPTION)
           {
                System.exit(0);
           }
       }
       else if(e.getActionCommand().equals("Open"))
       {
           this.cvBuild.setLength(0);
           JFileChooser filePicked = new JFileChooser();
           int returnValue = filePicked.showOpenDialog(this);
           if(returnValue == JFileChooser.APPROVE_OPTION && filePicked.getSelectedFile().exists())
           {
               if(filePicked.getSelectedFile().toString().endsWith(".csv"))
               {
                   UserGroup.getInstance().getUserInfo().clear();
                   UserGroup.getInstance().getRefereeInfo().clear();
                   UserGroup.getInstance().setUser(new UserProfiles());
                   UserGroup.getInstance().setReferees(new Reference());
                   UserGroup.getInstance().readCSVFile(filePicked.getSelectedFile().toString());
                   MainViewer.getInstance().setMainTab(new TabPanel("Main"));
               }
               else
               {
                   JOptionPane.showMessageDialog(null, "Unsupported file type. Loaded files must be '.csv'", "USUPPORTED FILE TYPE!", JOptionPane.ERROR_MESSAGE);
               }
           }
           else
           {
               JOptionPane.showMessageDialog(null, "No file found, please try again.", "NO FILE FOUND!", JOptionPane.ERROR_MESSAGE);
           }
       }    
       else if(e.getActionCommand().equals("Print"))
       {
           if(UserGroup.getInstance().getCvSelectedName() == null || UserGroup.getInstance().getCvSelectedEmail() == null)
           {
               JOptionPane.showMessageDialog(null, "You must select at least a Name and an Email before printing", "Selection Error", JOptionPane.ERROR_MESSAGE);
           }
           else
           {
                if(UserGroup.getInstance().getCvSelectedTitle() != null)
                {
                    this.cvBuild.append("Title: ").append(UserGroup.getInstance().getCvSelectedTitle()).append("\n");
                    
                }
                this.cvBuild.append("Name: ").append(UserGroup.getInstance().getCvSelectedName()).append("\n")
                .append("Email: ").append(UserGroup.getInstance().getCvSelectedEmail()).append("\n");
                if(UserGroup.getInstance().getCvSelectedReferee1() !=null)
                {
                    cvBuild.append("Referee 1: ").append(UserGroup.getInstance().getCvSelectedReferee1()).append("\n");
                    
                }
                if(UserGroup.getInstance().getCvSelectedReferee2() !=null)
                {
                    this.cvBuild.append("Referee 2: ").append(UserGroup.getInstance().getCvSelectedReferee2()).append("\n");
                    
                }
                System.out.println(this.cvBuild.toString());
                this.cvBuild.setLength(0);
           }
       }
       else if(e.getActionCommand().equals("Save"))
       {
           if(UserGroup.getInstance().getCvSelectedName() == null || UserGroup.getInstance().getCvSelectedEmail()==null)
           {
               JOptionPane.showMessageDialog(null, "You must select at least a Name and an Email before saving your custom CV", "Insufficient Data Provided", JOptionPane.ERROR_MESSAGE);
           }
           else
           {
                File newFile = new File("customCV.csv");
                JFileChooser saveFile = new JFileChooser();
                saveFile.setSelectedFile(newFile);
                int returnVal = saveFile.showSaveDialog(this);
                
                if(returnVal == JFileChooser.APPROVE_OPTION)
                {
                    if(saveFile.getSelectedFile().toString().toLowerCase().endsWith(".csv"))
                    {
                        try(FileWriter customCV = new FileWriter(saveFile.getSelectedFile().toString());
                                BufferedWriter bw = new BufferedWriter(customCV)) 
                        {
                            if(UserGroup.getInstance().getCvSelectedTitle()!=null)
                            {
                             bw.write("User,"+"Title,"+UserGroup.getInstance().getCvSelectedTitle());
                             bw.newLine();   
                            }
                            bw.write("User,"+"Name,"+UserGroup.getInstance().getCvSelectedName());
                            bw.newLine();
                            bw.write("User,"+"Email,"+UserGroup.getInstance().getCvSelectedEmail());
                            bw.newLine();
                            if(UserGroup.getInstance().getCvSelectedReferee1()!=null)
                            {
                             String convertedReference = UserGroup.getInstance().getCvSelectedReferee1();
                             convertedReference = convertedReference.replace("\n", "%%%%");
                             convertedReference = convertedReference.replace(",", "////");
                             bw.write("Reference,"+"Referee 1,"+convertedReference);
                             bw.newLine();
                            }
                            if(UserGroup.getInstance().getCvSelectedReferee2()!=null)
                            {
                             String convertedReference = UserGroup.getInstance().getCvSelectedReferee2();
                             convertedReference = convertedReference.replace("\n", "%%%%");
                             convertedReference = convertedReference.replace(",", "////");
                             bw.write("Reference,"+"Referee 2,"+convertedReference);   
                            }
                        }
                        catch(IOException c)
                        {
                            c.printStackTrace();
                            System.out.println("File Error");
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Unsupported file type. Files must be saved as '.csv'\n and with no spaces", "UNSUPPORTED FILE TYPE", JOptionPane.ERROR_MESSAGE);
                    }
                }
               
           }
       }
       else if(e.getActionCommand().equals("SaveAll"))
       {
            File newFile = new File("cv_repo_3.csv");
            JFileChooser saveDataFile = new JFileChooser();
            saveDataFile.setSelectedFile(newFile);
            int returnVal = saveDataFile.showSaveDialog(this);

            if(returnVal == JFileChooser.APPROVE_OPTION)
            {
                if(saveDataFile.getSelectedFile().toString().toLowerCase().endsWith(".csv"))
                {
                    try(FileWriter customCV = new FileWriter(saveDataFile.getSelectedFile().toString());
                            BufferedWriter bw = new BufferedWriter(customCV)) 
                    {
                        bw.write("Section,"+"Sub Section,"+"Variants");
                        bw.newLine();
                        StringBuilder infoBuild = new StringBuilder();
                        for(String titles : UserGroup.getInstance().getUserInfo().get(0).getUserTitle())
                        {
                            infoBuild.append(titles).append(",");
                        }
                        infoBuild.deleteCharAt(infoBuild.length()-1);
                        bw.write("User,"+"Title,"+infoBuild);
                        bw.newLine();
                        infoBuild.setLength(0);
                        for(String name : UserGroup.getInstance().getUserInfo().get(0).getUserName())
                        {
                            infoBuild.append(name).append(",");
                        }
                        infoBuild.deleteCharAt(infoBuild.length()-1);
                        bw.write("User,"+"Name,"+infoBuild);
                        bw.newLine();
                        infoBuild.setLength(0);
                        for(String email : UserGroup.getInstance().getUserInfo().get(0).getUserEmail())
                        {
                            infoBuild.append(email).append(",");
                        }
                        infoBuild.deleteCharAt(infoBuild.length()-1);
                        bw.write("User,"+"Email,"+infoBuild);
                        bw.newLine();
                        infoBuild.setLength(0);
                        for(String RefereeOne : UserGroup.getInstance().getRefereeInfo().get(0).getReferee1())
                        {
                            infoBuild.append(RefereeOne).append(",");
                        }
                        infoBuild.deleteCharAt(infoBuild.length()-1);
                        bw.write("Reference,"+"Referee 1,"+infoBuild);
                        bw.newLine();
                        infoBuild.setLength(0);
                        for(String RefereeTwo : UserGroup.getInstance().getRefereeInfo().get(0).getReferee2())
                        {
                            infoBuild.append(RefereeTwo).append(",");
                        }
                         bw.write("Reference,"+"Referee 2,"+infoBuild);   
                    }
                    catch(IOException c)
                    {
                        c.printStackTrace();
                        System.out.println("File Error");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Unsupported file type. Files must be saved as '.csv' \nand with no spaces", "UNSUPPORTED FILE TYPE", JOptionPane.ERROR_MESSAGE);
                }
            }
               
           }
       }
}
