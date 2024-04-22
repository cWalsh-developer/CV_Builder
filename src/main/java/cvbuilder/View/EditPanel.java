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
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;


/**
 *
 * @author Connor
 */
public class EditPanel extends JPanel implements ActionListener
{
    //Defining button group attributes and its getters and setters
   private ButtonGroup buttonGroup = new ButtonGroup();
   private ArrayList<RowPanel> rowPanels = new ArrayList();
   private int infoCounter = 0;
   private JCheckBox include = new JCheckBox("Include");
   private int k = -1;
   private EditPanel thisInstance = this;
   JTextField addUser = new JTextField(null,null,23);
   JTextArea addReference = new JTextArea(null,0,11);
   JButton addButton = new JButton("Add");
   JPanel main = new JPanel();
   JPanel mainButton = new JPanel();
   JPanel referenceContainer = new JPanel();
   JPanel includePanel = new JPanel();

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
                    RowPanel rowPanel = new RowPanel(user,user.getUserName().get(this.infoCounter),0);
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
                    RowPanel rowPanel = new RowPanel(user,user.getUserEmail().get(this.infoCounter),0);
                    buttonGroup.add(rowPanel.getRadioButton());
                    this.add(rowPanel);
                    this.rowPanels.add(rowPanel);
                    this.infoCounter++;
                }
                if(this.k ==-1)
                {
//                    RowPanel addUser = new RowPanel(user,null,this.k,this.thisInstance); 
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
            JPanel includePanel = new JPanel();
            includePanel.setLayout(new GridLayout(0,1));
            includePanel.add(this.include, BorderLayout.WEST);
            for (UserProfiles user: UserGroup.getInstance().getUserInfo())
            {
                 while(this.infoCounter<=user.getUserTitle().size()-1)
                {
                    RowPanel rowPanel = new RowPanel(user,user.getUserTitle().get(this.infoCounter),0);
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
            JPanel includePanel = new JPanel();
            includePanel.setLayout(new GridLayout(0,1));
            includePanel.add(this.include,BorderLayout.WEST);
            int n = 0;
            for (int i =0;i<=UserGroup.getInstance().getRefereeInfo().size();i++)
            {
                    RowPanel rowPanel = new RowPanel(null,"referee1", n);
                    buttonGroup.add(rowPanel.getRadioButton());
                    this.rowPanels.add(rowPanel);
                    includePanel.add(rowPanels.get(rowPanels.size()-1),BorderLayout.WEST);
                    this.add(includePanel,BorderLayout.NORTH);
                    n++;
            }
//                    RowPanel addUser = new RowPanel(user,null,this.k,this.thisInstance); 
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
            int n = 0;
            for (int i =0;i<=UserGroup.getInstance().getRefereeInfo().size();i++)
            {
                    RowPanel rowPanel = new RowPanel(null,"referee2", n);
                    rowPanel.setSize(WIDTH, 500);
                    buttonGroup.add(rowPanel.getRadioButton());
                    includePanel.add(rowPanel,BorderLayout.WEST);
                    this.add(includePanel,BorderLayout.NORTH);
                    this.rowPanels.add(rowPanel);
                    n++;
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Add"))
        {
            switch (this.getName()) {
                case "User Name" -> {
                    RowPanel addedName = new RowPanel(UserGroup.getInstance().getUserInfo().get(0),this.addUser.getText(),0);
                    buttonGroup.add(addedName.getRadioButton());
                    this.add(addedName, this.getComponentCount()-1);
                    this.revalidate();
                    this.repaint();
                }
                case "User Email" -> {
                    RowPanel addedEmail = new RowPanel(UserGroup.getInstance().getUserInfo().get(0),this.addUser.getText(),0);
                    buttonGroup.add(addedEmail.getRadioButton());
                    this.add(addedEmail, this.getComponentCount()-1);
                    this.revalidate();
                    this.repaint();
                }
                case "User Title" -> {
                    RowPanel addedTitle = new RowPanel(UserGroup.getInstance().getUserInfo().get(0),this.addUser.getText(),0);
                    buttonGroup.add(addedTitle.getRadioButton());
                    this.add(addedTitle, this.getComponentCount()-1);
                    this.revalidate();
                    this.repaint();
                }
                case "Referee 1" ->                     {
                        //                System.out.println(this.main.getParent().getComponentCount());
                        RowPanel addedReferee1 = new RowPanel(null,this.addReference.getText(),0);
                        buttonGroup.add(addedReferee1.getRadioButton());
                        addedReferee1.setBorder(BorderFactory.createEmptyBorder(1, 0, 10, 0));
                        this.main.getParent().add(addedReferee1,this.main.getParent().getComponentCount()-1);
                        this.addReference.setText("");
                        this.revalidate();
                        this.repaint();
                    }
                case "Referee 2" ->                     {
                        //                System.out.println(this.main.getParent().getComponentCount());
                        RowPanel addedReferee1 = new RowPanel(null,this.addReference.getText(),0);
                        buttonGroup.add(addedReferee1.getRadioButton());
                        addedReferee1.setBorder(BorderFactory.createEmptyBorder(1, 0, 10, 0));
                        this.main.getParent().add(addedReferee1,this.main.getParent().getComponentCount()-1);
                        this.addReference.setText("");
                        this.revalidate();
                        this.repaint();
                    }
                default -> {
                }
            }
        }
    }
}
