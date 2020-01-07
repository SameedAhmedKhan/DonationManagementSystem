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
public class Funds extends Donation{
  public  int amount;
   public int amountLeft;
    public Funds()
    {}
    public Funds(int id,String donDate,Donor d,boolean hasDonated,Pledge pl,int amount,Projects p,int aleft)
    {
        super(id,donDate,d,hasDonated,pl,p);
        this.amount=amount;
        amountLeft=aleft;
    
    }
   
    public int getAmount()
    {
        return amountLeft;
    }
     //void AddReceiver(Needy n)
    //{
     //   recInfo=new Receiving();
      //  recInfo.receiver=n;
      //  recInfo.recDate=new Date();
       // recInfo.receiver.myReceivings.add(recInfo);
    //}
}
