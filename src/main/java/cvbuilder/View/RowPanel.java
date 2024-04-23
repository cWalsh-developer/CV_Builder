/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.View;

import cvbuilder.Model.Reference;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import cvbuilder.Model.UserGroup;
import cvbuilder.Model.UserProfiles;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;


/**
 *
 * @author Connor
 * 
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
    JTextArea refereeInfo = new JTextArea();

    /**
     *
     * @return
     */
    public JTextArea getRefereeInfo() {
        return refereeInfo;
    }

    /**
     *
     * @param refereeInfo
     */
    public void setRefereeInfo(JTextArea refereeInfo) {
        this.refereeInfo = refereeInfo;
    }
    JPanel referenceContainer = new JPanel();
    
    //creating an attribute to store the userprofile that is pulled through the constructor
    private UserProfiles users;
    private Reference referees;
    private EditPanel current;
    private String name;
    private int tabNum;
    private ArrayList<JRadioButton> radioButtons = new ArrayList();
    private String newText = null;
    private String deleteText = null;

    /**
     *
     * @return
     */
    public int getTabNum() {
        return tabNum;
    }
    
//Getters and setters for the panel buttons

    /**
     *
     * @return
     */
    public JButton getEdit() {
        return edit;
    }

    /**
     *
     * @param edit
     */
    public void setEdit(JButton edit) {
        this.edit = edit;
    }

    /**
     *
     * @return
     */
    public JButton getDelete() {
        return delete;
    }

    /**
     *
     * @param delete
     */
    public void setDelete(JButton delete) {
        this.delete = delete;
    }

    /**
     *
     * @return
     */
    public JRadioButton getRadioButton() {
        return radioButton;
    }

    /**
     *
     * @param radioButton
     */
    public void setRadioButton(JRadioButton radioButton) {
        this.radioButton = radioButton;
    }
    /*RowPanel constructor which sets the users attribute to the current profile
    sets radiobutton text and action commands and listeners to the delete and edit buttons.*/

    /**
     *
     * @param profiles
     * @param referee
     * @param currentPanel
     * @param name
     * @param n
     */

    public RowPanel(UserProfiles profiles, Reference referee, EditPanel currentPanel, String name, int n)
    {
        this.current = currentPanel;
        this.users = profiles;
        this.referees = referee;
        this.name = name;
        
        if(profiles!=null)
        {
          radioButton.setText(name);
          mainPanel.add(radioButton);
        }
        else
        {
            if(name.equals("referee1"))
            {
                String replace = UserGroup.getInstance().getRefereeInfo().get(0).getReferee1().get(n).replace("%%%%", "\n");
                String replaceFinal = replace.replace("////", ",");
                refereeInfo.setText(replaceFinal);
                mainPanel.add(radioButton);
                referenceContainer.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
                referenceContainer.setLayout(new GridLayout(0,1));
                referenceContainer.add(refereeInfo);
                mainPanel.add(referenceContainer);    
            }
            else if(name.equals("referee2"))
            {
                String replace = UserGroup.getInstance().getRefereeInfo().get(0).getReferee2().get(n).replace("%%%%", "\n");
                String replaceFinal = replace.replace("////", ",");
                refereeInfo.setText(replaceFinal);
                mainPanel.add(radioButton);
                referenceContainer.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
                referenceContainer.setLayout(new GridLayout(0,1));
                referenceContainer.add(refereeInfo);
                mainPanel.add(referenceContainer);

            }
            else
            {
                refereeInfo.setText(name);
                mainPanel.add(radioButton);
                mainPanel.add(refereeInfo);
            }
            
        }
        this.setLayout(new GridLayout(0,2));
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.X_AXIS));
        
        buttonPanel.setLayout(new GridLayout(0,2));
        innerButtonPanel.add(edit);
        innerButtonPanel.add(delete);
        buttonPanel.add(innerButtonPanel);
        this.add(mainPanel);
        this.add(buttonPanel);
        edit.setActionCommand("Edit");
        delete.setActionCommand("Delete");
        edit.addActionListener(this);
        delete.addActionListener(this);
        radioButton.setActionCommand("Radio");
        radioButton.addActionListener(this);
        
    }
    
    /*Action method which enables the user to update existing user details or delete them*/

    /**
     *
     * @param e
     */

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getActionCommand().equals("Edit"))
        {
            if(this.radioButton.getText() == null || this.radioButton.getText().trim().equals(""))
            {
                EditDialog editBox = new EditDialog(this.refereeInfo.getText(), this);
                editBox.setVisible(true);
            }
            else
            {
               this.newText = JOptionPane.showInputDialog(this, "Enter New Text:", this.radioButton.getText());
            }
            if(this.newText == null || this.newText.equals("") || this.newText.trim().equals(""))
            {
                if(this.radioButton.getText()!=null)
                {
                    this.radioButton.setText(this.radioButton.getText());
                }
                else
                {
                    this.refereeInfo.setText(this.refereeInfo.getText());
                }
            }
            else
            {
                if(users.getUserName().contains(this.radioButton.getText()))
                {
                    int index = users.getUserName().indexOf(this.radioButton.getText());
                    this.radioButton.setText(newText);
                    this.users.getUserName().set(index, newText);
                }
                else if(users.getUserEmail().contains(this.radioButton.getText()))
                {
                    int index = users.getUserEmail().indexOf(this.radioButton.getText());
                    this.radioButton.setText(newText);
                    this.users.getUserEmail().set(index, newText);
                }
                else if(users.getUserTitle().contains(this.radioButton.getText()))
                {
                    int index = users.getUserTitle().indexOf(this.radioButton.getText());
                    this.radioButton.setText(newText);
                    this.users.getUserTitle().set(index, newText);
                }
                else if(users.getUserTitle().contains(this.radioButton.getText()))
                {
                    int index = users.getUserTitle().indexOf(this.radioButton.getText());
                    this.radioButton.setText(newText);
                    this.users.getUserTitle().set(index, newText);
                }
                else
                {
                    System.out.println("No element found");
                }
            }
        }
        else if (e.getActionCommand().equals("Delete"))
        {
            if(this.users==null)
            {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you would like to delete \n"+this.refereeInfo.getText()+"?", 
                        "Are You Sure?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(option == JOptionPane.YES_OPTION)
                {
                    String convertedText = this.refereeInfo.getText().replace("\n", "%%%%");
                    convertedText = convertedText.replace(",", "////");
                    if(this.referees.getReferee1().contains(convertedText))
                    {
                        this.referees.getReferee1().remove(convertedText);
                    }
                    else if(this.referees.getReferee2().contains(convertedText))
                    {
                        this.referees.getReferee2().remove(convertedText);
                    }
                    this.rowPanelEditor = this.getParent();
                    this.getParent().remove(this);
                    this.rowPanelEditor.revalidate();
                    this.rowPanelEditor.repaint();
                }
                else
                {
                    JOptionPane.getRootFrame().dispose();
                }
            }
            else
            {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you would like to delete "+this.radioButton.getText()+"?", 
                        "Are You Sure?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(option == JOptionPane.NO_OPTION)
                {
                    JOptionPane.getRootFrame().dispose();
                }
                else if(option == JOptionPane.YES_OPTION)
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
                else
                {
                    JOptionPane.getRootFrame().dispose();
                }
            }
        }
        else if(e.getActionCommand().equals("Radio"))
        {
            if (this.radioButton.getText()==null || this.radioButton.getText().trim().equals(""))
            {
                if(this.current.getName().equals("Referee 1"))
                {
                    UserGroup.getInstance().setCvReference1Placeholder(this.refereeInfo.getText());
                    if(this.current.getInclude().isSelected())
                    {
                        UserGroup.getInstance().setCvSelectedReferee1(this.refereeInfo.getText());
                    }
                }
                else
                {
                    UserGroup.getInstance().setCvReference2Placeholder(this.refereeInfo.getText());
                    if(this.current.getInclude().isSelected())
                    {
                        UserGroup.getInstance().setCvSelectedReferee2(this.refereeInfo.getText());
                    } 
                }
            }
            else
            {
                if(this.current.getInclude().isShowing())
                {
                    UserGroup.getInstance().setCvTitlePlaceholder(this.radioButton.getText());
                    if(this.current.getInclude().isSelected())
                    {
                        UserGroup.getInstance().setCvSelectedTitle(this.radioButton.getText());
                    }
                }
                else
                {
                    if(this.current.getName().equalsIgnoreCase("User Name"))
                    {
                        UserGroup.getInstance().setCvSelectedName(this.radioButton.getText());
                    }
                    else
                    {
                        UserGroup.getInstance().setCvSelectedEmail(this.getRadioButton().getText());
                    }
                }
            }
        }
    }
    
}
