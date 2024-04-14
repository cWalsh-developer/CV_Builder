/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.View;

/**
 *
 * @author 
 * This might be useful for defining you Main App Viewer e.g. a JFrame
 */
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class MainViewer extends JFrame implements ActionListener
{
     private static MainViewer instance;
     JButton display = new JButton("Display Profile");
     JButton add = new JButton("Add Profile");
     JPanel bottomPanel = new JPanel();
    /**
     *
     * @throws HeadlessException
     */
    
    public MainViewer() throws HeadlessException
    {
        //Setting main panel border and layout properties and adding a menu bar and tabbed pan to the main window
        this.setTitle("User Profile Builder");
        this.setLayout(new BorderLayout());
        this.setJMenuBar(new MenuBar());
        this.add(TabPanel.getInstance().build());
        this.add(bottomPanel, BorderLayout.SOUTH);
        this.display.setActionCommand("Display");
        this.display.addActionListener(this);
        this.add.setActionCommand("Add");
        this.add.addActionListener(this);
        bottomPanel.add(display);
        bottomPanel.add(add);
    }
    //Singleton reference for the main viewer
     public static MainViewer getInstance()
    {
        if(instance == null)
        {
            instance = new MainViewer();
        }
        return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        //Defining what happens when the display button is selected
        if(e.getActionCommand().equals("Display"))
        {
            //Looping through a list of edit panels and pulling them out
            for(int i=0; i<TabPanel.getInstance().getEditPanels().size();i++)
            {
                EditPanel panels = TabPanel.getInstance().getEditPanels().get(i);
                //Looping through the list of row panels contained in each edit panel
                for(int j=0; j<panels.getRowPanels().size();j++)
                {
                   RowPanel rows = panels.getRowPanels().get(j);
                   //Logic for selecting radio buttons programatically and printing all user profile information to the console.
                   if(rows.getRadioButton().isSelected())
                   {
                       String tabTitle = TabPanel.getInstance().getTitleAt(i);
                       System.out.println(tabTitle+": "+rows.getRadioButton().getText());
                       int rowIndex = TabPanel.getInstance().getEditPanels().get(i).getRowPanels().indexOf(rows);
                       int totalOfTabs = TabPanel.getInstance().getTabCount();
                       for(int t = 0; t <totalOfTabs; t++)
                       {
                           EditPanel editPanels = TabPanel.getInstance().getEditPanels().get(t);
                           editPanels.getRowPanels().get(rowIndex).getRadioButton().setSelected(true);
                       }
                   }
                }
            }
        }
        else
        {
            AddDialog addUserDialog = new AddDialog();
            addUserDialog.setSize(600,200);
            addUserDialog.setVisible(true);
        }
    }
}
