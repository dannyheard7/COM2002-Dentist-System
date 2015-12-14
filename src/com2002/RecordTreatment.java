package com2002;

import com2002.models.Appointment;
import com2002.models.Patient;
import com2002.models.Treatment;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import javax.swing.*;

public class RecordTreatment extends javax.swing.JFrame {

    public RecordTreatment() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Record Treatment");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Lbl_RecordTreatment_Treatment = new javax.swing.JLabel();
        TxtFld_RecordTreatment_Treatment = new javax.swing.JTextField();
        TxtFld_RecordTreatment_Cost = new javax.swing.JTextField();
        Lbl_RecordTreatment_Cost = new javax.swing.JLabel();
        Btn_RecordTreatment_Record = new javax.swing.JButton();
        Btn_RecordTreatment_Cancel = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Lbl_RecordTreatment_Treatment.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Lbl_RecordTreatment_Treatment.setText("Treatment");

        TxtFld_RecordTreatment_Treatment.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        TxtFld_RecordTreatment_Cost.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        Lbl_RecordTreatment_Cost.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Lbl_RecordTreatment_Cost.setText("Cost (£)");

        Btn_RecordTreatment_Record.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Btn_RecordTreatment_Record.setText("Record");
        Btn_RecordTreatment_Record.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_RecordTreatment_RecordActionPerformed(evt);
            }
        });

        Btn_RecordTreatment_Cancel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Btn_RecordTreatment_Cancel.setText("Cancel");
        Btn_RecordTreatment_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_RecordTreatment_CancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(Lbl_RecordTreatment_Treatment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(Lbl_RecordTreatment_Cost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(TxtFld_RecordTreatment_Treatment, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(TxtFld_RecordTreatment_Cost, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(85, 85, 85)
                                                .addComponent(Btn_RecordTreatment_Record)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Btn_RecordTreatment_Cancel)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TxtFld_RecordTreatment_Treatment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Lbl_RecordTreatment_Treatment))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TxtFld_RecordTreatment_Cost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Lbl_RecordTreatment_Cost))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Btn_RecordTreatment_Record)
                                        .addComponent(Btn_RecordTreatment_Cancel))
                                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private boolean validate(String treatment, String cost) {
        boolean treatmentTrue = treatment.length() <= 30 && treatment.matches("\\w+");
        boolean costTrue = cost.matches("\\d{0,5}.\\d{0,2}");
        return true;
    }

    private void Btn_RecordTreatment_RecordActionPerformed(java.awt.event.ActionEvent evt) {
        String treatment = TxtFld_RecordTreatment_Treatment.getText();
        String costStr = TxtFld_RecordTreatment_Cost.getText();

        
        if (costStr.isEmpty()) {
            costStr = "0.0";
        }
        if(validate(treatment, costStr)) {
            BigDecimal cost = new BigDecimal(costStr);
            Patient p = appObj.getPatient();
            int remainCheckups = p.getPlan().getRemainCheckups();
            int remainTreatments = p.getPlan().getRemainTreatments();
            int remainHygiene = p.getPlan().getRemainHygiene();
            if ((treatment.toLowerCase().equals("check-up") || treatment.toLowerCase().equals("checkup")) && remainCheckups > 0) {
                p.getPlan().updateCheckUps();
                cost = new BigDecimal(0);
            } else if ((treatment.toLowerCase().equals("hygiene")) && remainHygiene >0) {
                p.getPlan().updateHygiene();
                cost = new BigDecimal(0);
            } else if (treatment.toLowerCase().equals("cosmetic")) {
                //do nothing as this doesnt cause treatments to go lower
            }else if  (remainTreatments >0) {
                p.getPlan().updateTreatments();
                cost = new BigDecimal(0);
            }

            new Treatment(appObj,treatment,cost);
            appObj.updatePatientSeen(true);

        } else {
            JOptionPane.showMessageDialog(this, "Inputs aren't valid");
        }


        
        setVisible(false);
        dispose();
    }

    private void Btn_RecordTreatment_CancelActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
        dispose();
    }

    public void setTreatment(Appointment app) {
        appObj = app;
    }

    private javax.swing.JToggleButton Btn_RecordTreatment_Cancel;
    private javax.swing.JButton Btn_RecordTreatment_Record;
    private javax.swing.JLabel Lbl_RecordTreatment_Cost;
    private javax.swing.JLabel Lbl_RecordTreatment_Treatment;
    private javax.swing.JTextField TxtFld_RecordTreatment_Cost;
    private javax.swing.JTextField TxtFld_RecordTreatment_Treatment;
    private javax.swing.JPanel jPanel1;
    private Appointment appObj;
}
