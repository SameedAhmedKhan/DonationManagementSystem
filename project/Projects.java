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
public class Projects {
    Organization o=new Organization();
   public String projName;
   public   String desc;
    int collectedAmount=0;
    int requiredBudget;
   public FundsCollection collection=new FundsCollection();
   public FundsDisbursement disbursement=new FundsDisbursement();
    public Volunteer teamLead=null;
    public List<Volunteer> teamMembers=new ArrayList<Volunteer>();
    
    public Projects(Organization o,String pName,String projDesc,int cAmount,int reqBud)
    {
        this.o=o;
        projName=pName;
        desc=projDesc;
        requiredBudget=reqBud;
        collectedAmount=cAmount;
       
    }
    
    
    public boolean addProject(Organization o,String pName,String projDesc,int reqBud)
    {
        this.o=o;
        projName=pName;
        desc=projDesc;
        requiredBudget=reqBud;
        return true;
    }
    Volunteer findVolun(String vName)
    {
        for(int i=0;i<teamMembers.size();i++)
        {
            if(teamMembers.get(i).vol.name.equals(vName))
            {
                return teamMembers.get(i);
            }
        
        }
        if(teamLead.vol.name.equals(vName))
        {
            return teamLead;
        }
        return null;
    }
    int addTeamMembers(Volunteer V)
    {//Checked that volunteer is new
                boolean flag=false;
          /*  for(int i=0;i<o.orgVoluns.size();i++)
                {
                        if(o.orgVoluns.get(i)==V)
                        {
                            if(V.isAvailable==true)
                                flag=true;
                        }
                    
                }
            if(flag==false)
                return -3;                   //no such volunteer or volunteer bzy
                                  
                if(V.isAvailable==false)
                {
                    return -2;                  //volunteer not available
                }
*/
                teamMembers.add(V);
                return 1;                
    }
    int addListOfTeamMembers(List<Volunteer> V)
    {
                if(teamLead==null)
                    return -1;                     //no TEAM LEAD YES SO CANNOT ADD MEMBERS
                teamMembers=V;
                
                return 1;                           //Successfully Added
    }
    int removeTeamMember(Volunteer v)
    {
         for(int i=0;i<teamMembers.size();i++)
        {
            if(teamMembers.get(i)==v)
            {
                v.isAvailable=true;
                teamMembers.remove(i);
                return 1;                                           //Success
            }
        }
         return -1;                                                 //Failed Could not find
    }
    
    int editTeamLead(Volunteer v)
    {
        
       // if(v.isAvailable)
        //{
         //   v.isAvailable=false;
      //if(teamLead==null)                             //success
      //  }
      //{
          
          teamLead=v;
          return 1;
      //}
      
        //return -1;                                  //already busy
        
    }
    int checkDonor(String name)
    {
        SystemDonation obj=SystemDonation.getInstance();
        for(int i=0;i<obj.overAllDons.size();i++)
        {
            if(obj.overAllDons.get(i).donPerson.name.equals(name))
            {
                    return -1;                                  //Already a donor
            }
        }
        return 1;                                               //donot exist as donor
    }
    int checkReceiver(String name)
    {
        SystemDonation obj=SystemDonation.getInstance();
        for(int i=0;i<obj.overAllNeedy.size();i++)
        {
            if(obj.overAllNeedy.get(i).needyPerson.name.equals(name))
            {
                    return -1;                                  //Already a donor
            }
        }
        return 1;                                               //donot exist as donor
    }
    
    void AddNewDonation(Donation e)
    {
        collection.donations.add(e);
    }
    
    List<Donor> DonOfProj()
    {
        List<Donor> temp=new ArrayList<Donor>();
                
        for(int i=0;i<collection.donations.size();i++)
        {
            temp.add(collection.donations.get(i).donInfo);
        
        }
        return temp;
            
    }
    List<Needy> NeedyOfProj()
    {
        List<Needy> temp=new ArrayList<Needy>();
                
        for(int i=0;i<disbursement.disbursed.size();i++)
        {
            temp.add(disbursement.disbursed.get(i).receiver);
        
        }
        return temp; 
    }
    
    void Donate()
    {
    
    }
    
    
    
    
    
}
