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

public class UserGroup 
{
    /*Defining a list of user profiles which holds data read from a CSV file
    A singleton pattern is used as only one UserGroup is required.*/
    private List<UserProfiles> userProfiles = new ArrayList();	    
    private static UserGroup Instance;
    
    public static UserGroup getInstance()
    {
        if(Instance == null)
        {
            Instance = new UserGroup();
        }
        return Instance;
    }
//Reading the data from the parsed CSV file and adding it to a UserProfiles object which is then stored into the ArayList	  	 	 	      	     	       	   	
  public void readCSVFile(String secondFileName)	  	 	 	      	     	       	   	
  {	  	 	 	      	     	       	   	
    try (
            FileReader file = new FileReader(secondFileName); 	  	 	 	      	     	       	   	
            BufferedReader b = new BufferedReader(file);)
            {	  	 	 	      	     	       	   	
      while (b.ready())	  	 	 	      	     	       	   	
      {	  	 	 	      	     	       	   	
        String docLine = b.readLine();
        String[] fields = docLine.split(",");
        UserProfiles user = new UserProfiles();	  	 	 	      	     	       	   	
        user.setUserID(fields[0]);
        user.setUserTitle(fields[1]);
        user.setUserName(fields[2]);
//        user.setUserEmail(fields[3]);
        this.getUserProfiles().add(user);  	 	 	      	     	       	   	
      }
    }	  	 	 	      	     	       	   	
    catch(Exception e)	  	 	 	      	     	       	   	
    {	  	 	 	      	     	       	   	
      e.printStackTrace();	  	 	 	      	     	       	   	
    }	  	 	 	      	     	       	   	
  }	  	 	 	      	     	       	   	
  //Getters and setters for the UserProfiles ArrayList
    public List<UserProfiles> getUserProfiles() 
    {
        return userProfiles;
    }

    public void setUserProfiles(List<UserProfiles> userProfile) 
    {
        this.userProfiles = userProfile;
    }
}
