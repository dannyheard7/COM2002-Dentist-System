/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com2002;

/**
 *
 * @author aca14ams
 */
public class BookAppointment extends javax.swing.JFrame {

    /**
     * Creates new form BookAppointment
     */
    public BookAppointment() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BookAppointmentPanel = new javax.swing.JPanel();
        Lbl_BookAppointment_Date = new javax.swing.JLabel();
        TxtFld_BookAppointment_Date = new javax.swing.JTextField();
        Lbl_BookAppointment_Start = new javax.swing.JLabel();
        TxtFld_BookAppointment_Start = new javax.swing.JTextField();
        Lbl_BookAppointment_End = new javax.swing.JLabel();
        TxtFld_BookAppointment_End = new javax.swing.JTextField();
        Lbl_BookAppointment_AppType = new javax.swing.JLabel();
        Combo_BookAppointment_AppType = new javax.swing.JComboBox();
        Lbl_BookAppointment_PatientID = new javax.swing.JLabel();
        TxtFld_BookAppointment_PatientID = new javax.swing.JTextField();
        Btn_BookAppointment_FindPatient = new javax.swing.JButton();
        Btn_BookAppointment_Submit = new javax.swing.JButton();
        Btn_BookAppointment_Cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Book Appointment");

        Lbl_BookAppointment_Date.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Lbl_BookAppointment_Date.setText("Date");

