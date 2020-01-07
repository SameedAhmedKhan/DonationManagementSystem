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
public class Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       my_Database m=new my_Database();
       SystemDonation s=SystemDonation.getInstance();
       s.orgs= m.getAllOrganizations();
       s.overAllDons=m.getAllDonors();
       s.overAllNeedy=m.getAllNeedy();
       m.getAllProjectsOfOrganizations(s.orgs);
       m.getAllVolunteersOfOrganizations(s.orgs);
       m.UpdateTeamLead();
       m.getAllOtherItems();
    }
    
}
