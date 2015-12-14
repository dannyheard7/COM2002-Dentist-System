package com2002;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;

/**
 *
 * @author aca14ams
 */
public class EmployeeSelection extends javax.swing.JFrame {

    private JButton secretaryButton;
    private JButton dentistButton;
    private JButton button3;

    /**
     * Creates new form EmployeeSelection
     */
    public EmployeeSelection() {


        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        EmployeeSelectionPanel = new javax.swing.JPanel();
        Btn_EmployeeSelection_Secretary = new javax.swing.JButton();
        Btn_EmployeeSelection_Partner = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Employee Selection");

        Btn_EmployeeSelection_Secretary.setText("Secretary");
        Btn_EmployeeSelection_Secretary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_EmployeeSelection_SecretaryActionPerformed(evt);
            }
        });

        Btn_EmployeeSelection_Partner.setText("Partner");

        javax.swing.GroupLayout EmployeeSelectionPanelLayout = new javax.swing.GroupLayout(EmployeeSelectionPanel);
        EmployeeSelectionPanel.setLayout(EmployeeSelectionPanelLayout);
        EmployeeSelectionPanelLayout.setHorizontalGroup(
                EmployeeSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(EmployeeSelectionPanelLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(Btn_EmployeeSelection_Secretary, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                .addComponent(Btn_EmployeeSelection_Partner, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31))
        );
        EmployeeSelectionPanelLayout.setVerticalGroup(
                EmployeeSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(EmployeeSelectionPanelLayout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addGroup(EmployeeSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(Btn_EmployeeSelection_Secretary, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Btn_EmployeeSelection_Partner, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(81, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(EmployeeSelectionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(EmployeeSelectionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>



    private void Btn_EmployeeSelection_SecretaryActionPerformed(java.awt.event.ActionEvent evt) {
        SecretaryUI secui = new SecretaryUI();
        secui.setVisible(true);
        this.setVisible(false);
        this.dispose();

    }

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
            java.util.logging.Logger.getLogger(EmployeeSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeSelection().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton Btn_EmployeeSelection_Partner;
    private javax.swing.JButton Btn_EmployeeSelection_Secretary;
    private javax.swing.JPanel EmployeeSelectionPanel;
    // End of variables declaration
}
