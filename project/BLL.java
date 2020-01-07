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
public class BLL {
      private static BLL obj=null; 
     private BLL() {}
      public static BLL getInstance() 
    { 
        if (obj==null) 
            obj = new BLL(); 
        return obj; 
    } 
     
    public void addOrg(Organization o)
    {
        SystemDonation s=SystemDonation.getInstance();
        s.orgs.add(o);
    }
    public int addVolunsToOrg(Organization o,Volunteer v)
    {
        SystemDonation s=SystemDonation.getInstance();
        o.orgVoluns.add(v);                         //add to database
        return 1;                   //success
    }
      public List<Organization> getAllOrgs()
    {
        SystemDonation s=SystemDonation.getInstance();
        return s.orgs;
    }
    public  List<Projects> getProjOrganization(Organization o)
      {
          return o.projs;
      }
      public void addProjToOrg(Organization o, Projects p)
      {
          o.projs.add(p);
      }
     public void addNewDonationToProj(Organization o,Projects p,Donation e)
      {
          //add Database
          //e.donInfo.donDonations.add(e);
          p.AddNewDonation(e);         
      }
      public void addNewDonationToProj(Projects p,Donation e)
      {
          //add Database
          //e.donInfo.donDonations.add(e);
          p.AddNewDonation(e);         
      }
    
    public Donor findDonor(String name)                     //finds donor in classes 
    {
        //dont need to check from database
        SystemDonation s=SystemDonation.getInstance();
        for(int i=0;i<s.overAllDons.size();i++)
        {
            if(s.overAllDons.get(i).donPerson.name.equals(name))
            {
                return s.overAllDons.get(i);
            }
            
        }
        return null;
    }
     public Needy findNeedy(String name)                     //finds donor in classes 
    {
        //dont need to check from database
        SystemDonation s=SystemDonation.getInstance();
        for(int i=0;i<s.overAllNeedy.size();i++)
        {
            if(s.overAllNeedy.get(i).needyPerson.name.equals(name))
            {
                return s.overAllNeedy.get(i);
            }
            
        }
        return null;
    }
    
    public Volunteer findVolunInProj(Projects p,String name)                     //finds donor in classes 
    {
        //dont need to check from database
        SystemDonation s=SystemDonation.getInstance();
        for(int i=0;i<p.teamMembers.size();i++)
        {
            if(p.teamMembers.get(i).vol.name.equals(name))
            {
                return p.teamMembers.get(i);
            }
        }
        return null;
    }
    
    public Volunteer findVolunInOrg(Organization o, String name)                //just find in classes
    {
      return o.SearchVoluns(name);
    }
    public int addVolunToProj(Organization o,Projects p, Volunteer v)                //just find in classes
    {
        if(p.addTeamMembers(v)>0)
        {
            //add to database
            return 1;
        }
        return -1;
    }    
    public int updateTeamLead(Organization o,Projects p,Volunteer v)
    {
        if(p.editTeamLead(v)>0)
        {
            //change in database
            return 1;
        }
        else 
            return -1;
    }
    public int removeVolunfromProj(Organization o,Projects p,Volunteer v)
    {
        for(int i=0;i<p.teamMembers.size();i++)
        {
            if(p.teamMembers.get(i)==v)
            {
                   if(p.teamLead==p.teamMembers.get(i))
                   {
                       return -2;            //he is the team lead
                   }
                   else
                   {    
                        p.teamMembers.remove(i);
                        return 1;                   //success
                   }
            
            }
                     
         }
        return -1;           //failure
    }
    public int addDonorToSystem(String name,int age)
    {
        Donor d=new Donor(name,age);
        SystemDonation s=SystemDonation.getInstance();
        s.addDonor(d);
        return 1;
    }
     public int addDonorToSystem(Donor d)
    {
        SystemDonation s=SystemDonation.getInstance();
        s.addDonor(d);
        return 1;
    }
    public int addRecToSystem(String name,int age)
     {
        Needy d=new Needy(name,age);        
        SystemDonation s=SystemDonation.getInstance();
        s.addNeedyToSystem(d);
        return 1;
    }
    public int addRecToSystem(Needy n)
     {
           
        SystemDonation s=SystemDonation.getInstance();
        s.addNeedyToSystem(n);
        return 1;
    }
    public List<Donor> getAllDonors()
    {
        SystemDonation s=SystemDonation.getInstance();
        return s.overAllDons;
    
    }
    public List<Needy> getAllNeedy()
    {
        SystemDonation s=SystemDonation.getInstance();
        return s.overAllNeedy;
    
    }
    
    public List<Needy> getAllShortListNeedy()
    {
       SystemDonation s=SystemDonation.getInstance();
       List<Needy> temp=new ArrayList<>();
       for(int i=0;i<s.overAllNeedy.size();i++)
       {
           System.out.print(s.overAllNeedy.get(i).myTest.needRating);
           if(s.overAllNeedy.get(i).myTest.needRating==-1)
           {
                System.out.println(s.overAllNeedy.get(i).myTest.needRating);
           
               temp.add(s.overAllNeedy.get(i));           
           }
       }
       
       return temp;
    }
    public Needy findBenefInProj(String name)
    {
        SystemDonation s=SystemDonation.getInstance();
        Needy temp=s.SearchBeneficiary(name);
        return temp;
    }
    public int setNeedAndAccessor(Needy n,Volunteer v,Volunteer v2,int need)
    {
        n.myTest.setNeed(need);
        n.myTest.interviewers.add(v);
        n.myTest.interviewers.add(v2);
        return 1;               //success
    }
    
    public List<String> getInterviewQ()
    {
        NeedAssessment n=new NeedAssessment();
        return n.interviewQ;
    }
    
    public List<Donation> getAllProjDonations(Projects p)
    {
        return p.collection.donations;
    }
    public Donation findDonation(Projects p,int id)
    {
        SystemDonation s=SystemDonation.getInstance();
        for(int i=0;i<p.collection.donations.size();i++)
        {
            if(p.collection.donations.get(i).id==id)
            {
                 
                return p.collection.donations.get(i);
            }        
        }
        return null;
    }
    public List<Donor> OrganizationDonors(Organization o)
    {
        List<Donor> temp=new ArrayList<>();
        for(int i=0;i<o.projs.size();i++)
        {
            for(int j=0;j<o.projs.get(i).collection.donations.size();j++)
            {
                temp.add(o.projs.get(i).collection.donations.get(j).donInfo);
            
            }
        }
        return temp;
    }
    
    public List<Needy> OrganizationNeedy(Organization o)
    {
        List<Needy> temp=new ArrayList<>();
        for(int i=0;i<o.projs.size();i++)
        {
            for(int j=0;j<o.projs.get(i).disbursement.disbursed.size();j++)
            {
                temp.add(o.projs.get(i).disbursement.disbursed.get(j).receiver);
            
            }
        }
        return temp;
    }
    Projects findProjectObjectOfProject(String pname)
    {
        SystemDonation s=SystemDonation.getInstance();
        for(int i=0;i<s.orgs.size();i++)
        {
            for(Projects P: s.orgs.get(i).projs)
            {
                if(P.projName.equals(pname))
                    return P;
                
            }
        }
        return null;
    }
}
