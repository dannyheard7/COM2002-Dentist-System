package com2002;

import com2002.models.Patient;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class LookUpPatient extends javax.swing.JFrame {

    public LookUpPatient() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        LookUpPatientPanel = new javax.swing.JPanel();
        Lbl_LookUpPatient_Forename = new javax.swing.JLabel();
        TxtFld_LookUpPatient_Forename = new javax.swing.JTextField();
        Lbl_LookUpPatient_Surname = new javax.swing.JLabel();
        TxtFld_LookUpPatient_Surname = new javax.swing.JTextField();
        Lbl_LookUpPatient_Dob = new javax.swing.JLabel();
        TxtFld_LookUpPatient_Dob = new javax.swing.JTextField();
        Lbl_LookUpPatient_Postcode = new javax.swing.JLabel();
        TxtFld_LookUpPatient_Postcode = new javax.swing.JTextField();
        Btn_LookUpPatient_Submit = new javax.swing.JButton();
        Btn_LookUpPatient_Submit1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lookup Patient");

        Lbl_LookUpPatient_Forename.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Lbl_LookUpPatient_Forename.setText("Forename");
        Lbl_LookUpPatient_Forename.setName(""); // NOI18N

        Lbl_LookUpPatient_Surname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Lbl_LookUpPatient_Surname.setText("Surname");

        Lbl_LookUpPatient_Dob.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Lbl_LookUpPatient_Dob.setText("Date of Birth");
        TxtFld_LookUpPatient_Dob.setText("dd/mm/yyyy");
        TxtFld_LookUpPatient_Dob.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lookUpPatientMouseClicked(evt);
            }
        });

        Lbl_LookUpPatient_Postcode.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Lbl_LookUpPatient_Postcode.setText("Postcode");

        Btn_LookUpPatient_Submit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Btn_LookUpPatient_Submit.setText("Submit");
        Btn_LookUpPatient_Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_LookUpPatient_SubmitActionPerformed(evt);
            }
        });

        Btn_LookUpPatient_Submit1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Btn_LookUpPatient_Submit1.setText("Cancel");
        Btn_LookUpPatient_Submit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_LookUpPatient_Submit1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LookUpPatientPanelLayout = new javax.swing.GroupLayout(LookUpPatientPanel);
        LookUpPatientPanel.setLayout(LookUpPatientPanelLayout);
        LookUpPatientPanelLayout.setHorizontalGroup(
                LookUpPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(LookUpPatientPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(LookUpPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LookUpPatientPanelLayout.createSequentialGroup()
                                                .addComponent(Lbl_LookUpPatient_Postcode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(TxtFld_LookUpPatient_Postcode, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LookUpPatientPanelLayout.createSequentialGroup()
                                                .addComponent(Lbl_LookUpPatient_Dob)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(TxtFld_LookUpPatient_Dob, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LookUpPatientPanelLayout.createSequentialGroup()
                                                .addGroup(LookUpPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(Lbl_LookUpPatient_Forename, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(Lbl_LookUpPatient_Surname, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(LookUpPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(TxtFld_LookUpPatient_Forename)
                                                        .addComponent(TxtFld_LookUpPatient_Surname, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 10, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LookUpPatientPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Btn_LookUpPatient_Submit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Btn_LookUpPatient_Submit1)
                                .addContainerGap())
        );
        LookUpPatientPanelLayout.setVerticalGroup(
                LookUpPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(LookUpPatientPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(LookUpPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TxtFld_LookUpPatient_Forename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Lbl_LookUpPatient_Forename))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(LookUpPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TxtFld_LookUpPatient_Surname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Lbl_LookUpPatient_Surname))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(LookUpPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TxtFld_LookUpPatient_Dob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Lbl_LookUpPatient_Dob))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(LookUpPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TxtFld_LookUpPatient_Postcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Lbl_LookUpPatient_Postcode))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(LookUpPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Btn_LookUpPatient_Submit)
                                        .addComponent(Btn_LookUpPatient_Submit1))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(LookUpPatientPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(LookUpPatientPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>
    
    private boolean validate(String forename, String surname, String dob, String postcode) {
        boolean forenameTrue = !forename.isEmpty() && forename.length() <= 40;
        boolean surnameTrue = !surname.isEmpty() && surname.length() <= 40;
        boolean dobTrue = !dob.isEmpty() && dob.matches("\\d{2}/\\d{2}/\\d{4}$");
        boolean postcodeTrue = !postcode.isEmpty() && postcode.length() <= 8;
        return forenameTrue && surnameTrue && dobTrue && postcodeTrue;
    }

    private void Btn_LookUpPatient_SubmitActionPerformed(java.awt.event.ActionEvent evt) {
        String forename = TxtFld_LookUpPatient_Forename.getText();
        String surname = TxtFld_LookUpPatient_Surname.getText();  
        String dobString = TxtFld_LookUpPatient_Dob.getText();
        DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        String postcode = TxtFld_LookUpPatient_Postcode.getText();
        
        if (validate(forename, surname, dobString, postcode)) {     
            try {
                Date dob = fmt.parse(dobString);
                ArrayList<Patient> patients = Patient.findPatients(forename,surname,dob);
          
                for (Patient patient : patients) {
                    if (postcode.equals(patient.getAddress().getPostcode())) {
                        PatientView view = new PatientView();
                        view.setPatient(patient);
                        view.setVisible(true);
                    }
                    else {
                        JOptionPane.showMessageDialog(this, "No patient");
                    }
                }

                if (patients.size() == 0) {
                    JOptionPane.showMessageDialog(this, "No patient");
                }

            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Inputs aren't valid");
        }
    }

    private void Btn_LookUpPatient_Submit1ActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
        dispose();
    }

    private void lookUpPatientMouseClicked(java.awt.event.MouseEvent evt) {
        TxtFld_LookUpPatient_Dob.setText("");
    }

    private javax.swing.JButton Btn_LookUpPatient_Submit;
    private javax.swing.JButton Btn_LookUpPatient_Submit1;
    private javax.swing.JLabel Lbl_LookUpPatient_Dob;
    private javax.swing.JLabel Lbl_LookUpPatient_Forename;
    private javax.swing.JLabel Lbl_LookUpPatient_Postcode;
    private javax.swing.JLabel Lbl_LookUpPatient_Surname;
    private javax.swing.JPanel LookUpPatientPanel;
    private javax.swing.JTextField TxtFld_LookUpPatient_Dob;
    private javax.swing.JTextField TxtFld_LookUpPatient_Forename;
    private javax.swing.JTextField TxtFld_LookUpPatient_Postcode;
    private javax.swing.JTextField TxtFld_LookUpPatient_Surname;
}
