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
    //creating an attribute to store the userprofile that is pulled through the constructor
    private UserProfiles users;
    
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
        radioButton.setText(name);
        this.add(radioButton);
        this.add(edit);
        edit.setActionCommand("Edit");
        this.add(delete);
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
            UserGroup.getInstance().getUserInfo().remove(this.users);
            TabPanel.getInstance().getEditPanels().clear();
            TabPanel.getInstance().removeAll();
            TabPanel.getInstance().build();
        }
    }
    
}
