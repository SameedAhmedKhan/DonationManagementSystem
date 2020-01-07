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
public class NeedAssessment {
    List<String> interviewQ=new ArrayList<String>();
   public List<Volunteer> interviewers=new ArrayList<Volunteer>();
    int needRating;
    
    public NeedAssessment()
    {
           interviewQ.add("Who is earning in your family?");
           interviewQ.add("How much you are in need of a Donation?");
           interviewQ.add("How many Siblings you have?");
           interviewQ.add("What are your monthly expenditures?");
           needRating=-1;
           
    }
    public void setNeed(int need)
    {
        needRating=need;
    }
    public int getNeed()
    {
        return needRating;
    }
    
} 
