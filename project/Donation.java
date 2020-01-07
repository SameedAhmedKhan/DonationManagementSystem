/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.Date;

/**
 *
 * @author Faizan
 */
abstract public class Donation {
   public int id;
    //boolean donatedStatus=false;
   public String donDate;
    boolean donStatus=false;
   public Donor donInfo;
 
   public Projects proj;
  //  Receiving recInfo;
    Pledge pledgeOfFund=null;
    public Donation()
    {}
    public Donation(int id,String donDate,Donor d,boolean hasDonated,Pledge pl,Projects p)
    {
        proj=p;
        this.id=id; 
        this.donDate=donDate;
        this.donInfo=d;
        donStatus=hasDonated;
        pledgeOfFund=pl;
        d.numOfDons++;
        donInfo.donDonations.add(this);
    }
    abstract public int getAmount();
    public String getItemName(){
        
        return null;
    }
   
}
