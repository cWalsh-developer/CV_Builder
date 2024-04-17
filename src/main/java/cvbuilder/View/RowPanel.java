/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import cvbuilder.Model.UserGroup;
import cvbuilder.Model.UserProfiles;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;

/**
 *
 * @author Connor
 */
public class RowPanel extends JPanel implements ActionListener
{
    //defining edit, delete and radiobutton objects and labling them
    JButton edit = new JButton("Edit");
    JButton delete = new JButton("Delete");
    JRadioButton radioButton = new JRadioButton();
    JPanel buttonPanel = new JPanel();
    JPanel mainPanel = new JPanel();
    JPanel innerButtonPanel = new JPanel();
    Container rowPanelEditor;
    //creating an attribute to store the userprofile that is pulled through the constructor
    private UserProfiles users;
    private String name;
    private int tabNum;

    public int getTabNum() {
        return tabNum;
    }
    
//Getters and setters for the panel buttons
    public JButton getEdit() {
        return edit;
    }

    public void setEdit(JButton edit) {
        this.edit = edit;
    }

    public JButton getDelete() {
        return delete;
    }

    public void setDelete(JButton delete) {
        this.delete = delete;
    }

    public JRadioButton getRadioButton() {
        return radioButton;
    }

    public void setRadioButton(JRadioButton radioButton) {
        this.radioButton = radioButton;
    }
    /*RowPanel constructor which sets the users attribute to the current profile
    sets radiobutton text and action commands and listeners to the delete and edit buttons.*/
    public RowPanel(UserProfiles profiles, String name, int n)
    {
        this.users = profiles;
        this.name = name;
        if(profiles!=null)
        {
            radioButton.setText(name);
            mainPanel.add(radioButton);
        }
        else
        {
            JTextArea refereeInfo = new JTextArea();
            refereeInfo.setBorder(BorderFactory.createLineBorder(Color.lightGray, 3));
            StringBuilder sBuild = new StringBuilder();
            if(name.equals("referee1"))
            {
                String[] newLines = UserGroup.getInstance().getRefereeInfo().get(0).getReferee1().get(n).split("%%%%");
                for (String newLine : newLines) 
                {
                    sBuild.append(newLine).append("\n");
                }
                    refereeInfo.setText(sBuild.toString());
                mainPanel.add(radioButton);
                mainPanel.add(refereeInfo);
            }
            else
            {
                String[] newLines = UserGroup.getInstance().getRefereeInfo().get(0).getReferee2().get(n).split("%%%%");
                for (String newLine : newLines) 
                {
                    sBuild.append(newLine).append("\n");
                }
                    refereeInfo.setText(sBuild.toString());
                mainPanel.add(radioButton);
                mainPanel.add(refereeInfo);
                
            }
            
        }
        this.setLayout(new GridLayout(0,2));
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.X_AXIS));
        
        buttonPanel.setLayout(new GridLayout(0,3));
        innerButtonPanel.add(edit);
        innerButtonPanel.add(delete);
        buttonPanel.add(innerButtonPanel);
        this.add(mainPanel);
        this.add(buttonPanel);
        edit.setActionCommand("Edit");
        delete.setActionCommand("Delete");
        edit.addActionListener(this);
        delete.addActionListener(this);
        
    }
    
    /*Action method which enables the user to update existing user details or delete them*/
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getActionCommand().equals("Edit"))
        {
            
            String newText = JOptionPane.showInputDialog(this, "Enter New Text:", this.radioButton.getText());
            if(newText == null || newText.equals("") || newText.trim().equals(""))
            {
                this.radioButton.setText(this.radioButton.getText());
            }
            else
            {
                this.radioButton.setText(newText);
            }
        }
        else if (e.getActionCommand().equals("Delete"))
        {
            if(this.users==null)
            {
                    System.out.println(UserGroup.getInstance().getRefereeInfo());   
            }
            else
            {
                if(users.getUserName().contains(this.name))
                {
                    users.getUserName().remove(this.name);
                }
                else if(users.getUserTitle().contains(this.name))
                {
                    users.getUserTitle().remove(this.name);
                }
                else if(users.getUserEmail().contains(this.name))
                {
                    users.getUserEmail().remove(this.name);
                }
            }
            this.rowPanelEditor = this.getParent();
            this.getParent().remove(this);
            this.rowPanelEditor.revalidate();
            this.rowPanelEditor.repaint();
        }
    }
    
}
