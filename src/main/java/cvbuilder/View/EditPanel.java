/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.View;
import cvbuilder.Model.Reference;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import cvbuilder.Model.UserGroup;
import cvbuilder.Model.UserProfiles;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 *
 * @author Connor
 * 
 */
public class EditPanel extends JPanel implements ActionListener
{
    //Defining button group attributes and its getters and setters
   private ButtonGroup buttonGroup = new ButtonGroup();
   private ArrayList<RowPanel> rowPanels = new ArrayList();
   private int infoCounter = 0;
   private JCheckBox include = new JCheckBox("Include");
   private int k = -1;
   JTextField addUser = new JTextField(null,null,23);
   JTextArea addReference = new JTextArea(null,0,11);
   JButton addButton = new JButton("Add");
   JPanel main = new JPanel();
   JPanel mainButton = new JPanel();
   JPanel referenceContainer = new JPanel();
   JPanel includePanel = new JPanel();
   private int n = 0;

    /**
     *
     * @return
     */
    public JCheckBox getInclude() {
        return include;
    }

    /**
     *
     * @return
     */
    public ArrayList<RowPanel> getRowPanels() {
        return rowPanels;
    }

    /**
     *
     * @return
     */
    public ButtonGroup getButtonGroup() {
        return buttonGroup;
    }

    /**
     *
     * @param buttonGroup
     */
    public void setButtonGroup(ButtonGroup buttonGroup) {
        this.buttonGroup = buttonGroup;
    }
    /*Constructor for the edit panels which defines each layout, and uses a for each loop 
    to iterate through different userprofile objects based on the current tab name.
    the data is created into a row panel which is then added to each tabbed window.*/ 

    /**
     *
     * @param tabName
     */
 
