/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.Date;
import javafx.scene.chart.PieChart.Data;

/**
 *
 * @author Faizan
 */
public class Receiving {
    int id;
    Needy receiver;
   public String recDate;
   public Projects proj;
   public Donor donatingPerson;
    public Receiving(){}
    public Receiving(int id,Needy rec,String date, Projects theProj, Donor donMan)
    {
        this.id=id;
        receiver=rec;
        recDate=date;
        proj=theProj;
        donatingPerson=donMan;
    }
}
