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
public class SystemDonation {
   public List<Organization> orgs=new ArrayList<Organization>();
   public List<Donor> overAllDons=new ArrayList<Donor>();
   public List<Needy> overAllNeedy=new ArrayList<Needy>();
     private static SystemDonation obj; 
     private SystemDonation() {}
     
     public static SystemDonation getInstance() 
    { 
        if (obj==null) 
            obj = new SystemDonation(); 
        return obj; 
    } 
     
    void addDonor(Donor e)
    {
        overAllDons.add(e);
    }
    void addNeedyToSystem(Needy n)
    {
        overAllNeedy.add(n);
    }
    void removeNeedy(String name)
    {
        for(int i=0;i<overAllNeedy.size();i++)
        {
            if(overAllNeedy.get(i).needyPerson.name.equals(name))
            {
                overAllNeedy.remove(i);
                
            }
        
        }
    }
    Needy SearchBeneficiary(String name)
    {
        for(int i=0;i<overAllNeedy.size();i++)
        {
            if(overAllNeedy.get(i).needyPerson.name.equals(name))
            {
                return overAllNeedy.get(i);
            }
        }
        return null;
    }
    
    Donor SearchDonor(String name)
    {
        for(int i=0;i<overAllDons.size();i++)
        {
            if(overAllDons.get(i).donPerson.name.equals(name))
            {
                return overAllDons.get(i);
            }
        }
        return null;
    }
    Projects SearchProjByName(String name)
    {
        Projects temp;
        for(int i=0;i<orgs.size();i++)
        {
            temp=orgs.get(i).checkProjbyProjName(name);
            if(temp!=null)
                return temp;
        }
        return null;
    
    }
    Projects SearchProjByTeamLead(String name)
    {
        Projects temp;
        for(int i=0;i<orgs.size();i++)
        {
            temp=orgs.get(i).checkProjbyTeamLead(name);
            if(temp!=null)
                return temp;
        }
        return null;
    
    }
    
    
    public int confOrg(String name,ArrayList<Volunteer> v)
    {
        Organization o=new Organization();
        o.name=name;
        o.orgVoluns=v;
        return 1;           //success
    }
    
}
