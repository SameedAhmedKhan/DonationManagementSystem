/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Faizan
 */
public class otherReceiving  extends Receiving{
  public  String item;
   public int noOfItems;
    public otherReceiving(){}
    public otherReceiving(int id,Needy rec,String date, Projects theProj, Donor donMan,String items,int number)
    {
       super(id,rec,date,theProj,donMan);
       item=items;
       noOfItems=number;
    }
}
