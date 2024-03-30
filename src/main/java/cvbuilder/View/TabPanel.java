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

    
    public TabPanel update()
    {
            this.editPanels.add(new EditPanel("User Name"));
            this.editPanels.add(new EditPanel("Email"));
            this.editPanels.add(new EditPanel("ID"));
            this.editPanels.add(new EditPanel("Title"));
            
            this.addTab("User Name",this.editPanels.get(0));
            this.addTab("Email",this.editPanels.get(1));
            this.addTab("ID",this.editPanels.get(2));
            this.addTab("Title",this.editPanels.get(3));
            return this;
    }
    public static TabPanel getInstance()
    {
        if(instance == null)
        {
            instance = new TabPanel();
        }
        return instance;
    }

    public ArrayList<EditPanel> getEditPanels() {
        return editPanels;
    }
}
