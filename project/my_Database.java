
/*
- * To change this license header, choose License Headers in Project Properties.
- * To change this template file, choose Tools | Templates
- * and open the template in the editor.
- */
package project;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
- *
- * @author Sameed Khan Durrani
- */
public class my_Database {
    
    Connection con;
    Statement stmt;
    
    public my_Database() //cons
    {
        try
        {
            String s = "jdbc:sqlserver://DESKTOP-L6OJ220\\SQLEXPRESS:1433;databaseName=donSystem";
             con=DriverManager.getConnection(s,"please","faizan11");



            stmt = con.createStatement(); 
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    ///////////////////////////////////////////////////////////////////////
     public ArrayList<Organization> getAllOrganizations() {
        ArrayList<Organization> organizations = new ArrayList<Organization>();
        try {
            String s = "SELECT * FROM Organization";
            ResultSet rs = stmt.executeQuery(s);
            
            while (rs.next()) {
                Organization O=new Organization();
                O.name=rs.getString("OrgName");
                
//                docter.setD_id(rs.getInt("d_id"));
//                docter.setD_FName(rs.getString("d_fname"));
//                docter.setD_LName(rs.getString("d_lname"));
//
//                docters.add(docter);
                organizations.add(O);
            }

        } catch (Exception e) {
            System.out.println(e);
            
        }

        return (organizations);
    }
    
    public ArrayList<Donor> getAllDonors() {
        ArrayList<Donor> donors = new ArrayList<Donor>();
        try {
            String s = "SELECT * FROM Donor";
            ResultSet rs = stmt.executeQuery(s);
            
            while (rs.next()) {
                Donor D=new Donor(rs.getString("DonorName"),rs.getInt("Age") );
                
                
//                docter.setD_id(rs.getInt("d_id"));
//                docter.setD_FName(rs.getString("d_fname"));
//                docter.setD_LName(rs.getString("d_lname"));
//
//                docters.add(docter);
                donors.add(D);
            }

        } catch (Exception e) {
            System.out.println(e);
            
        }

        return (donors);
    }
    public ArrayList<Needy> getAllNeedy() {
        ArrayList<Needy> needy = new ArrayList<Needy>();
        try {
            String s = "SELECT * FROM Beneficiary";
            ResultSet rs = stmt.executeQuery(s);
            
            while (rs.next()) {
                String name=rs.getString("BenefName");
                int age=rs.getInt("Age");
                
                Needy N=new Needy(name, age);
                N.myTest.needRating=rs.getInt("AssessmentMarks");
                if(N.myTest.needRating==-1){
                  //  N.myTest.interviewers.get(0).vol.name=null;
                  //    N.myTest.interviewers.get(0).vol.name=null;        
                }
                else{
                     N.myTest.interviewers.get(0).vol.name=rs.getString("Accessor");
                     N.myTest.interviewers.get(0).vol.name=rs.getString("Accessor2");
                }
//                docter.setD_id(rs.getInt("d_id"));
//                docter.setD_FName(rs.getString("d_fname"));
//                docter.setD_LName(rs.getString("d_lname"));
//
//                docters.add(docter);
                needy.add(N);
            }

        } catch (Exception e) {
            System.out.println(e);
            
        }

        return (needy);
    }
        
    
     public void getAllProjectsOfOrganizations(List<Organization> orgs) {
        List<Projects> projects = new ArrayList<Projects>();
        // DOES NOT UPDATES TEAM LEAD
        try {
            String s = "SELECT * FROM Project";
            ResultSet rs = stmt.executeQuery(s);
            
            while (rs.next()) {
                String pName=rs.getString("ProjName");
                String projDesc=rs.getString("ProjDescription");
                int reqBud=rs.getInt("ProjBudget");
                String o=rs.getString("OrgName");
                rs.getString("TeamLead"); // BEING WASTED
                for(Organization O: orgs)
                {
                    
                    if (o.equals(O.name))
                    {
                        Projects P=new Projects(O,pName=pName,projDesc=projDesc,0,reqBud=reqBud);
                        O.projs.add(P);
                    }
                }
            }

        } catch (Exception e) {
            System.out.println(e);
            
        }

    }
   
     
     public void getAllVolunteersOfOrganizations(List<Organization> orgs) {
        List<Volunteer> volunteers = new ArrayList<Volunteer>();
        // DOES NOT UPDATES TEAM LEAD
        try {
            String s = "SELECT * FROM Volunteer";
            ResultSet rs = stmt.executeQuery(s);
            
            while (rs.next()) {
                String vName=rs.getString("VolunteerName");
                int vAge=rs.getInt("Age");
                String OName=rs.getString("OrgName");
                String PName=rs.getString("ProjName");
                Person P=new Person(vName, vAge);
                Volunteer V= new Volunteer(P);
                
                for(Organization O: orgs)
                {
                    if (O.name.equals(OName))
                    {
                        
                        O.orgVoluns.add(V);
                        for(Projects PR: O.projs)
                        {
                            if (PR.projName.equals(PName))
                            {
                                PR.teamMembers.add(V);
                                V.myCurrProj=PR;
                            }
                        }
                    }
                }
                volunteers.add(V);
            }
        } catch (Exception e) {
            System.out.println(e);
            
        }
    }
     
     
    public void UpdateTeamLead( ) {
        // DOES NOT UPDATES TEAM LEAD
        try {
            String s = "SELECT Project.TeamLead, Project.ProjName FROM Project";
            ResultSet rs = stmt.executeQuery(s);
            SystemDonation sys=SystemDonation.getInstance();
            while (rs.next()) {
                String TL=rs.getString("TeamLead");
                String PN=rs.getString("ProjName");
                for(Organization O:sys.orgs)
                {
                for (Projects P: O.projs)
                {
                    if (P.projName.equals(PN))
                    {
                        for (Volunteer V: P.teamMembers)
                        {
                            if (V.vol.name.equals(TL))
                            {
                                P.teamLead=V;
                            }
                        }
                    }
                    
                }
            }
            }

        } catch (Exception e) {
            System.out.println(e);
            
        }
        
    }
   
     public ArrayList<Pledge> getAllPledges()
     {
         ArrayList<Pledge> pledges = new ArrayList<Pledge>();
        // DOES NOT UPDATES TEAM LEAD
        try {
            String s = "SELECT * FROM Pledge";
            ResultSet rs = stmt.executeQuery(s);
            
            while (rs.next()) {
                int DonationID=rs.getInt("DonationID");
                String releasedate=rs.getString("releasedate");
                String pledgedate=rs.getString("pledgedate");
                Pledge P= new Pledge(releasedate ,pledgedate);
                
                //volunteers.add(V);
            }

        } catch (Exception e) {
            System.out.println(e);
            
        }

         return (pledges);
     }
     public void getAllOtherItems() {
        ArrayList<Donation> donations = new ArrayList<Donation>();
        // DOES NOT UPDATES TEAM LEAD
        try {
            String s = "SELECT * FROM Donation D join Items I on D.DonationID=I.DonationID";
            ResultSet rs = stmt.executeQuery(s);
            
            while (rs.next()) {
                int DonationID=rs.getInt("DonationID");
                String DonorName=rs.getString("DonorName");
                
                int donStatus=rs.getInt("donStatus");
                 boolean stat;
                if(donStatus==1)
                {
                    stat=true;
                }
                else
                    stat=false;
                String DonationDate=rs.getString("DonationDate");
             //   int Donationtype=rs.getInt("Donationtype");
                String ProjName=rs.getString("ProjName");
                String itemName=rs.getString("ItemName");
                int totItems=rs.getInt("Amount");
                int itemsLeft=rs.getInt("AmountLeft");
                BLL b=BLL.getInstance();
                Donor d=b.findDonor(DonorName);
                Projects projPointer=b.findProjectObjectOfProject(ProjName);
                Donation others=new OtherItems(DonationID,DonationDate,d,stat,null,itemName,totItems,projPointer,itemsLeft);
                b.addNewDonationToProj( projPointer, others);
                //volunteers.add(V);
            }

        } catch (Exception e) {
            System.out.println(e);
            
        }
    }
     void getAllGiftsWithPledges()
     {
         try{
         String s = "SELECT * FROM Donation D join Funds I on D.DonationID=I.DonationID join Pledge p on p.DonationID=I.DonationID";
            ResultSet rs = stmt.executeQuery(s);
            
                while (rs.next()) {
                       int DonationID=rs.getInt("DonationID");
                String DonorName=rs.getString("DonorName");
                
                int donStatus=rs.getInt("donStatus");
                 boolean stat;
                if(donStatus==1)
                {
                    stat=true;
                }
                else
                    stat=false;
                String DonationDate=rs.getString("DonationDate");
             //   int Donationtype=rs.getInt("Donationtype");
                String ProjName=rs.getString("ProjName");
                int amount=rs.getInt("Amount");
                 int amountLeft=rs.getInt("AmountLeft");
                 String relDate=rs.getString("releaseDate");
                 String pledgeDate=rs.getString("pledgeDate");
                 
                Pledge p=new Pledge(relDate,pledgeDate);
                
                BLL b=BLL.getInstance();
                  Donor d=b.findDonor(DonorName);
                Projects projPointer=b.findProjectObjectOfProject(ProjName);
                
                  Donation donation=new Gift(DonationID,null,d,stat,p,amount,projPointer,amountLeft);
                  b.addNewDonationToProj(projPointer, donation);
                }
                
            
         }
         catch(Exception e){
          System.out.println(e);
         }
     }
       void getAllGiftsWithoutPledges()
     {
         try{
         String s = "SELECT * FROM Donation D join Funds I on D.DonationID=I.DonationID";
            ResultSet rs = stmt.executeQuery(s);
            while(rs.next())
            {
                    int DonationID=rs.getInt("DonationID");
                String DonorName=rs.getString("DonorName");
                
                int donStatus=rs.getInt("donStatus");
                 boolean stat;
                if(donStatus==1)
                {
                    stat=true;
                }
                else
                    stat=false;
                String DonationDate=rs.getString("DonationDate");
             //   int Donationtype=rs.getInt("Donationtype");
                String ProjName=rs.getString("ProjName");
                int amount=rs.getInt("Amount");
                 int amountLeft=rs.getInt("AmountLeft");
                  BLL b=BLL.getInstance();
                  Donor d=b.findDonor(DonorName);
                Projects projPointer=b.findProjectObjectOfProject(ProjName);
                
                  Donation donation=new Gift(DonationID,DonationDate,d,stat,null,amount,projPointer,amountLeft);
                      b.addNewDonationToProj( projPointer, donation);
                 
            }
            
         }
         catch(Exception e){
          System.out.println(e);
         }
     }
         void getAllLoansWithPledges()
     {
         try{
            String s = "SELECT * FROM Donation D join Funds I on D.DonationID=I.DonationID join Loan l on l.DonationID=I.DonationID join Pledge P on P.DonationID=I.DonationID";
            ResultSet rs = stmt.executeQuery(s);
            while (rs.next()) {
                int DonationID=rs.getInt("DonationID");
                String DonorName=rs.getString("DonorName");
                
                int donStatus=rs.getInt("donStatus");
                 boolean stat;
                if(donStatus==1)
                {
                    stat=true;
                }
                else
                    stat=false;
                String DonationDate=rs.getString("DonationDate");
             //   int Donationtype=rs.getInt("Donationtype");
                String ProjName=rs.getString("ProjName");
                int amount=rs.getInt("Amount");
                 int amountLeft=rs.getInt("AmountLeft");
                 String relDate=rs.getString("releaseDate");
                 String pledgeDate=rs.getString("pledgeDate");
                 
                 
                Pledge p=new Pledge(relDate,pledgeDate);
                String retDate=rs.getString("returnDate");
                BLL b=BLL.getInstance();
                  Donor d=b.findDonor(DonorName);
                Projects projPointer=b.findProjectObjectOfProject(ProjName);
                
                  Donation donation=new Loan(DonationID,null,d,stat,p,amount,retDate,projPointer,amountLeft);
                  b.addNewDonationToProj(projPointer, donation);
                }
            
            
            
         }
         catch(Exception e){
          System.out.println(e);
         }
     }
     void getAllLoansWithoutPledges()
     {
         try{
        String s = "SELECT * FROM Donation D join Funds I on D.DonationID=I.DonationID join Loan l on l.DonationID=I.DonationID ";
              ResultSet rs = stmt.executeQuery(s);
              while(rs.next())
              {
                    int DonationID=rs.getInt("DonationID");
                String DonorName=rs.getString("DonorName");
                
                int donStatus=rs.getInt("donStatus");
                 boolean stat;
                if(donStatus==1)
                {
                    stat=true;
                }
                else
                    stat=false;
                String DonationDate=rs.getString("DonationDate");
             //   int Donationtype=rs.getInt("Donationtype");
                String ProjName=rs.getString("ProjName");
                int amount=rs.getInt("Amount");
                 int amountLeft=rs.getInt("AmountLeft");
                   String retDate=rs.getString("returnDate");
                BLL b=BLL.getInstance();
                  Donor d=b.findDonor(DonorName);
                Projects projPointer=b.findProjectObjectOfProject(ProjName);
                
                  Donation donation=new Loan(DonationID,DonationDate,d,stat,null,amount,retDate,projPointer,amountLeft);
                  b.addNewDonationToProj(projPointer, donation);
         
              }
         }
         catch(Exception e){
          System.out.println(e);
         }
     }
     
     
    
     
       public ArrayList<Receiving> getAllReceivings()
     {
         ArrayList<fundReceiving> receivings = new ArrayList<fundReceiving>();
         
         ArrayList<otherReceiving> receivingsother = new ArrayList<otherReceiving>();
        // DOES NOT UPDATES TEAM LEAD
        try {
            String s = "SELECT * FROM Disbursment join Donation join Funds";
            ResultSet rs = stmt.executeQuery(s);
            
            while (rs.next()) {
                fundReceiving R= new fundReceiving();
                int DisbursmentID=rs.getInt("DisbursmentID");
                int DonationID=rs.getInt("DonationID");
                String BenefName=rs.getString("BenefName");
                String Disbursmentdate=rs.getString("Disbursmentdate");
                String DonorName=rs.getString("DonorName");
                String ProjName=rs.getString("ProjName");
                R.id=DisbursmentID;
                for (Donor d: SystemDonation.getInstance().overAllDons)
                {
                    if (d.donPerson.name==DonorName)
                    {
                   //     R.donMan=d;
                    }
                }
                for (Organization o: SystemDonation.getInstance().orgs)
                {
                    for (Projects p: o.projs)
                    {
                        if (p.projName==ProjName)
                        {
                            R.proj=p;
                        }
                    }
                }
                for (Needy n: SystemDonation.getInstance().overAllNeedy)
                {
                    if(n.needyPerson.name==BenefName)
                    {
                        R.receiver=n;
                    }
                }
                R.amount=0;
                
                
                receivings.add(R);
            }
            s = "SELECT * FROM Disbursment join Donation join Items";
            rs = stmt.executeQuery(s);
            
            while (rs.next()) {
                otherReceiving R= new otherReceiving();
                int DisbursmentID=rs.getInt("DisbursmentID");
                int DonationID=rs.getInt("DonationID");
                String BenefName=rs.getString("BenefName");
                String Disbursmentdate=rs.getString("Disbursmentdate");
                String DonorName=rs.getString("DonorName");
                String ProjName=rs.getString("ProjName");
                R.id=DisbursmentID;
                String ItemName=rs.getString("ItemName");
                int Amount=rs.getInt("Amount");
                for (Donor d: SystemDonation.getInstance().overAllDons)
                {
                    if (d.donPerson.name==DonorName)
                    {
                      //  R.donMan=d;
                    }
                }
                for (Organization o: SystemDonation.getInstance().orgs)
                {
                    for (Projects p: o.projs)
                    {
                        if (p.projName==ProjName)
                        {
                            R.proj=p;
                        }
                    }
                }
                for (Needy n: SystemDonation.getInstance().overAllNeedy)
                {
                    if(n.needyPerson.name==BenefName)
                    {
                        R.receiver=n;
                    }
                }
                
                R.item=ItemName;
                R.noOfItems=Amount;
                
                receivingsother.add(R);
            
            }
            

        }
        catch (Exception e) {
            System.out.println(e);
            
        }

         return null;
     }

    
    
    
    
    ////////////////////////////////////////////////////////////////////////
   public void InsertInStart()
    {
         SystemDonation s=SystemDonation.getInstance();
      /*  Organization o1=new Organization();
        o1.name="faizan";
        Person boom=new Person("hey",12);
        
        Volunteer v1=new Volunteer(boom);
        o1.orgVoluns.add(v1);
       
        s.orgs.add(o1);
        Projects p2=new Projects(o1,"BOOm","sadsdasd",0,1234);
        o1.projs.add(p2);
        p2.teamMembers.add(v1);
        Donor d11=new Donor("Faiii",123);
        Pledge pl=new Pledge("asda","asdasd");
        Donation dd=new Loan(1,"2/2/2100",d11,true,pl,1200,"23/2/2",p2);
        p2.collection.donations.add(dd);
        s.overAllDons.add(d11);
        Needy nnn=new Needy("asda",123);
        s.overAllNeedy.add(nnn);
        Receiving rr=new fundReceiving(1,nnn,"5.5.5555",p2,d11,1200);
        p2.disbursement.disbursed.add(rr);
        nnn.myReceivings.add(rr);*/
//        try
//        {
//            int res = stmt.executeUpdate("Delete FROM Medicine");
//        }
//        catch(Exception e)
//        {
//            System.out.println(e);
//        }



        String queryNeedy = "INSERT Into Beneficiary VALUES ";
        
       for(Needy g: s.overAllNeedy)
       {
           if(g.myTest.needRating!=-1) 
            queryNeedy += "(" +" \'" +g.needyPerson.name + "\', " + g.needyPerson.age + ", "  +g.myTest.needRating  +" , \'" +g.myTest.interviewers.get(0).vol.name + "\' "+" , \'" +g.myTest.interviewers.get(1).vol.name + "\' " +"), ";
        
           else
            queryNeedy += "(" +" \'" +g.needyPerson.name + "\', " + g.needyPerson.age + ", "  +g.myTest.needRating  +" ," +"NULL" +" ," +"NULL"  +"), ";
           
       }
       if(queryNeedy.length()>32){
       queryNeedy = queryNeedy.substring(0, queryNeedy.length()-2);
        try
        {
            int result=stmt.executeUpdate(queryNeedy);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
       }
        String queryDonor = "INSERT Into Donor VALUES ";
        
       for(Donor d1: s.overAllDons)
       {
            queryDonor += "(" +" \'" +d1.donPerson.name + "\' , " + d1.donPerson.age+ "), ";
        
       }
       if(queryDonor.length()>30){
       queryDonor = queryDonor.substring(0, queryDonor.length()-2);
        try
        {
            int result=stmt.executeUpdate(queryDonor);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
       }
        
        
        for(Organization o : s.orgs)
        {
            String query = "INSERT Into Organization VALUES ";
           query += "(" + "\'" + o.name + "\'"+ ")";
           
             try
            {
                int result=stmt.executeUpdate(query);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
           String queryvoluns = "INSERT Into Volunteer VALUES ";
            int a;
           for(Volunteer v: o.orgVoluns)
           {
               
              if(v.isAvailable)
                  a=1;
              else
                  a=0;
                  queryvoluns += "(" + "\'" + v.vol.name + "\'"+ ", " + v.vol.age+ ", "  + a + ", "+ "\'" + o.name + "\'"+ ", "  +"NULL" +  "), "; 
           
        
           }
                  queryvoluns = queryvoluns.substring(0, queryvoluns.length()-2);
                  
                     try
                    {
                        int result=stmt.executeUpdate(queryvoluns);
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }   
           for(Projects p: o.projs)
           {
               String queryprojs = "INSERT Into Project VALUES ";
               if(p.teamLead!=null)
               {
                queryprojs += "(" + "\'" + p.projName + "\'"+ ", " +"\'" + p.desc + "\'"+ ", "  + p.requiredBudget + ", " +"\'" + o.name + "\'" +", " +"\'" + p.teamLead.vol.name + "\'"+  ")"; 
               }
               else
               { 
                   queryprojs += "(" + "\'" + p.projName + "\'"+ ", " +"\'" + p.desc + "\'"+ ", "  + p.requiredBudget + ", " +"\'" + o.name + "\'" +", " +"NULL"+  ")"; 
               
               }
                    try
                    {
                        int result=stmt.executeUpdate(queryprojs);
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
                          
                  for(Volunteer vv: p.teamMembers)
                  {
                      String queryvolunprojs = "update Volunteer set  ";   
                      queryvolunprojs += "ProjName ="+ "\'"+ p.projName + "\'"+"where VolunteerName="+ "\'"+ vv.vol.name + "\'" +"and OrgName= "+"\'"+ p.o.name + "\'" ;
                       try
                  {
                      int result=stmt.executeUpdate(queryvolunprojs);
                  }
                  catch(Exception e)
                  {
                      System.out.println(e);
                  }
                  }
               //   queryvolunprojs = queryvolunprojs.substring(0, queryvolunprojs.length()-2);
                 
                  String querycollec = "INSERT Into Donation VALUES ";
                  String queryItem = "INSERT Into Items VALUES ";
                  String queryPledge = "INSERT Into Pledge VALUES ";
                  String queryLoan = "INSERT Into Loan VALUES ";                  
                  for(Donation d: p.collection.donations)
                  {
                         /*    if (d.Type==0)
                      {
                          queryItem +=  "(" +  " DonationID = "+d.id+ ", "+"ItemName = " +"\'" + d.o.item + "\'"+ ", "+  " Amount = "+d.o.noOfItems+ "), ";
                      }
                      if (d.Type==1)
                      {
                          queryPledge +=  "(" +  " DonationID = "+d.id+ ", "+"releasedate = " +"\'" + d.pledgeOfFund.expRelDate + "\'"+ ", "+  " pledgedate = "+"\'" + d.pledgeOfFund.pledgeDate + "\'"+ "), ";
                      }
                      if (d.Type==2)
                      {
                          queryLoan +=  "(" +  " DonationID = "+d.id+ ", "+"returndate = " + d.L.retDate+ "), ";
                      }*/
                        if(d instanceof OtherItems){
                            querycollec += "(" +d.id+ ", "+"\'" + d.donInfo.donPerson.name +"\' , "+1+ ", "+"\'" + d.donDate + "\'"+ ", "+/*"DonationType = "+d.Type+","+"ProjName ="+*/"\'" + d.proj.projName + "\'"+ "), ";                                          
                         queryItem +=  "(" +  d.id+ ", "+"\'" + ((OtherItems)d).item + "\'"+ ", "+  ((OtherItems)d).noOfItems+ ", "+  ((OtherItems)d).itemsLeft+ "), ";
                         }
                        if(d.pledgeOfFund!=null){
                             queryPledge +=  "(" +  d.id+ ", "+"\'" + d.pledgeOfFund.expRelDate + "\'"+ ", "+"\'" + d.pledgeOfFund.pledgeDate + "\'"+ "), ";
                        }
                        if(d instanceof Loan){
                           querycollec += "(" +d.id+ ", "+"\'" + d.donInfo.donPerson.name +"\' , "+1 + ", "+"\'" + d.donDate + "\'"+ ", "+/*"DonationType = "+d.Type+","+"ProjName ="+*/"\'" + d.proj.projName + "\'"+ "), ";                                          
                      
                            queryLoan +=  "(" +  d.id+ ", " + ((Loan)d).retDate+ "), ";
                        }
                        if(d instanceof Gift)
                        {
                            querycollec += "(" +d.id+ ", "+"\'" + d.donInfo.donPerson.name +"\' , "+1+  ", "+"\'" + d.donDate + "\'"+ ", "+/*"DonationType = "+d.Type+","+"ProjName ="+*/"\'" + d.proj.projName + "\'"+ "), ";                                          
                        }
                  }
                  if(querycollec.length()>29){
                   querycollec = querycollec.substring(0,querycollec.length()-2);
                  try
                  {
                      int result=stmt.executeUpdate(querycollec);
                  }
                  catch(Exception e)
                  {
                     System.out.println(e);
                  }
                  }
                  
                  if(queryLoan.length()>27){
                  queryLoan = queryLoan.substring(0,queryLoan.length()-2);
                  try
                  {
                      int result=stmt.executeUpdate(queryPledge);
                  }
                  catch(Exception e)
                  {
                      System.out.println(e);
                  }
                  }
                  if(queryPledge.length()>28){
                  
                  queryPledge = queryPledge.substring(0,queryPledge.length()-2);
                  try
                  {
                      int result=stmt.executeUpdate(queryPledge);
                  }
                  catch(Exception e)
                  {
                      System.out.println(e);
                  }
                  }
                  if(queryItem.length()>30){
                  queryItem = queryItem.substring(0,queryItem.length()-2);
                  try
                  {
                      int result=stmt.executeUpdate(queryItem);
                  }
                  catch(Exception e)
                  {
                      System.out.println(e);
                  }
                  }
                  
                 
                  String queryDisb = "INSERT Into Receiving VALUES ";
                  String queryfundRec = "INSERT Into fundReceiving VALUES ";
                  String queryotherRec = "INSERT Into otherReceiving VALUES ";
           
                  for(Receiving r: p.disbursement.disbursed)
                  {
                       queryDisb += "("  + r.id + ", " + "\'"+r.recDate+"\'"+" , "+"\'"+r.donatingPerson.donPerson.name+"\'"+"," + "\'" + r.receiver.needyPerson.name +"\' , "+"\'"+r.proj.projName+"\'" +  "), ";
                     
                       if(r instanceof fundReceiving)
                       {
                           queryfundRec += "(" + ((fundReceiving) r).amount+","+((fundReceiving) r).id+"), ";
                           
                       }
                       else 
                       {
                           queryotherRec += "(" + "\'" +((otherReceiving)r).item+"\'"+", "+((otherReceiving)r).noOfItems+", "+r.id+"), "; 
                       }
                       if(queryDisb.length()>34){
                            queryDisb = queryDisb.substring(0,queryDisb.length()-2);
                            try
                            {
                                int result=stmt.executeUpdate(queryDisb);
                            }
                            catch(Exception e)
                            {
                                System.out.println(e);
                            }
                        }
                       if(queryfundRec.length()>34)
                       {
                           queryfundRec = queryfundRec.substring(0,queryfundRec.length()-2);
                            try
                            {
                                int result=stmt.executeUpdate(queryfundRec);
                            }
                            catch(Exception e)
                            {
                                System.out.println(e);
                            }
                       
                       }
                       if(queryotherRec.length()>34)
                       {
                           queryotherRec = queryotherRec.substring(0,queryotherRec.length()-2);
                            try
                            {
                                int result=stmt.executeUpdate(queryotherRec);
                            }
                            catch(Exception e)
                            {
                                System.out.println(e);
                            }
                       
                       }
                       
                  }
                     
   

           }/*
           
                  
           
        }
        
        query = query.substring(0, query.length()-2);
        
        try
            {
                int result=stmt.executeUpdate(query);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
          
        
        */
        }
        // query = query.substring(0, query.length()-2);
        
      
    }
    
}

