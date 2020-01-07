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
public class fundReceiving extends Receiving{
   public int amount;
   public fundReceiving(){}
   public fundReceiving(int id,Needy rec,String date, Projects theProj, Donor donMan,int amount)
   {
       super(id,rec,date,theProj,donMan);
       this.amount=amount;
   }
   
}
