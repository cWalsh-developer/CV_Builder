/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.View;

import java.util.ArrayList;
import javax.swing.JTabbedPane;

/**
 *
 * @author Connor
 */
public class TabPanel extends JTabbedPane
{
    /*A singleton definition is used as there is only one TabbedPanel that is ever required
    edit panel attributes are created and assigned in an update method that can be called whenever a new tabbed panel is required.*/
        private static TabPanel instance;
        private ArrayList<EditPanel> editPanels = new ArrayList();

    
    public TabPanel(String sectionName)
    {
        this.setSize(700,600);
        if(sectionName.equalsIgnoreCase("Main"))
        {
            this.editPanels.add(new EditPanel("User"));
            this.editPanels.add(new EditPanel("References"));
            this.addTab("User",this.editPanels.get(0));
            this.addTab("References",this.editPanels.get(1));
        }
        else if(sectionName.equalsIgnoreCase("User"))
        {
            this.editPanels.add(new EditPanel("User Name"));
            this.editPanels.add(new EditPanel("Email"));
            this.editPanels.add(new EditPanel("Title"));
            
            this.addTab("User Name",this.editPanels.get(0));
            this.addTab("Email",this.editPanels.get(1));
            this.addTab("Title",this.editPanels.get(2));
        }
        else
        {
            this.editPanels.add(new EditPanel("Referee 1"));
            this.editPanels.add(new EditPanel("Referee 2"));
            
            this.addTab("Referee 1", this.editPanels.get(0));
            this.addTab("Referee 2", this.editPanels.get(1));
        }
    }
    
    public TabPanel update()
    {
        this.editPanels.add(new EditPanel("User"));
        this.addTab("User",this.editPanels.get(0));
        return this;
    }
    public ArrayList<EditPanel> getEditPanels() {
        return editPanels;
    }
}
