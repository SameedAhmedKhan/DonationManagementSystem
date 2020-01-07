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
public class Needy {
   public List<Receiving> myReceivings=new ArrayList<Receiving>();
   public NeedAssessment myTest;
   public Person needyPerson;

    public Needy(String name, int age)
    {
        needyPerson =new Person(name,age);
        myTest=new NeedAssessment(); 
    }
    int addReceiving(Receiving r)
    {
        myReceivings.add(r);
        return 1;
    }
}
