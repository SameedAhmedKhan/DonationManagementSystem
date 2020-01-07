/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import project.BLL;
import project.Donation;
import project.Donor;
import project.Funds;
import project.OtherItems;
import project.Needy;
import project.Organization;
import project.Projects;
import project.Receiving;
import project.fundReceiving;
import project.my_Database;
import project.otherReceiving;

/**
 *
 * @author Faizan
 */
public class donateToApplicant extends javax.swing.JFrame {

    /**
     * Creates new form donateToApplicant
     */
    static int id=1;
    Organization o;
    Projects p;
    public donateToApplicant() {
        initComponents();
    }
    public donateToApplicant(Organization o1,Projects p1) {
        initComponents();
        amountLabel.setVisible(false);
        amountText.setVisible(false);
        numLabel.setVisible(false);
        numText.setVisible(false);
        o=o1;
        p=p1;
        DefaultTableModel model=(DefaultTableModel)donorTable.getModel();
        BLL b=BLL.getInstance();
        List<Donation> donations=b.getAllProjDonations(p);
        //Funds a=donations.get(0).;
        for(int i=0;i<donations.size();i++)
        {
            if(donations.get(i) instanceof Funds)
                model.addRow(new Object[]{donations.get(i).id,donations.get(i).donInfo.donPerson.name,donations.get(i).getAmount(),0,0});
            else
                model.addRow(new Object[]{donations.get(i).id,donations.get(i).donInfo.donPerson.name,0,donations.get(i).getItemName(),donations.get(i).getAmount(),0});
        }
         model=(DefaultTableModel)ReceiverTable.getModel();
        List<Needy> needy=b.getAllNeedy();
        for(int i=0;i<needy.size();i++)
        {
            if(needy.get(i).myTest.getNeed()!=-1)
                model.addRow(new Object[]{needy.get(i).needyPerson.name,needy.get(i).myTest.getNeed()});
        }                  
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ReceiverTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        donorTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        idDon = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        fundsRadio = new javax.swing.JRadioButton();
        otherRadio = new javax.swing.JRadioButton();
        numText = new javax.swing.JTextField();
        numLabel = new javax.swing.JLabel();
        amountLabel = new javax.swing.JLabel();
        amountText = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        date = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ReceiverTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Beneficiary", "NeedScore"
            }
        ));
        jScrollPane1.setViewportView(ReceiverTable);

        donorTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Donor", "AmountLeft", "Item", "Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(donorTable);

        jLabel1.setText("ID :");

        idDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idDonActionPerformed(evt);
            }
        });

        jLabel2.setText("Beneficiary Name :");

        fundsRadio.setText("Funds");
        fundsRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fundsRadioActionPerformed(evt);
            }
        });

        otherRadio.setText("Other item");
        otherRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otherRadioActionPerformed(evt);
            }
        });

        numLabel.setText("Num of Items");

        amountLabel.setText("Amount :");

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("BACK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Receiving Date :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(amountLabel)
                        .addGap(60, 60, 60)
                        .addComponent(amountText, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(fundsRadio))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(otherRadio)
                            .addComponent(idDon)
                            .addComponent(name)
                            .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(numLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(numText)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(288, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fundsRadio)
                            .addComponent(otherRadio))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(numText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(amountLabel)
                            .addComponent(amountText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(96, 96, 96)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(24, 24, 24))
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(36, 36, 36)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(267, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idDonActionPerformed

    private void fundsRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fundsRadioActionPerformed

       amountLabel.setVisible(true);
       amountText.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_fundsRadioActionPerformed

    private void otherRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otherRadioActionPerformed

          numLabel.setVisible(true);
        numText.setVisible(true);
       
        // TODO add your handling code here:
    }//GEN-LAST:event_otherRadioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
       int Id=Integer.parseInt(idDon.getText());
       BLL b=BLL.getInstance();
       
        Donation d=b.findDonation(p, Id);
        Needy needy=b.findBenefInProj(name.getText());
        String recDate=date.getText();
        if(d!=null&&needy!=null){
            if(fundsRadio.isSelected()){
                if(d instanceof Funds)
                {
                    int amount=Integer.parseInt(amountText.getText());
                    if(((Funds) d).amountLeft>amount)
                    {
                        ((Funds) d).amountLeft=((Funds) d).amountLeft-amount;
                        Receiving r=new fundReceiving(id++,needy, recDate, p, d.donInfo, amount);
                        p.disbursement.disbursed.add(r);
                        needy.myReceivings.add(r);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Not Enough Amount");
                    }
                
                }
            }
            else if(otherRadio.isSelected()){
                int number=Integer.parseInt(numText.getText());
                if(d.getAmount()>number)
                    {
                        ((OtherItems) d).itemsLeft=((OtherItems) d).itemsLeft-number;
                        Receiving r=new otherReceiving(id++,needy, recDate, p,d.donInfo,((OtherItems) d).item,number );
                        p.disbursement.disbursed.add(r);
                        needy.myReceivings.add(r);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Not Enough items");
                    }
            }
        }
         my_Database mm=new my_Database();
        mm.InsertInStart();
        Project2 p2=new Project2(o,p);
        this.setVisible(false);
        p2.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        Project2 p2=new Project2(o,p);
        this.setVisible(false);
        p2.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(donateToApplicant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(donateToApplicant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(donateToApplicant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(donateToApplicant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new donateToApplicant().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ReceiverTable;
    private javax.swing.JLabel amountLabel;
    private javax.swing.JTextField amountText;
    private javax.swing.JTextField date;
    private javax.swing.JTable donorTable;
    private javax.swing.JRadioButton fundsRadio;
    private javax.swing.JTextField idDon;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField name;
    private javax.swing.JLabel numLabel;
    private javax.swing.JTextField numText;
    private javax.swing.JRadioButton otherRadio;
    // End of variables declaration//GEN-END:variables
}
