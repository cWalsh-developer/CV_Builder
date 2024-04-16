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
  JLabel textFieldLabel2 = new JLabel("User Title");
  JLabel textFieldLabel3 = new JLabel("User Name");
  JLabel textFieldLabel4 = new JLabel("User Email");  
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
      this.leftPanel.add(this.textFieldLabel2, BorderLayout.WEST);
      this.leftPanel.add(this.textFieldLabel3, BorderLayout.WEST);
      this.leftPanel.add(this.textFieldLabel4,  BorderLayout.WEST);
      this.mainPanel.add(this.leftPanel);
      
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
            if(this.userTitle.getText().equals("User Title") 
                    || this.userName.getText().equals("User Name") 
                    || this.userEmail.getText().equals("User Email")
                    || this.userTitle.getText().trim().equals("") 
                    || this.userName.getText().trim().equals("") 
                    || this.userEmail.getText().trim().equals(""))
            {
                this.dispose();
            }
            else
            {
                UserGroup.getInstance().getUser().getUserTitle().add(this.userTitle.getText());
                UserGroup.getInstance().getUser().getUserName().add(this.userName.getText());
                UserGroup.getInstance().getUser().getUserEmail().add(this.userEmail.getText());
                System.out.println(UserGroup.getInstance().getUserInfo());
                this.dispose();
                MainViewer.getInstance().setMainTab(new TabPanel("Main"));
            }
        }
    }
    
}
