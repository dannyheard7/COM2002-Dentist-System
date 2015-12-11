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
public class OutstandingCosts extends javax.swing.JFrame {

    /**
     * Creates new form OutstandingCosts
     */
    public OutstandingCosts() {
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

        OutstandingCostsPanel = new javax.swing.JPanel();
        Lbl_OutstandingCosts_Treatments = new javax.swing.JLabel();
        Lbl_OutstandingCosts_Cost = new javax.swing.JLabel();
        Lbl_OutstandingCosts_Total = new javax.swing.JLabel();
        Lbl_OutstandingCosts_TotalCalculation = new javax.swing.JLabel();
        scrlPane_OutstandingCosts_Cost = new javax.swing.JScrollPane();
        Lst_OutstandingCosts_Cost = new javax.swing.JList();
        scrlPane_OutstandingCosts_Treatments = new javax.swing.JScrollPane();
        Lst_OutstandingCosts_Treatments = new javax.swing.JList();
        Btn_OutstandingCosts_ModifyTotal = new javax.swing.JButton();
        Btn_OutstandingCosts_Cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Outstanding Costs");

        Lbl_OutstandingCosts_Treatments.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Lbl_OutstandingCosts_Treatments.setText("Treatment");

        Lbl_OutstandingCosts_Cost.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Lbl_OutstandingCosts_Cost.setText("Cost");

        Lbl_OutstandingCosts_Total.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Lbl_OutstandingCosts_Total.setText("Total: ");

        Lbl_OutstandingCosts_TotalCalculation.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Lbl_OutstandingCosts_TotalCalculation.setText(".............");

        Lst_OutstandingCosts_Cost.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Lst_OutstandingCosts_Cost.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        scrlPane_OutstandingCosts_Cost.setViewportView(Lst_OutstandingCosts_Cost);

        Lst_OutstandingCosts_Treatments.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Lst_OutstandingCosts_Treatments.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        scrlPane_OutstandingCosts_Treatments.setViewportView(Lst_OutstandingCosts_Treatments);

        Btn_OutstandingCosts_ModifyTotal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Btn_OutstandingCosts_ModifyTotal.setText("Modify Total");
        Btn_OutstandingCosts_ModifyTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_OutstandingCosts_ModifyTotalActionPerformed(evt);
            }
        });

        Btn_OutstandingCosts_Cancel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Btn_OutstandingCosts_Cancel.setText("Cancel");
        Btn_OutstandingCosts_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_OutstandingCosts_CancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout OutstandingCostsPanelLayout = new javax.swing.GroupLayout(OutstandingCostsPanel);
        OutstandingCostsPanel.setLayout(OutstandingCostsPanelLayout);
        OutstandingCostsPanelLayout.setHorizontalGroup(
                OutstandingCostsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OutstandingCostsPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(OutstandingCostsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(OutstandingCostsPanelLayout.createSequentialGroup()
                                                .addGroup(OutstandingCostsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(scrlPane_OutstandingCosts_Treatments)
                                                        .addGroup(OutstandingCostsPanelLayout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addGroup(OutstandingCostsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(Lbl_OutstandingCosts_Treatments)
                                                                        .addComponent(Lbl_OutstandingCosts_Total))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(OutstandingCostsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(scrlPane_OutstandingCosts_Cost)
                                                        .addComponent(Lbl_OutstandingCosts_TotalCalculation, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(Lbl_OutstandingCosts_Cost, javax.swing.GroupLayout.Alignment.LEADING)))
                                        .addGroup(OutstandingCostsPanelLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(OutstandingCostsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(Btn_OutstandingCosts_Cancel)
                                                        .addComponent(Btn_OutstandingCosts_ModifyTotal))))
                                .addContainerGap())
        );
        OutstandingCostsPanelLayout.setVerticalGroup(
                OutstandingCostsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OutstandingCostsPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(OutstandingCostsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Lbl_OutstandingCosts_Treatments, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Lbl_OutstandingCosts_Cost))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(OutstandingCostsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(scrlPane_OutstandingCosts_Cost, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(scrlPane_OutstandingCosts_Treatments, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(OutstandingCostsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Lbl_OutstandingCosts_Total)
                                        .addComponent(Lbl_OutstandingCosts_TotalCalculation))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Btn_OutstandingCosts_ModifyTotal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Btn_OutstandingCosts_Cancel)
                                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(OutstandingCostsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(OutstandingCostsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 281, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void Btn_OutstandingCosts_ModifyTotalActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        // Modify button - what does it do?
    }

    private void Btn_OutstandingCosts_CancelActionPerformed(java.awt.event.ActionEvent evt) {
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
            java.util.logging.Logger.getLogger(OutstandingCosts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OutstandingCosts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OutstandingCosts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OutstandingCosts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OutstandingCosts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton Btn_OutstandingCosts_Cancel;
    private javax.swing.JButton Btn_OutstandingCosts_ModifyTotal;
    private javax.swing.JLabel Lbl_OutstandingCosts_Cost;
    private javax.swing.JLabel Lbl_OutstandingCosts_Total;
    private javax.swing.JLabel Lbl_OutstandingCosts_TotalCalculation;
    private javax.swing.JLabel Lbl_OutstandingCosts_Treatments;
    private javax.swing.JList Lst_OutstandingCosts_Cost;
    private javax.swing.JList Lst_OutstandingCosts_Treatments;
    private javax.swing.JPanel OutstandingCostsPanel;
    private javax.swing.JScrollPane scrlPane_OutstandingCosts_Cost;
    private javax.swing.JScrollPane scrlPane_OutstandingCosts_Treatments;
    // End of variables declaration
}