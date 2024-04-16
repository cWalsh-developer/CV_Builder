/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.View;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import cvbuilder.Model.UserGroup;
import cvbuilder.Model.UserProfiles;
import javax.swing.JCheckBox;

/**
 *
 * @author Connor
 */
public class EditPanel extends JPanel
{
    //Defining button group attributes and its getters and setters
   private ButtonGroup buttonGroup = new ButtonGroup();
   private ArrayList<RowPanel> rowPanels = new ArrayList();
   private int infoCounter = 0;
   private JCheckBox include = new JCheckBox("Include");

    public JCheckBox getInclude() {
        return include;
    }

    public ArrayList<RowPanel> getRowPanels() {
        return rowPanels;
    }

    public ButtonGroup getButtonGroup() {
        return buttonGroup;
    }

    public void setButtonGroup(ButtonGroup buttonGroup) {
        this.buttonGroup = buttonGroup;
    }
    /*Constructor for the edit panels which defines a grid layout, and uses a for each loop 
    to iterate through different userprofile objects based on the current tab name.
    the data is created into a row panel which is then added to each tabbed window.*/ 
    public EditPanel(String tabName)
    {
        if(tabName.equalsIgnoreCase("User"))
        {
            TabPanel userTabPane = new TabPanel("User");
            this.setLayout(null);
            this.setBounds(0,0,100,100);
            userTabPane.setSize(570,470);
            this.add(userTabPane);
        }
        else if(tabName.equalsIgnoreCase("References"))
        {
            TabPanel refreeTabPane = new TabPanel("Referee");
            this.setLayout(null);
            this.setBounds(0,0,100,100);
            refreeTabPane.setSize(570,470);
            this.add(refreeTabPane);
        }
        else if(tabName.equals("User Name"))
        {
            this.setLayout(new GridLayout(0,1));
            this.setBorder(new TitledBorder("Name"));
            for (UserProfiles user: UserGroup.getInstance().getUserInfo())
            {
                while(this.infoCounter<=user.getUserName().size()-1)
                {
                    RowPanel rowPanel = new RowPanel(user,user.getUserName().get(this.infoCounter));
                    buttonGroup.add(rowPanel.getRadioButton());
                    this.add(rowPanel);
                    this.rowPanels.add(rowPanel);
                    this.infoCounter++;
                }
            }
        }
        else if (tabName.equals("Email"))
        {
            this.setLayout(new GridLayout(0,1));
            this.setBorder(new TitledBorder("Email"));
//            this.infoCounter = 0;
            for (UserProfiles user: UserGroup.getInstance().getUserInfo())
            {
                 while(this.infoCounter<=user.getUserEmail().size()-1)
                {
                    RowPanel rowPanel = new RowPanel(user,user.getUserEmail().get(this.infoCounter));
                    buttonGroup.add(rowPanel.getRadioButton());
                    this.add(rowPanel);
                    this.rowPanels.add(rowPanel);
                    this.infoCounter++;
                }
            }
        }
        else if (tabName.equals("Title"))
        {
            this.setLayout(new GridLayout(0,1));
            this.setBorder(new TitledBorder("Title"));
            JPanel includePanel = new JPanel();
            includePanel.setLayout(null);
            includePanel.setBounds(0, 0, WIDTH, HEIGHT);
            this.include.setSize(100, 20);
            includePanel.add(this.include, BorderLayout.WEST);
            this.add(includePanel);
            for (UserProfiles user: UserGroup.getInstance().getUserInfo())
            {
                 while(this.infoCounter<=user.getUserTitle().size()-1)
                {
                    RowPanel rowPanel = new RowPanel(user,user.getUserTitle().get(this.infoCounter));
                    buttonGroup.add(rowPanel.getRadioButton());
                    this.add(rowPanel);
                    this.rowPanels.add(rowPanel);
                    this.infoCounter++;
                }
            }
        }
        else if (tabName.equals("Referee 1"))
        {
            this.setLayout(new GridLayout(0,1));
            this.setBorder(new TitledBorder("Referee 1"));
            JPanel includePanel = new JPanel();
            includePanel.setLayout(new GridLayout(0,2));
            JCheckBox include = new JCheckBox("Include");
            includePanel.add(include, BorderLayout.WEST);
            this.add(includePanel, BorderLayout.PAGE_START);
            for (UserProfiles user: UserGroup.getInstance().getUserInfo())
            {
                 while(this.infoCounter<=user.getUserTitle().size()-1)
                {
                    RowPanel rowPanel = new RowPanel(user,user.getUserTitle().get(this.infoCounter));
                    buttonGroup.add(rowPanel.getRadioButton());
                    this.add(rowPanel);
                    this.rowPanels.add(rowPanel);
                    this.infoCounter++;
                }
            }
        }
        
    }
}