    public EditPanel(String tabName)
    {
        if(tabName.equalsIgnoreCase("User"))
        {
            TabPanel userTabPane = new TabPanel("User");
            this.setLayout(null);
            this.setBounds(0,0,WIDTH,HEIGHT);
            userTabPane.setSize(700,845);
            this.add(userTabPane);
        }
        else if(tabName.equalsIgnoreCase("References"))
        {
            TabPanel refreeTabPane = new TabPanel("Referee");
            this.setLayout(null);
            this.setBounds(0,0,WIDTH,HEIGHT);
            refreeTabPane.setSize(700,845);
            this.add(refreeTabPane);
        }
        else if(tabName.equals("User Name"))
        {
            this.setLayout(new FlowLayout(0));
            this.setBorder(new TitledBorder("Name"));
            for (UserProfiles user: UserGroup.getInstance().getUserInfo())
            {
                while(this.infoCounter<=user.getUserName().size()-1)
                {
                    RowPanel rowPanel = new RowPanel(user,null,this,user.getUserName().get(this.infoCounter),0);
                    buttonGroup.add(rowPanel.getRadioButton());
                    this.add(rowPanel);
                    this.rowPanels.add(rowPanel);
                    this.infoCounter++;
                }
                if(this.k ==-1)
                {
                    main.setLayout(new GridLayout(0,2));
                    main.add(addUser);
                    mainButton.add(addButton);
                    main.add(mainButton);
                    this.add(main);
                    this.k++;
                }
            }
        }
        else if (tabName.equals("Email"))
        {
            this.setLayout(new FlowLayout(0));
            this.setBorder(new TitledBorder("Email"));
            for (UserProfiles user: UserGroup.getInstance().getUserInfo())
            {
                 while(this.infoCounter<=user.getUserEmail().size()-1)
                {
                    RowPanel rowPanel = new RowPanel(user,null,this,user.getUserEmail().get(this.infoCounter),0);
                    buttonGroup.add(rowPanel.getRadioButton());
                    this.add(rowPanel);
                    this.rowPanels.add(rowPanel);
                    this.infoCounter++;
                }
                if(this.k ==-1)
                {
                    main.setLayout(new GridLayout(0,2));
                    main.add(addUser);
                    mainButton.add(addButton);
                    main.add(mainButton);
                    this.add(main);
                    this.k++;
                }
            }
        }
        else if (tabName.equals("Title"))
        {
            this.setLayout(new FlowLayout(0));
            this.setBorder(new TitledBorder("Title"));
            includePanel.setLayout(new GridLayout(0,1));
            includePanel.add(this.include, BorderLayout.WEST);
            for (UserProfiles user: UserGroup.getInstance().getUserInfo())
            {
                 while(this.infoCounter<=user.getUserTitle().size()-1)
                {
                    RowPanel rowPanel = new RowPanel(user,null,this,user.getUserTitle().get(this.infoCounter),0);
                    buttonGroup.add(rowPanel.getRadioButton());
                    includePanel.add(rowPanel);
                    this.add(includePanel);
                    this.rowPanels.add(rowPanel);
                    this.infoCounter++;
                }
                if(this.k ==-1)
                {
                    main.setLayout(new GridLayout(0,2));
                    main.add(addUser);
                    mainButton.add(addButton);
                    main.add(mainButton);
                    this.add(main);
                    this.k++;
                }
            }
        }
        else if (tabName.equals("Referee 1"))
        {
            this.setLayout(new FlowLayout(0,0,0));
            this.setBorder(new TitledBorder("Referee 1"));
            includePanel.setLayout(new GridLayout(0,1));
            includePanel.add(this.include,BorderLayout.WEST);
            for (Reference referees:UserGroup.getInstance().getRefereeInfo())
            {
                while(this.infoCounter<=referees.getReferee1().size()-1)
                {
                    RowPanel rowPanel = new RowPanel(null,referees,this,"referee1", this.infoCounter);
                    buttonGroup.add(rowPanel.getRadioButton());
                    this.rowPanels.add(rowPanel);
                    includePanel.add(rowPanels.get(rowPanels.size()-1),BorderLayout.WEST);
                    this.add(includePanel,BorderLayout.NORTH);
                    this.infoCounter++;
                }
            }
            main.setLayout(new BoxLayout(main,BoxLayout.X_AXIS));
            main.add(new JLabel("       "));
            referenceContainer.setLayout(new GridLayout(0,1));
            referenceContainer.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 70));
            referenceContainer.add(addReference);
            mainButton.setLayout(new FlowLayout(0));
            main.add(referenceContainer);
            mainButton.add(addButton);
            main.add(mainButton,BorderLayout.WEST);
            this.k++;
            includePanel.add(main);
            this.add(includePanel);
        }
        else
        {
            this.setLayout(new FlowLayout(0,0,0));
            this.setBorder(new TitledBorder("Referee 2"));
            includePanel.setLayout(new GridLayout(0,1));
            includePanel.add(this.include,BorderLayout.WEST);
            for (Reference referees:UserGroup.getInstance().getRefereeInfo())
            {
                while(this.infoCounter<=referees.getReferee2().size()-1)
                {
                    RowPanel rowPanel = new RowPanel(null,referees,this,"referee2", this.n);
                    rowPanel.setSize(WIDTH, 500);
                    buttonGroup.add(rowPanel.getRadioButton());
                    includePanel.add(rowPanel,BorderLayout.WEST);
                    this.add(includePanel,BorderLayout.NORTH);
                    this.rowPanels.add(rowPanel);
                    this.infoCounter++;
                }
            }
            main.setLayout(new BoxLayout(main,BoxLayout.X_AXIS));
            main.add(new JLabel("       "));
            referenceContainer.setLayout(new GridLayout(0,1));
            referenceContainer.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 70));
            referenceContainer.add(addReference);
            mainButton.setLayout(new FlowLayout(0));
            main.add(referenceContainer);
            mainButton.add(addButton);
            main.add(mainButton,BorderLayout.WEST);
            this.k++;
            includePanel.add(main);
            this.add(includePanel);
        }
        this.addButton.setActionCommand("Add");
        this.addButton.addActionListener(this);
        this.include.setActionCommand("Include");
        this.include.addActionListener(this);
        
    }

    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Add"))
        {
            switch (this.getName()) {
                case "User Name" -> {
                    if(this.addUser.getText()==null || this.addUser.getText().trim().equals(""))
                    {
                        JOptionPane.showMessageDialog(null, "No username was entered! Please enter a username", "ADD USER DATA ERROR!", JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {
                        RowPanel addedName = new RowPanel(UserGroup.getInstance().getUserInfo().get(0),null,this,this.addUser.getText(),0);
                        buttonGroup.add(addedName.getRadioButton());
                        UserGroup.getInstance().getUserInfo().get(0).getUserName().add(this.addUser.getText());
                        this.add(addedName, this.getComponentCount()-1);
                        this.addUser.setText("");
                        this.revalidate();
                        this.repaint();
                    }
                }
                case "User Email" -> {
                    if(this.addUser.getText()==null || this.addUser.getText().trim().equals(""))
                    {
                        JOptionPane.showMessageDialog(null, "No email was entered! Please enter an email", "ADD EMAIL DATA ERROR!", JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {
                        RowPanel addedEmail = new RowPanel(UserGroup.getInstance().getUserInfo().get(0),null,this,this.addUser.getText(),0);
                        buttonGroup.add(addedEmail.getRadioButton());
                        UserGroup.getInstance().getUserInfo().get(0).getUserEmail().add(this.addUser.getText());
                        this.add(addedEmail, this.getComponentCount()-1);
                        this.addUser.setText("");
                        this.revalidate();
                        this.repaint();
                    }
                }
                case "User Title" -> {
                    if(this.addUser.getText() ==null || this.addUser.getText().trim().equals(""))
                    {
                        JOptionPane.showMessageDialog(null, "No title was entered! Please enter a title", "ADD TITLE DATA ERROR!", JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {
                        RowPanel addedTitle = new RowPanel(UserGroup.getInstance().getUserInfo().get(0),null,this,this.addUser.getText(),0);
                        buttonGroup.add(addedTitle.getRadioButton());
                        UserGroup.getInstance().getUserInfo().get(0).getUserTitle().add(this.addUser.getText());
                        this.add(addedTitle, this.getComponentCount()-1);
                        this.addUser.setText("");
                        this.revalidate();
                        this.repaint();
                    }
                }
                case "Referee 1" ->{
                    if(this.addReference.getText()==null || this.addReference.getText().trim().equals(""))
                    {
                        JOptionPane.showMessageDialog(null, "No referee data was entered! Please enter referee data", "ADD REFEREE DATA ERROR!", JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {
                        RowPanel addedReferee1 = new RowPanel(null,UserGroup.getInstance().getRefereeInfo().get(0),this,this.addReference.getText(),0);
                        buttonGroup.add(addedReferee1.getRadioButton());
                        String newReference = this.addReference.getText();
                        newReference = newReference.replace("\n","%%%%");
                        newReference = newReference.replace(",","////");
                        UserGroup.getInstance().getRefereeInfo().get(0).getReferee1().add(newReference);
                        addedReferee1.setBorder(BorderFactory.createEmptyBorder(1, 0, 10, 0));
                        this.main.getParent().add(addedReferee1,this.main.getParent().getComponentCount()-1);
                        this.addReference.setText("");
                        this.revalidate();
                        this.repaint();
                    }
                }
                case "Referee 2" ->{
                    if(this.addReference.getText()==null || this.addReference.getText().trim().equals(""))
                    {
                        JOptionPane.showMessageDialog(null, "No referee data was entered! Please enter referee data", "ADD REFEREE DATA ERROR!", JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {
                        RowPanel addedReferee1 = new RowPanel(null,UserGroup.getInstance().getRefereeInfo().get(0),this,this.addReference.getText(),0);
                        buttonGroup.add(addedReferee1.getRadioButton());
                        String newReference = this.addReference.getText();
                        newReference = newReference.replace("\n","%%%%");
                        newReference = newReference.replace(",","////");
                        UserGroup.getInstance().getRefereeInfo().get(0).getReferee2().add(newReference);
                        addedReferee1.setBorder(BorderFactory.createEmptyBorder(1, 0, 10, 0));
                        this.main.getParent().add(addedReferee1,this.main.getParent().getComponentCount()-1);
                        this.addReference.setText("");
                        this.revalidate();
                        this.repaint();
                    }
                }
                default -> {
                }
            }
        }
        else
        {
            if(this.include.isSelected()&& this.getName().equals("User Title"))
            {
                UserGroup.getInstance().setCvSelectedTitle(UserGroup.getInstance().getCvTitlePlaceholder());
            }
            else if(this.include.isSelected()&& this.getName().equals("Referee 1"))
            {
                UserGroup.getInstance().setCvSelectedReferee1(UserGroup.getInstance().getCvReference1Placeholder());
            }
            else if(this.include.isSelected()&& this.getName().equals("Referee 2"))
            {
                UserGroup.getInstance().setCvSelectedReferee2(UserGroup.getInstance().getCvReference2Placeholder());
            }
            else
            {
                if(this.getName().equals("User Title"))
                {
                    UserGroup.getInstance().setCvSelectedTitle(null);
                }
                else if(this.getName().equals("Referee 1"))
                {
                    UserGroup.getInstance().setCvSelectedReferee1(null);
                }
                else
                {
                    UserGroup.getInstance().setCvSelectedReferee2(null);
                }
            }
        }
    }
}
