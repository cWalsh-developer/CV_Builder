/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.Model;
import java.util.ArrayList;
/**
 *
 * @author Connor
 */
public class UserProfiles 
{
    //Defining relevant UserProfile attributes
    private ArrayList<String> userName = new ArrayList();
    private ArrayList<String> userTitle = new ArrayList();
    private ArrayList<String> userEmail = new ArrayList();
    
//Defining getters and setters for all attributes

    /**
     *
     * @return
     */
    public ArrayList<String> getUserName() {
        return userName;
    }

//    public void setUserName(ArrayList<String> userName) {
//        this.userName = userName;
//    }

    /**
     *
     * @return
     */

    public ArrayList<String> getUserTitle() {
        return userTitle;
    }

    /**
     *
     * @param userTitle
     */
    public void setUserTitle(ArrayList<String> userTitle) {
        this.userTitle = userTitle;
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getUserEmail() {
        return userEmail;
    }

    /**
     *
     * @param userEmail
     */
    public void setUserEmail(ArrayList<String> userEmail) {
        this.userEmail = userEmail;
    }
    //A toString method that returns a StringBuilder converted to a String object that combines all the relevant attribute data.

    /**
     *
     * @return
     */
    @Override
    public String toString()
    {
        StringBuilder sBuild = new StringBuilder();
        for(int i=0; i<userName.size();i++)
        {
            sBuild.append(userName.get(i)).append("\n");
            
        }
        for(int j=0; j<userTitle.size();j++)
        {
            sBuild.append(userTitle.get(j)).append("\n");
        }
        for(int k=0; k<userEmail.size();k++)
        {
            sBuild.append(userEmail.get(k)).append("\n");
        }
            
        return sBuild.toString();
    }
}
