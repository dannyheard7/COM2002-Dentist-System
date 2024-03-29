package com2002;

public class EmployeeSelection extends javax.swing.JFrame {

    /**
     * Creates new form EmployeeSelection
     */
    public EmployeeSelection() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        EmployeeSelectionPanel = new javax.swing.JPanel();
        Btn_EmployeeSelection_Secretary = new javax.swing.JButton();
        Btn_EmployeeSelection_Dentist = new javax.swing.JButton();
        Btn_EmployeeSelection_Hygenist = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Employee Selection");

        Btn_EmployeeSelection_Secretary.setText("Secretary");
        Btn_EmployeeSelection_Secretary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_EmployeeSelection_SecretaryActionPerformed(evt);
            }
        });

        Btn_EmployeeSelection_Dentist.setText("Dentist");
        Btn_EmployeeSelection_Dentist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_EmployeeSelection_DentistActionPerformed(evt);
            }
        });

        Btn_EmployeeSelection_Hygenist.setText("Hygenist");
        Btn_EmployeeSelection_Hygenist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_EmployeeSelection_HygenistActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Choose Employee Type");

        javax.swing.GroupLayout EmployeeSelectionPanelLayout = new javax.swing.GroupLayout(EmployeeSelectionPanel);
        EmployeeSelectionPanel.setLayout(EmployeeSelectionPanelLayout);
        EmployeeSelectionPanelLayout.setHorizontalGroup(
                EmployeeSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(EmployeeSelectionPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Btn_EmployeeSelection_Secretary, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(Btn_EmployeeSelection_Dentist, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addComponent(Btn_EmployeeSelection_Hygenist, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EmployeeSelectionPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(106, 106, 106))
        );
        EmployeeSelectionPanelLayout.setVerticalGroup(
                EmployeeSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(EmployeeSelectionPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addGroup(EmployeeSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Btn_EmployeeSelection_Dentist, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Btn_EmployeeSelection_Secretary, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Btn_EmployeeSelection_Hygenist, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(EmployeeSelectionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(EmployeeSelectionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void Btn_EmployeeSelection_DentistActionPerformed(java.awt.event.ActionEvent evt) {
        PartnerUI partui = new PartnerUI(0);
        partui.setVisible(true);
        this.setVisible(false);
        this.dispose();

    }

    private void Btn_EmployeeSelection_SecretaryActionPerformed(java.awt.event.ActionEvent evt) {
        SecretaryUI secui = new SecretaryUI();
        secui.setVisible(true);
        this.setVisible(false);
        this.dispose();

    }

    private void Btn_EmployeeSelection_HygenistActionPerformed(java.awt.event.ActionEvent evt) {
        PartnerUI partui = new PartnerUI(1);
        partui.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }

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

    private javax.swing.JButton Btn_EmployeeSelection_Dentist;
    private javax.swing.JButton Btn_EmployeeSelection_Hygenist;
    private javax.swing.JButton Btn_EmployeeSelection_Secretary;
    private javax.swing.JPanel EmployeeSelectionPanel;
    private javax.swing.JLabel jLabel1;
}
