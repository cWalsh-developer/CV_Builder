/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Connor
 */
public class Reference 
{
    private List<String> referee1 = new ArrayList();
    private List<String> referee2 = new ArrayList();

    public List<String> getReferee1() {
        return referee1;
    }

    public void setReferee1(List<String> referee1) {
        this.referee1 = referee1;
    }

    public List<String> getReferee2() {
        return referee2;
    }

    public void setReferee2(List<String> referee2) {
        this.referee2 = referee2;
    }
    
    @Override
    public String toString()
    {
        StringBuilder sBuildReference = new StringBuilder();
        for(int i =0; i<referee1.size();i++)
        {
            sBuildReference.append(referee1.get(i)).append("\n");
        }
        for(int j =0; j<referee2.size();j++)
        {
            sBuildReference.append(referee2.get(j)).append("\n");
        }
        return sBuildReference.toString();
    }
}
