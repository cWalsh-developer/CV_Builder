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
    private List<UserProfiles> userInfo = new ArrayList();
    UserProfiles user = new UserProfiles();	  

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
                    this.getUserInfo().add(user);
        }
        else
        {
            //TODO: Start importing the reference data
        }
      }
    }	  	 	 	      	     	       	   	
    catch(Exception e)	  	 	 	      	     	       	   	
    {	  	 	 	      	     	       	   	
      e.printStackTrace();	  	 	 	      	     	       	   	
    }	  	 	 	      	     	       	   	
  }	  	 	 	      	     	       	   	
    public List<UserProfiles> getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(ArrayList<UserProfiles> userInfo) {
        this.userInfo = userInfo;
    }
    public UserProfiles getUser() {
        return user;
    }
}
