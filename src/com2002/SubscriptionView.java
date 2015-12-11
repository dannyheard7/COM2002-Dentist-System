package com2002;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aca14ams
 */
public class SubscriptionView extends javax.swing.JFrame {

    /**
     * Creates new form SubscriptionView
     */
    public SubscriptionView() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        SubscriptionViewPanel = new javax.swing.JPanel();
        Lbl_SubscriptionView_Plan = new javax.swing.JLabel();
        Combo_SubscriptionView_Plan = new javax.swing.JComboBox();
        Btn_SubscriptionView_Ok = new javax.swing.JButton();
        Btn_SubscriptionView_Cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Patient Plan");

        Lbl_SubscriptionView_Plan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Lbl_SubscriptionView_Plan.setText("Plan");

        Combo_SubscriptionView_Plan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        Btn_SubscriptionView_Ok.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Btn_SubscriptionView_Ok.setText("OK");
        Btn_SubscriptionView_Ok.setToolTipText("");
        Btn_SubscriptionView_Ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_SubscriptionView_OkActionPerformed(evt);
            }
        });

        Btn_SubscriptionView_Cancel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Btn_SubscriptionView_Cancel.setText("Cancel");
        Btn_SubscriptionView_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_SubscriptionView_CancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SubscriptionViewPanelLayout = new javax.swing.GroupLayout(SubscriptionViewPanel);
        SubscriptionViewPanel.setLayout(SubscriptionViewPanelLayout);
        SubscriptionViewPanelLayout.setHorizontalGroup(
                SubscriptionViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(SubscriptionViewPanelLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(Lbl_SubscriptionView_Plan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Combo_SubscriptionView_Plan, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(39, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SubscriptionViewPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Btn_SubscriptionView_Ok)
                                .addGap(18, 18, 18)
                                .addComponent(Btn_SubscriptionView_Cancel)
                                .addGap(78, 78, 78))
        );
        SubscriptionViewPanelLayout.setVerticalGroup(
                SubscriptionViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(SubscriptionViewPanelLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(SubscriptionViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Combo_SubscriptionView_Plan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Lbl_SubscriptionView_Plan))
                                .addGap(18, 18, 18)
                                .addGroup(SubscriptionViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Btn_SubscriptionView_Ok)
                                        .addComponent(Btn_SubscriptionView_Cancel))
                                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(SubscriptionViewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(SubscriptionViewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>

    private void Btn_SubscriptionView_OkActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        // return the plan selected in the SQL
        setVisible(false);
    }

    private void Btn_SubscriptionView_CancelActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
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
            java.util.logging.Logger.getLogger(SubscriptionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SubscriptionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SubscriptionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SubscriptionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SubscriptionView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton Btn_SubscriptionView_Cancel;
    private javax.swing.JButton Btn_SubscriptionView_Ok;
    private javax.swing.JComboBox Combo_SubscriptionView_Plan;
    private javax.swing.JLabel Lbl_SubscriptionView_Plan;
    private javax.swing.JPanel SubscriptionViewPanel;
    // End of variables declaration
}
