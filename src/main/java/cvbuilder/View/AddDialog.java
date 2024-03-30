/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import cvbuilder.Model.UserGroup;
import cvbuilder.Model.UserProfiles;

/**
 *
 * @author Connor
 */
public class AddDialog extends JDialog implements ActionListener
{
  JPanel mainPanel = new JPanel();
  JPanel bottomPanel = new JPanel();
  JPanel leftPanel = new JPanel();
  JPanel rightPanel = new JPanel();
  JLabel textFieldLabel1 = new JLabel("User Profile");
  JLabel textFieldLabel2 = new JLabel("User Title");
  JLabel textFieldLabel3 = new JLabel("User Name");
  JLabel textFieldLabel4 = new JLabel("User Email");
  JTextField userProfileName = new JTextField("User Profile Name");  
  JTextField userTitle = new JTextField("User Title");  
  JTextField userName = new JTextField("User Name");  
  JTextField userEmail = new JTextField("User Email"); 
  JButton okay = new JButton("OK");
  JButton cancel = new JButton("Cancel");
  
  public AddDialog()
  {
      this.mainPanel.setLayout(new GridLayout(0,2));
      this.leftPanel.setLayout(new GridLayout(0,1));
      this.rightPanel.setLayout(new GridLayout(0,1));
      this.leftPanel.add(this.textFieldLabel1, BorderLayout.WEST);
      this.leftPanel.add(this.textFieldLabel2, BorderLayout.WEST);
      this.leftPanel.add(this.textFieldLabel3, BorderLayout.WEST);
      this.leftPanel.add(this.textFieldLabel4,  BorderLayout.WEST);
      this.mainPanel.add(this.leftPanel);
      
      this.rightPanel.add(this.userProfileName,BorderLayout.CENTER);
      this.rightPanel.add(this.userTitle,BorderLayout.CENTER);
      this.rightPanel.add(this.userName, BorderLayout.CENTER);
      this.rightPanel.add(this.userEmail, BorderLayout.CENTER);
      this.mainPanel.add(this.rightPanel);
      this.bottomPanel.add(this.okay);
      this.bottomPanel.add(this.cancel);
      this.okay.addActionListener(this);
      this.cancel.addActionListener(this);
      this.okay.setActionCommand("OK");
      this.cancel.setActionCommand("Cancel");
      this.add(this.mainPanel);
      this.add(this.bottomPanel, BorderLayout.SOUTH);
  }
    
    
   
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getActionCommand().equals("Cancel"))
        {
            this.dispose();
        }
        else
        {
            if(this.userProfileName.getText().equals("User Profile Name")
                    || this.userTitle.getText().equals("User Title") 
                    || this.userName.getText().equals("User Name") 
                    || this.userEmail.getText().equals("User Email")
                    || this.userProfileName.getText().trim().equals("")
                    || this.userTitle.getText().trim().equals("") 
                    || this.userName.getText().trim().equals("") 
                    || this.userEmail.getText().trim().equals(""))
            {
                this.dispose();
            }
            else
            {
                UserProfiles addUser = new UserProfiles();
                addUser.setUserID(this.userProfileName.getText());
                addUser.setUserTitle(this.userTitle.getText());
                addUser.setUserName(this.userName.getText());
                addUser.setUserEmail(this.userEmail.getText());
                UserGroup.getInstance().getUserProfiles().add(addUser);
                this.dispose();
                TabPanel.getInstance().getEditPanels().clear();
                TabPanel.getInstance().removeAll();
                TabPanel.getInstance().update();  
            }
        }
    }
    
}
