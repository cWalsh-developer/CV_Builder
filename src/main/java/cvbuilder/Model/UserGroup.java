/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.Model;

/**
 *
 * @author 
 * This is model class may be handy for putting data relevant groups of User Profiles in {many Users]
 */
import java.util.List;	  	 	 	      	     	       	   	
import java.util.ArrayList;	  	 	 	      	     	       	   		  	 	 	      	     	       	   	
import java.io.FileReader;	  	 	 	      	     	       	   	
import java.io.BufferedReader;
import javax.swing.JOptionPane;

/**
 *
 * @author Connor
 */
public class UserGroup 
{
    /*Defining a list of user profiles which holds data read from a CSV file
    A singleton pattern is used as only one UserGroup is required. Alongside a list of user data, 
    data for the respective CV reference sections and cv selection choices are stored.*/
    private List<UserProfiles> userInfo = new ArrayList();
    UserProfiles user = new UserProfiles();	  

    private String cvSelectedName;
    private String cvSelectedTitle;
    private String cvSelectedEmail;
    private String cvSelectedReferee1;
    private String cvSelectedReferee2;
    private String cvTitlePlaceholder;
    private String cvReference1Placeholder;
    private String cvReference2Placeholder;
    private List<Reference> refereeInfo = new ArrayList();
    Reference referees = new Reference();	  


    private static UserGroup Instance;
    
    /**
     *
     * @return
     */
    public static UserGroup getInstance()
    {
        if(Instance == null)
        {
            Instance = new UserGroup();
        }
        return Instance;
    }
//Reading the data from the parsed CSV file and adding it to a UserProfiles object which is then stored into the ArayList
//Reference data read from the file is parsed into its own reference model here and manipulated across classes to provide proper display

    /**
     *
     * @param fileName
     */
  public void readCSVFile(String fileName)	  	 	 	      	     	       	   	
  {	  
    try (
            FileReader file = new FileReader(fileName); 	  	 	 	      	     	       	   	
            BufferedReader b = new BufferedReader(file);)
            {
                
      while (b.ready())	  	 	 	      	     	       	   	
      {	  	 	 	      	     	       	   	
        String docLine = b.readLine();
        String[] fields = docLine.split(",");
        if(fields[0].equalsIgnoreCase("user"))
        {
            if(fields[1].equalsIgnoreCase("name"))
            {
                for(int i=2; i<fields.length;i++)
                {
                    user.getUserName().add(fields[i]);
                } 
            }
            else if(fields[1].equalsIgnoreCase("title"))
            {
                for(int i=2; i<fields.length;i++)
                {
                    user.getUserTitle().add(fields[i]);
                } 
            }
            else if(fields[1].equalsIgnoreCase("email"))
            {
                for(int i=2; i<fields.length;i++)
                {
                    user.getUserEmail().add(fields[i]);
                } 
            }
        }
        else
        {
            if(fields[1].equalsIgnoreCase("referee 1"))
            {
                for(int i=2;i<fields.length;i++)
                {
                    referees.getReferee1().add(fields[i]);
                }
            }
            else if(fields[1].equalsIgnoreCase("referee 2"))
            {
                for(int i=2;i<fields.length;i++)
                {
                    referees.getReferee2().add(fields[i]);
                }
            }
        }
      }
            this.getUserInfo().add(user);
            this.getRefereeInfo().add(referees);
    }	  	 	 	      	     	       	   	
    catch(Exception e)	  	 	 	      	     	       	   	
    {	  	 	 	      	     	       	   	
      e.printStackTrace();
    }	  	 	 	      	     	       	   	
  }	  	 	 	      	     	       	   	

    /**
     *
     * @return
     */
    public List<UserProfiles> getUserInfo() {
        return userInfo;
    }

    /**
     *
     * @return
     */
    public String getCvSelectedName() {
        return cvSelectedName;
    }

    /**
     *
     * @param cvSelectedName
     */
    public void setCvSelectedName(String cvSelectedName) {
        this.cvSelectedName = cvSelectedName;
    }

    /**
     *
     * @return
     */
    public String getCvSelectedTitle() {
        return cvSelectedTitle;
    }

    /**
     *
     * @param cvSelectedTitle
     */
    public void setCvSelectedTitle(String cvSelectedTitle) {
        this.cvSelectedTitle = cvSelectedTitle;
    }

    /**
     *
     * @return
     */
    public String getCvSelectedEmail() {
        return cvSelectedEmail;
    }

    /**
     *
     * @param cvSelectedEmail
     */
    public void setCvSelectedEmail(String cvSelectedEmail) {
        this.cvSelectedEmail = cvSelectedEmail;
    }

    /**
     *
     * @return
     */
    public String getCvSelectedReferee1() {
        return cvSelectedReferee1;
    }

    /**
     *
     * @param cvSelectedReference
     */
    public void setCvSelectedReferee1(String cvSelectedReference) {
        this.cvSelectedReferee1 = cvSelectedReference;
    }
    
    /**
     *
     * @return
     */
    public String getCvReference2Placeholder() {
        return cvReference2Placeholder;
    }

    /**
     *
     * @param cvReference2Placeholder
     */
    public void setCvReference2Placeholder(String cvReference2Placeholder) {
        this.cvReference2Placeholder = cvReference2Placeholder;
    }

    /**
     *
     * @return
     */
    public String getCvSelectedReferee2() {
        return cvSelectedReferee2;
    }

    /**
     *
     * @param cvSelectedReferee2
     */
    public void setCvSelectedReferee2(String cvSelectedReferee2) {
        this.cvSelectedReferee2 = cvSelectedReferee2;
    }

    /**
     *
     * @return
     */
    public String getCvReference1Placeholder() {
        return cvReference1Placeholder;
    }

    /**
     *
     * @param cvReferencePlaceholder
     */
    public void setCvReference1Placeholder(String cvReferencePlaceholder) {
        this.cvReference1Placeholder = cvReferencePlaceholder;
    }

    /**
     *
     * @return
     */
    public String getCvTitlePlaceholder() {
        return cvTitlePlaceholder;
    }

    /**
     *
     * @param cvTitlePlaceholder
     */
    public void setCvTitlePlaceholder(String cvTitlePlaceholder) {
        this.cvTitlePlaceholder = cvTitlePlaceholder;
    }

    /**
     *
     * @return
     */
    public List<Reference> getRefereeInfo() {
        return refereeInfo;
    }

    /**
     *
     * @param userInfo
     */
    public void setUserInfo(ArrayList<UserProfiles> userInfo) {
        this.userInfo = userInfo;
    }

    /**
     *
     * @param referees
     */
    public void setReferees(Reference referees) {
        this.referees = referees;
    }

    /**
     *
     * @param user
     */
    public void setUser(UserProfiles user) {
        this.user = user;
    }

    /**
     *
     * @return
     */
    public UserProfiles getUser() {
        return user;
    }
}
