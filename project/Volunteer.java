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
public class Volunteer {
 int id;
    
 public   Person vol;
 Projects myCurrProj=null;
 boolean isAvailable=true;

    public Volunteer(Person vol) {
        this.vol = vol;
           
    }
    public void changeAvailalbeToFalse()
    {
        isAvailable=false;
    
    }
    public void changeAvailalbeToTrue()
    {
        isAvailable=true;
    }
 
 
 
 
}
