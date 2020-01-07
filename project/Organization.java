/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Faizan
 */
public class Organization {
    public String name;
    public List<Projects> projs=new ArrayList<Projects>();
    public List<Volunteer> orgVoluns=new ArrayList<Volunteer>();
    
    
    
    //boolean AddProj(Organization o,String pName,String projDesc,int reqBud)
    //{
       // Projects p=new Projects();
        //return p.addProject(o,pName, projDesc, reqBud);    
   // }
    Volunteer SearchVoluns(String nameSearch)
    {
        Volunteer temp;
            for(int i=0;i<orgVoluns.size();i++)
            {
                if(orgVoluns.get(i).vol.name.equalsIgnoreCase(nameSearch))
                {
               
                        return orgVoluns.get(i);
                
                }
            }
            return null;
    }
    Projects checkProjbyProjName(String name)
    {
       for(int i=0;i<projs.size();i++)
        {
            
            if(projs.get(i).projName==name)
                return projs.get(i);
            
        }
       return null;
    }
    
    Projects checkProjbyTeamLead(String name)
    {
       for(int i=0;i<projs.size();i++)
        {
            
            if(projs.get(i).teamLead.vol.name.equals(name))
                return projs.get(i);
            
        }
       return null;
    }
    
    
    
}
