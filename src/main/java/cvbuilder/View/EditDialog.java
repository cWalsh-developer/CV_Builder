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
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Connor
 */
public class EditDialog extends JDialog implements ActionListener
{
  JPanel mainPanel = new JPanel();
  JPanel bottomPanel = new JPanel();
  JPanel leftPanel = new JPanel();
  JPanel rightPanel = new JPanel();
  JLabel textFieldLabel2 = new JLabel("Edit Referee");
  JTextArea refereeInfo = new JTextArea(null,null,100,40);  
  JButton okay = new JButton("OK");
  JButton cancel = new JButton("Cancel");
  RowPanel currentRowPanel;
  
    /**
     *
     * @param text
     * @param currentRowPanel
     */
  /*Constructing a dialog box to allow reference data editing*/
    public EditDialog(String text, RowPanel currentRowPanel)
  {
      this.currentRowPanel = currentRowPanel;
      this.refereeInfo.setText(text);
      this.setTitle("Edit References");
      this.mainPanel.setLayout(new BoxLayout(this.mainPanel,BoxLayout.Y_AXIS));
      this.leftPanel.add(this.textFieldLabel2, BorderLayout.CENTER);
      this.mainPanel.add(this.leftPanel);
      
      this.rightPanel.add(this.refereeInfo,BorderLayout.CENTER);
      this.mainPanel.add(this.rightPanel);
      this.bottomPanel.add(this.okay);
      this.bottomPanel.add(this.cancel);
      this.okay.addActionListener(this);
      this.cancel.addActionListener(this);
      this.okay.setActionCommand("OK");
      this.cancel.setActionCommand("Cancel");
      this.add(this.mainPanel);
      this.add(this.bottomPanel, BorderLayout.SOUTH);
      this.setSize(1000, 300);
  }
    
    /**
     *
     * @param e
     */
    /*Action listeners handling whhat to do when cancel is selected and when "OK" is selected.
    Data is updated on the view and in the data model upon editing from here.*/
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getActionCommand().equals("Cancel"))
        {
            this.dispose();
        }
        else
        {
            if(this.refereeInfo.getText().trim().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Invalid Input! Field cannot be left empty", "Invalid Input Error", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                if(this.currentRowPanel.getParent().getParent().getName().equals("Referee 1"))
                {
                    String oldText = this.currentRowPanel.getRefereeInfo().getText().replace("\n", "%%%%");
                    oldText = oldText.replace(",", "////");
                    this.currentRowPanel.getRefereeInfo().setText(this.refereeInfo.getText());
                    String editedText = this.currentRowPanel.getRefereeInfo().getText().replace("\n", "%%%%");
                    editedText = editedText.replace(",", "////");
                    int oldIndex = UserGroup.getInstance().getRefereeInfo().get(0).getReferee1().indexOf(oldText);
                    UserGroup.getInstance().getRefereeInfo().get(0).getReferee1().set(oldIndex, editedText);
                    this.dispose();
                    
                }
                else
                {
                    String oldText = this.currentRowPanel.getRefereeInfo().getText().replace("\n", "%%%%");
                    oldText = oldText.replace(",", "////");
                    this.currentRowPanel.getRefereeInfo().setText(this.refereeInfo.getText());
                    String editedText = this.currentRowPanel.getRefereeInfo().getText().replace("\n", "%%%%");
                    editedText = editedText.replace(",", "////");
                    int oldIndex = UserGroup.getInstance().getRefereeInfo().get(0).getReferee2().indexOf(oldText);
                    UserGroup.getInstance().getRefereeInfo().get(0).getReferee2().set(oldIndex, editedText);
                    this.dispose();
                }
            }
        }
    }
    
}
