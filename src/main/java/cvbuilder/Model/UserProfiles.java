/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.Model;

/**
 *
 * @author Connor
 */
public class UserProfiles 
{
    //Defining relevant UserProfile attributes
    private String userName;
    private String userID;
    private String userTitle;
    private String userEmail;
    
//Defining getters and setters for all attributes
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserTitle() {
        return userTitle;
    }

    public void setUserTitle(String userTitle) {
        this.userTitle = userTitle;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    //A toString method that returns a StringBuilder converted to a String object that combines all the relevant attribute data.
    @Override
    public String toString()
    {
        StringBuilder sBuild = new StringBuilder();
        sBuild.append(userID).append("\n").append(userTitle)
                .append("\n").append(userName).append("\n").append(userEmail);
        return sBuild.toString();
    }
}