        TxtFld_BookAppointment_Date.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TxtFld_BookAppointment_Date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtFld_BookAppointment_DateActionPerformed(evt);
            }
        });

        Lbl_BookAppointment_Start.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Lbl_BookAppointment_Start.setText("Start Time");

        TxtFld_BookAppointment_Start.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        Lbl_BookAppointment_End.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Lbl_BookAppointment_End.setText("End Time");

        TxtFld_BookAppointment_End.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TxtFld_BookAppointment_End.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtFld_BookAppointment_EndActionPerformed(evt);
            }
        });

        Lbl_BookAppointment_AppType.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Lbl_BookAppointment_AppType.setText("Appointment Type");

        Combo_BookAppointment_AppType.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Combo_BookAppointment_AppType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Check-Up", "Hygiene", "Treatment" }));

        Lbl_BookAppointment_PatientID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Lbl_BookAppointment_PatientID.setText("Patient ID");

        TxtFld_BookAppointment_PatientID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        Btn_BookAppointment_FindPatient.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        Btn_BookAppointment_FindPatient.setText("...");
        Btn_BookAppointment_FindPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_BookAppointment_FindPatientActionPerformed(evt);
            }
        });

        Btn_BookAppointment_Submit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Btn_BookAppointment_Submit.setText("Submit");
        Btn_BookAppointment_Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_BookAppointment_SubmitActionPerformed(evt);
            }
        });

        Btn_BookAppointment_Cancel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Btn_BookAppointment_Cancel.setText("Cancel");
        Btn_BookAppointment_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_BookAppointment_CancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BookAppointmentPanelLayout = new javax.swing.GroupLayout(BookAppointmentPanel);
        BookAppointmentPanel.setLayout(BookAppointmentPanelLayout);
        BookAppointmentPanelLayout.setHorizontalGroup(
                BookAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(BookAppointmentPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(BookAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(BookAppointmentPanelLayout.createSequentialGroup()
                                                .addGroup(BookAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(Lbl_BookAppointment_AppType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(Lbl_BookAppointment_PatientID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(Lbl_BookAppointment_End, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(Lbl_BookAppointment_Start, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(Lbl_BookAppointment_Date, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(BookAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(BookAppointmentPanelLayout.createSequentialGroup()
                                                                .addComponent(TxtFld_BookAppointment_PatientID, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(Btn_BookAppointment_FindPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(BookAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(TxtFld_BookAppointment_Date)
                                                                .addComponent(TxtFld_BookAppointment_Start)
                                                                .addComponent(TxtFld_BookAppointment_End, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(Combo_BookAppointment_AppType, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BookAppointmentPanelLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(Btn_BookAppointment_Submit)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Btn_BookAppointment_Cancel)))
                                .addContainerGap())
        );
        BookAppointmentPanelLayout.setVerticalGroup(
                BookAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(BookAppointmentPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(BookAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TxtFld_BookAppointment_Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Lbl_BookAppointment_Date))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(BookAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TxtFld_BookAppointment_Start, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Lbl_BookAppointment_Start))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(BookAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TxtFld_BookAppointment_End, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Lbl_BookAppointment_End))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(BookAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Combo_BookAppointment_AppType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Lbl_BookAppointment_AppType))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(BookAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TxtFld_BookAppointment_PatientID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Btn_BookAppointment_FindPatient)
                                        .addComponent(Lbl_BookAppointment_PatientID))
                                .addGap(18, 18, 18)
                                .addGroup(BookAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Btn_BookAppointment_Cancel)
                                        .addComponent(Btn_BookAppointment_Submit))
                                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(BookAppointmentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(BookAppointmentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_BookAppointment_FindPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_BookAppointment_FindPatientActionPerformed
        // TODO add your handling code here:
        LookUpPatient lookup = new LookUpPatient();
        lookup.setVisible(true);
    }//GEN-LAST:event_Btn_BookAppointment_FindPatientActionPerformed

    private void TxtFld_BookAppointment_DateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtFld_BookAppointment_DateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtFld_BookAppointment_DateActionPerformed

    private void TxtFld_BookAppointment_EndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtFld_BookAppointment_EndActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtFld_BookAppointment_EndActionPerformed

    private void Btn_BookAppointment_SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_BookAppointment_SubmitActionPerformed
        // TODO add inputted info to the database
        //Success Message:
        BookAppointmentPanel.removeAll();
        Lbl_BookAppointment_Success = new javax.swing.JLabel();
        Btn_BookAppointment_OK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Book Appointment");

        Lbl_BookAppointment_Success.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_BookAppointment_Success.setText("Appointment booked successfully.");
        Lbl_BookAppointment_Success.setToolTipText("");

        Btn_BookAppointment_OK.setText("OK");
        Btn_BookAppointment_OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_BookAppointment_OKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BookAppointmentPanelLayout = new javax.swing.GroupLayout(BookAppointmentPanel);
        BookAppointmentPanel.setLayout(BookAppointmentPanelLayout);
        BookAppointmentPanelLayout.setHorizontalGroup(
                BookAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(BookAppointmentPanelLayout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addComponent(Btn_BookAppointment_OK)
                                .addContainerGap(120, Short.MAX_VALUE))
                        .addComponent(Lbl_BookAppointment_Success, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        BookAppointmentPanelLayout.setVerticalGroup(
                BookAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(BookAppointmentPanelLayout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(Lbl_BookAppointment_Success, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Btn_BookAppointment_OK)
                                .addContainerGap(92, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(BookAppointmentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(BookAppointmentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();

    }//GEN-LAST:event_Btn_BookAppointment_SubmitActionPerformed

    private void Btn_BookAppointment_OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_BookAppointment_OKActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_Btn_BookAppointment_OKActionPerformed

    private void Btn_BookAppointment_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_BookAppointment_CancelActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_Btn_BookAppointment_CancelActionPerformed

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
            java.util.logging.Logger.getLogger(BookAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookAppointment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BookAppointmentPanel;
    private javax.swing.JButton Btn_BookAppointment_Cancel;
    private javax.swing.JButton Btn_BookAppointment_FindPatient;
    private javax.swing.JButton Btn_BookAppointment_Submit;
    private javax.swing.JComboBox Combo_BookAppointment_AppType;
    private javax.swing.JLabel Lbl_BookAppointment_AppType;
    private javax.swing.JLabel Lbl_BookAppointment_Date;
    private javax.swing.JLabel Lbl_BookAppointment_End;
    private javax.swing.JLabel Lbl_BookAppointment_PatientID;
    private javax.swing.JLabel Lbl_BookAppointment_Start;
    private javax.swing.JTextField TxtFld_BookAppointment_Date;
    private javax.swing.JTextField TxtFld_BookAppointment_End;
    private javax.swing.JTextField TxtFld_BookAppointment_PatientID;
    private javax.swing.JTextField TxtFld_BookAppointment_Start;
    private javax.swing.JButton Btn_BookAppointment_OK;
    private javax.swing.JLabel Lbl_BookAppointment_Success;
    // End of variables declaration//GEN-END:variables
}