package com2002;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com2002.models.Appointment;
import com2002.models.Patient;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Abigail
 */
public class RecordVisit extends javax.swing.JFrame {

    public RecordVisit() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        RecordVisitPanel = new javax.swing.JPanel();
        TxtFld_RecordVisit_Date = new javax.swing.JTextField();
        TxtFld_RecordVisit_Start = new javax.swing.JTextField();
        TxtFld_RecordVisit_End = new javax.swing.JTextField();
        TxtFld_RecordVisit_Title = new javax.swing.JTextField();
        TxtFld_RecordVisit_Forename = new javax.swing.JTextField();
        TxtFld_RecordVisit_Surname = new javax.swing.JTextField();
        TxtFld_RecordVisit_Dob = new javax.swing.JTextField();
        TxtFld_RecordVisit_Contact = new javax.swing.JTextField();
        Lbl_RecordVisit_Date = new javax.swing.JLabel();
        Lbl_RecordVisit_Start = new javax.swing.JLabel();
        Lbl_RecordVisit_End = new javax.swing.JLabel();
        Lbl_RecordVisit_Title = new javax.swing.JLabel();
        Lbl_RecordVisit_Forename = new javax.swing.JLabel();
        Lbl_RecordVisit_Surname = new javax.swing.JLabel();
        Lbl_RecordVisit_Dob = new javax.swing.JLabel();
        Lbl_RecordVisit_Contact = new javax.swing.JLabel();
        TxtFld_RecordVisit_Partner = new javax.swing.JTextField();
        Lbl_RecordVisit_Partner = new javax.swing.JLabel();
        Btn_RecordVisit_OK = new javax.swing.JToggleButton();
        Btn_RecordVisit_Cancel = new javax.swing.JToggleButton();
        TxtFld_RecordVisit_Type = new javax.swing.JTextField();
        Lbl_RecordVisit_Type = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        TxtFld_RecordVisit_Date.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        TxtFld_RecordVisit_Start.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        TxtFld_RecordVisit_End.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        TxtFld_RecordVisit_Title.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        TxtFld_RecordVisit_Forename.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        TxtFld_RecordVisit_Surname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        TxtFld_RecordVisit_Dob.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        TxtFld_RecordVisit_Contact.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        Lbl_RecordVisit_Date.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Lbl_RecordVisit_Date.setText("Date");

        Lbl_RecordVisit_Start.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Lbl_RecordVisit_Start.setText("Start Time");
        Lbl_RecordVisit_Start.setToolTipText("");

        Lbl_RecordVisit_End.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Lbl_RecordVisit_End.setText("End Time");

        Lbl_RecordVisit_Title.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Lbl_RecordVisit_Title.setText("Title");

        Lbl_RecordVisit_Forename.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Lbl_RecordVisit_Forename.setText("Forename");
        Lbl_RecordVisit_Forename.setToolTipText("");

        Lbl_RecordVisit_Surname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Lbl_RecordVisit_Surname.setText("Surname");

        Lbl_RecordVisit_Dob.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Lbl_RecordVisit_Dob.setText("Date of Birth");

        Lbl_RecordVisit_Contact.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Lbl_RecordVisit_Contact.setText("Contact No.");

        TxtFld_RecordVisit_Partner.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        Lbl_RecordVisit_Partner.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Lbl_RecordVisit_Partner.setText("Partner");

