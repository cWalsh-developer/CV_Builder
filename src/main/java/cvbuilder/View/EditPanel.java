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
            for (UserProfiles user: UserGroup.getInstance().getUserProfiles())
            {
                RowPanel rowPanel = new RowPanel(user, user.getUserName());
                buttonGroup.add(rowPanel.getRadioButton());
                this.add(rowPanel);
                rowPanel.setBorder(new TitledBorder(user.getUserID()));
                this.rowPanels.add(rowPanel);
            }
        }
        else if (tabName.equals("Email"))
        {
            this.setLayout(new GridLayout(0,1));
            for (UserProfiles user: UserGroup.getInstance().getUserProfiles())
            {
                RowPanel rowPanel = new RowPanel(user, user.getUserEmail());
                buttonGroup.add(rowPanel.getRadioButton());
                this.add(rowPanel);
                rowPanel.setBorder(new TitledBorder(user.getUserID()));
                this.rowPanels.add(rowPanel);
            }
            
        }
        else if (tabName.equals("Title"))
        {
            this.setLayout(new GridLayout(0,1));
            for (UserProfiles user: UserGroup.getInstance().getUserProfiles())
            {
                RowPanel rowPanel = new RowPanel(user, user.getUserTitle());
                buttonGroup.add(rowPanel.getRadioButton());
                this.add(rowPanel);
                rowPanel.setBorder(new TitledBorder(user.getUserID()));
                this.rowPanels.add(rowPanel);
            }
        }
        else if (tabName.equals("ID"))
        {
            this.setLayout(new GridLayout(0,1));
            for (UserProfiles user: UserGroup.getInstance().getUserProfiles())
            {
                RowPanel rowPanel = new RowPanel(user, user.getUserID());
                buttonGroup.add(rowPanel.getRadioButton());
                this.add(rowPanel);
                rowPanel.setBorder(new TitledBorder(user.getUserID()));
                this.rowPanels.add(rowPanel);
            }
            
        }
    }
}
