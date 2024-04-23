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
    /*A single constructor with multiple conditional statements helps to develop the appropraite tab panels and edit panels*/
        private ArrayList<EditPanel> editPanels = new ArrayList();
        private ArrayList<EditPanel> userEditPanels = new ArrayList();
    
    /**
     *
     * @param sectionName
     */
    public TabPanel(String sectionName)
    {
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
            
            this.editPanels.get(0).setName("User Name");
            this.editPanels.get(1).setName("User Email");
            this.editPanels.get(2).setName("User Title");
            
            this.addTab("User Name",this.editPanels.get(0));
            this.addTab("Email",this.editPanels.get(1));
            this.addTab("Title",this.editPanels.get(2));
        }
        else if(sectionName.equalsIgnoreCase("Referee"))
        {
            this.editPanels.add(new EditPanel("Referee 1"));
            this.editPanels.add(new EditPanel("Referee 2"));
            
            this.editPanels.get(0).setName("Referee 1");
            this.editPanels.get(1).setName("Referee 2");
            
            this.addTab("Referee 1", this.editPanels.get(0));
            this.addTab("Referee 2", this.editPanels.get(1));
        }
    }

    /**
     *
     * @return
     */
    public ArrayList<EditPanel> getEditPanels() {
        return editPanels;
    }

    /**
     *
     * @return
     */
    public ArrayList<EditPanel> getUserEditPanels() {
        return userEditPanels;
    }
}