        Btn_RecordVisit_OK.setText("OK");
        Btn_RecordVisit_OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_RecordVisit_OKActionPerformed(evt);
            }
        });

        Btn_RecordVisit_Cancel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Btn_RecordVisit_Cancel.setText("Record Visit");
        Btn_RecordVisit_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_RecordVisit_CancelActionPerformed(evt);
            }
        });

        TxtFld_RecordVisit_Type.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        Lbl_RecordVisit_Type.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Lbl_RecordVisit_Type.setText("Type ");

        javax.swing.GroupLayout RecordVisitPanelLayout = new javax.swing.GroupLayout(RecordVisitPanel);
        RecordVisitPanel.setLayout(RecordVisitPanelLayout);
        RecordVisitPanelLayout.setHorizontalGroup(
                RecordVisitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(RecordVisitPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(RecordVisitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(RecordVisitPanelLayout.createSequentialGroup()
                                                .addGroup(RecordVisitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(Lbl_RecordVisit_Start, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                                                        .addComponent(Lbl_RecordVisit_Date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(RecordVisitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(TxtFld_RecordVisit_Start)
                                                        .addComponent(TxtFld_RecordVisit_Date, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Lbl_RecordVisit_End)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(TxtFld_RecordVisit_End, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(RecordVisitPanelLayout.createSequentialGroup()
                                                .addGroup(RecordVisitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(RecordVisitPanelLayout.createSequentialGroup()
                                                                .addGroup(RecordVisitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(RecordVisitPanelLayout.createSequentialGroup()
                                                                                .addGroup(RecordVisitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(RecordVisitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                                .addComponent(Lbl_RecordVisit_Dob, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                .addComponent(Lbl_RecordVisit_Contact, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addComponent(Lbl_RecordVisit_Partner, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(Lbl_RecordVisit_Type, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addGroup(RecordVisitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                        .addComponent(TxtFld_RecordVisit_Contact, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                                                                        .addComponent(TxtFld_RecordVisit_Partner)
                                                                                        .addComponent(TxtFld_RecordVisit_Dob, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(TxtFld_RecordVisit_Type)))
                                                                        .addGroup(RecordVisitPanelLayout.createSequentialGroup()
                                                                                .addGroup(RecordVisitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                        .addComponent(Lbl_RecordVisit_Forename, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(Lbl_RecordVisit_Title, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addGroup(RecordVisitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(TxtFld_RecordVisit_Title, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addGroup(RecordVisitPanelLayout.createSequentialGroup()
                                                                                                .addComponent(TxtFld_RecordVisit_Forename, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(Lbl_RecordVisit_Surname)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(TxtFld_RecordVisit_Surname, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                                .addGap(0, 9, Short.MAX_VALUE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RecordVisitPanelLayout.createSequentialGroup()
                                                                .addComponent(Btn_RecordVisit_Cancel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(Btn_RecordVisit_OK)))
                                                .addContainerGap())))
        );
        RecordVisitPanelLayout.setVerticalGroup(
                RecordVisitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(RecordVisitPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(RecordVisitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TxtFld_RecordVisit_Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Lbl_RecordVisit_Date))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(RecordVisitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TxtFld_RecordVisit_Start, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Lbl_RecordVisit_Start)
                                        .addComponent(TxtFld_RecordVisit_End, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Lbl_RecordVisit_End))
                                .addGap(35, 35, 35)
                                .addGroup(RecordVisitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TxtFld_RecordVisit_Title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Lbl_RecordVisit_Title))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(RecordVisitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TxtFld_RecordVisit_Forename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Lbl_RecordVisit_Forename)
                                        .addComponent(TxtFld_RecordVisit_Surname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Lbl_RecordVisit_Surname))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(RecordVisitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TxtFld_RecordVisit_Dob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Lbl_RecordVisit_Dob))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(RecordVisitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TxtFld_RecordVisit_Contact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Lbl_RecordVisit_Contact))
                                .addGap(37, 37, 37)
                                .addGroup(RecordVisitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TxtFld_RecordVisit_Partner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Lbl_RecordVisit_Partner))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(RecordVisitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TxtFld_RecordVisit_Type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Lbl_RecordVisit_Type))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                .addGroup(RecordVisitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Btn_RecordVisit_OK)
                                        .addComponent(Btn_RecordVisit_Cancel))
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(RecordVisitPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(RecordVisitPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void Btn_RecordVisit_OKActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
    }

    private void Btn_RecordVisit_CancelActionPerformed(java.awt.event.ActionEvent evt) {
        RecordTreatment record = new RecordTreatment();
        record.setTreatment(appointmentObj);
        record.setVisible(true);
    }

    public void setRecordVisit(Appointment app) {
        appointmentObj = app;
        
        Patient patient = app.getPatient();
        String title = patient.getTitle();
        String forename = patient.getForename();
        String surname = patient.getSurname();
        String dateOfBirth = patient.getDateOfBirth().toString();
        String contactNo = patient.getContactNo();
        Date start = app.getStartTime();
        Date end = app.getEndTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        String startTime = timeFormat.format(start);
        String endTime = timeFormat.format(end);
        String dateStr = dateFormat.format(start);
        String staff = app.getStaff().getPosition();
        
        TxtFld_RecordVisit_Title.setText(title);
        TxtFld_RecordVisit_Forename.setText(forename);
        TxtFld_RecordVisit_Surname.setText(surname);
        TxtFld_RecordVisit_Dob.setText(dateOfBirth);
        TxtFld_RecordVisit_Contact.setText(contactNo);
        TxtFld_RecordVisit_Date.setText(dateStr);
        TxtFld_RecordVisit_Start.setText(startTime);
        TxtFld_RecordVisit_End.setText(endTime);
        TxtFld_RecordVisit_Partner.setText(staff);
        
        if (end.getTime() - start.getTime() == 1200000){
            if (staff.equals("Dentist")){
                TxtFld_RecordVisit_Type.setText("Check-Up");
            }
            else {
                TxtFld_RecordVisit_Type.setText("Hygiene");
            }
        }
        else{
            TxtFld_RecordVisit_Type.setText("Treatment");
        }
    }

    private javax.swing.JPanel RecordVisitPanel;
    private javax.swing.JToggleButton Btn_RecordVisit_Cancel;
    private javax.swing.JToggleButton Btn_RecordVisit_OK;
    private javax.swing.JLabel Lbl_RecordVisit_Contact;
    private javax.swing.JLabel Lbl_RecordVisit_Date;
    private javax.swing.JLabel Lbl_RecordVisit_Dob;
    private javax.swing.JLabel Lbl_RecordVisit_End;
    private javax.swing.JLabel Lbl_RecordVisit_Forename;
    private javax.swing.JLabel Lbl_RecordVisit_Partner;
    private javax.swing.JLabel Lbl_RecordVisit_Start;
    private javax.swing.JLabel Lbl_RecordVisit_Surname;
    private javax.swing.JLabel Lbl_RecordVisit_Title;
    private javax.swing.JLabel Lbl_RecordVisit_Type;
    private javax.swing.JTextField TxtFld_RecordVisit_Contact;
    private javax.swing.JTextField TxtFld_RecordVisit_Date;
    private javax.swing.JTextField TxtFld_RecordVisit_Dob;
    private javax.swing.JTextField TxtFld_RecordVisit_End;
    private javax.swing.JTextField TxtFld_RecordVisit_Forename;
    private javax.swing.JTextField TxtFld_RecordVisit_Partner;
    private javax.swing.JTextField TxtFld_RecordVisit_Start;
    private javax.swing.JTextField TxtFld_RecordVisit_Surname;
    private javax.swing.JTextField TxtFld_RecordVisit_Title;
    private javax.swing.JTextField TxtFld_RecordVisit_Type;
    private Appointment appointmentObj;
}
