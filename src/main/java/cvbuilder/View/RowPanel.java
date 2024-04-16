/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.View;

import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import cvbuilder.Model.UserGroup;
import cvbuilder.Model.UserProfiles;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

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
    JPanel radioPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel mainPanel = new JPanel();
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
    public RowPanel(UserProfiles profiles, String name)
    {
        this.users = profiles;
        this.name = name;
        radioButton.setText(name);
        this.setLayout(new GridLayout(0,2));
        mainPanel.setLayout(null);
        mainPanel.setBounds(0, 0, WIDTH, HEIGHT);
        radioButton.setSize(200, 20);
        mainPanel.add(radioButton);
        buttonPanel.add(edit);
        buttonPanel.add(delete);
        this.add(mainPanel, BorderLayout.WEST);
        this.add(buttonPanel, BorderLayout.EAST);
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
            
            System.out.println(this.name);
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
            this.rowPanelEditor = this.getParent();
            this.getParent().remove(this);
            this.rowPanelEditor.revalidate();
            this.rowPanelEditor.repaint();
        }
    }
    
}
