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
public class Loan extends Funds {
 String retDate;   
 
 public Loan(int id,String donDate,Donor d,boolean hasDonated,Pledge pl,int amount,String retDate,Projects p,int aleft)
 {
     super(id,donDate,d,hasDonated,pl,amount,p,aleft);
     this.retDate=retDate; 
 }
}
