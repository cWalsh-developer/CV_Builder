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
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class MainViewer extends JFrame implements ActionListener
{
     private static MainViewer instance;
     private int currentTab;
     JButton display = new JButton("Previous");
     JButton add = new JButton("Next");
     JPanel bottomPanel = new JPanel();
     JPanel previousButtonPanel = new JPanel();
     JPanel nextButtonPanel = new JPanel();
     TabPanel mainTab = new TabPanel("Main");


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
        this.add(this.mainTab);
//        bottomPanel.setLayout(new GridLayout(0,1));
        previousButtonPanel.setLayout(new GridLayout(0,4));
        previousButtonPanel.add(display);
        nextButtonPanel.add(add);
        bottomPanel.add(previousButtonPanel);
        bottomPanel.add(nextButtonPanel);
        this.add(bottomPanel, BorderLayout.SOUTH);
        this.display.setActionCommand("Next");
        this.display.addActionListener(this);
        this.add.setActionCommand("Previous");
        this.add.addActionListener(this);
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
    public void setMainTab(TabPanel mainTab) {
        this.remove(this.mainTab);
        this.mainTab = mainTab;
        this.add(this.mainTab);
        this.revalidate();
        this.repaint();
    }
    public TabPanel getMainTab() {
        return mainTab;
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        //Defining what happens when the add button is selected
        if(e.getActionCommand().equals("Next"))
        {
            this.currentTab = this.getMainTab().getSelectedIndex();
            if(currentTab == 1)
            {
                this.getMainTab().setSelectedIndex(0);
            }
        }
        else
        {
            this.currentTab = this.getMainTab().getSelectedIndex();
            if(this.currentTab == 0)
            {
                this.getMainTab().setSelectedIndex(1);
            }
        }
    }
}
