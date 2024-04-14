/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.View;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import cvbuilder.Model.UserGroup;
import cvbuilder.Model.UserProfiles;

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
        if(tabName.equals("User Name"))
        {
            this.setLayout(new GridLayout(0,1));
            System.out.println(UserGroup.getInstance().getUserInfo().size());
            for (UserProfiles user: UserGroup.getInstance().getUserInfo())
            {
                if(this.infoCounter<=user.getUserName().size()-1)
                {
                    RowPanel rowPanel = new RowPanel(user,user.getUserName().get(this.infoCounter));
                    buttonGroup.add(rowPanel.getRadioButton());
                    this.add(rowPanel);
                    rowPanel.setBorder(new TitledBorder("Name"));
                    this.rowPanels.add(rowPanel);
                    this.infoCounter++;
                }
            }
        }
        else if (tabName.equals("Email"))
        {
            this.setLayout(new GridLayout(0,1));
            for (UserProfiles user: UserGroup.getInstance().getUserInfo())
            {
                if(this.infoCounter<=user.getUserEmail().size()-1)
                {
                    RowPanel rowPanel = new RowPanel(user, user.getUserEmail().get(this.infoCounter));
                    buttonGroup.add(rowPanel.getRadioButton());
                    this.add(rowPanel);
                    rowPanel.setBorder(new TitledBorder("Email"));
                    this.rowPanels.add(rowPanel);
                    this.infoCounter++;
                }
            }
        }
        else if (tabName.equals("Title"))
        {
            this.setLayout(new GridLayout(0,1));
            for (UserProfiles user: UserGroup.getInstance().getUserInfo())
            {
                if(this.infoCounter<=user.getUserTitle().size()-1)
                {
                    RowPanel rowPanel = new RowPanel(user, user.getUserTitle().get(this.infoCounter));
                    System.out.println(user.getUserTitle());
                    buttonGroup.add(rowPanel.getRadioButton());
                    this.add(rowPanel);
                    rowPanel.setBorder(new TitledBorder("Title"));
                    this.rowPanels.add(rowPanel);
                    this.infoCounter++;
                }
            }
        }
    }
}
