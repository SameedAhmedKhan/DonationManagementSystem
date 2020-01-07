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
public class Donor {
    public Person donPerson=new Person();
    public List<Donation> donDonations=new ArrayList<Donation>();
    int numOfDons=0;
    public Donor(String name,int age)
    {
        donPerson.name=name;
        donPerson.age=age;
    }  
}
