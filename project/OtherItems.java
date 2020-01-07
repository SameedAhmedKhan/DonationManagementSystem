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
public class OtherItems extends Donation{
   public String item;
    int noOfItems;
   public int itemsLeft;
     public OtherItems(int id,String donDate,Donor d,boolean hasDonated,Pledge pl,String itemsName,int umber,Projects p,int itemsLeft)
 {
     super(id,donDate,d,hasDonated,pl,p);
     item=itemsName;
     noOfItems=umber;
     this.itemsLeft=itemsLeft;
 }
      public int getAmount()
    {
        return itemsLeft;
    }
      public String getItemName(){
        
        return item;
    }
    
}
