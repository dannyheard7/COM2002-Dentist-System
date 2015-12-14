package com2002;

import com2002.models.Appointment;
import com2002.models.Patient;
import com2002.models.Staff;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    @SuppressWarnings("unchecked")
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Book Appointment");

        Lbl_BookAppointment_Date.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Lbl_BookAppointment_Date.setText("Date");
        
        TxtFld_BookAppointment_Date.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TxtFld_BookAppointment_Date.setText("dd/mm/yyyy");
        TxtFld_BookAppointment_Date.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TxtFld_BookAppointment_Date.setText("");
            }
        });

        Lbl_BookAppointment_Start.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Lbl_BookAppointment_Start.setText("Start Time");       

        TxtFld_BookAppointment_Start.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TxtFld_BookAppointment_Start.setText("hh:mm");
        TxtFld_BookAppointment_Start.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TxtFld_BookAppointment_Start.setText("");
            }
        });

        Lbl_BookAppointment_End.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Lbl_BookAppointment_End.setText("End Time");

        TxtFld_BookAppointment_End.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TxtFld_BookAppointment_End.setText("hh:mm");
        TxtFld_BookAppointment_End.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TxtFld_BookAppointment_End.setText("");
            }
        }); 

        Lbl_BookAppointment_AppType.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Lbl_BookAppointment_AppType.setText("Partner");

        Combo_BookAppointment_AppType.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Combo_BookAppointment_AppType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dentist", "Hygienist" }));

        Lbl_BookAppointment_PatientID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Lbl_BookAppointment_PatientID.setText("Patient ID");

        TxtFld_BookAppointment_PatientID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        Btn_BookAppointment_FindPatient.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        Btn_BookAppointment_FindPatient.setText("Lookup");
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
                                                                .addComponent(TxtFld_BookAppointment_PatientID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(Btn_BookAppointment_FindPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(BookAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(TxtFld_BookAppointment_Date)
                                                                .addComponent(TxtFld_BookAppointment_Start)
                                                                .addComponent(TxtFld_BookAppointment_End))
                                                        .addComponent(Combo_BookAppointment_AppType, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BookAppointmentPanelLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Btn_BookAppointment_Submit)
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
                                        .addComponent(Btn_BookAppointment_Submit)
                                        .addComponent(Btn_BookAppointment_Cancel))
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
    }// </editor-fold>                        

    private void Btn_BookAppointment_FindPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_BookAppointment_FindPatientActionPerformed
        LookUpPatient lookup = new LookUpPatient();
        lookup.setVisible(true);
    }

    private boolean validate(String patientID, String date, String startTime, String endTime) {
        String dateTimeRegex = "(([0-1][0-9])|(2[0-3])):([0-5]\\d)";
        
        boolean patientIDTrue = patientID.matches("\\d*");
        boolean dateTrue = !date.isEmpty() && date.matches("([0-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/(\\d{4})");
        boolean startTimeTrue = !startTime.isEmpty() && startTime.matches(dateTimeRegex);
        boolean endTimeTrue = !endTime.isEmpty() && endTime.matches(dateTimeRegex);
        return patientIDTrue && dateTrue && startTimeTrue && endTimeTrue;
    }
    
    private void Btn_BookAppointment_SubmitActionPerformed(java.awt.event.ActionEvent evt) {                                                           
        String date = TxtFld_BookAppointment_Date.getText();
        String startTime = TxtFld_BookAppointment_Start.getText();
        String endTime = TxtFld_BookAppointment_End.getText();
        String patientID = TxtFld_BookAppointment_PatientID.getText();
        String partner = (String)Combo_BookAppointment_AppType.getSelectedItem();
        
        if (validate(patientID, date, startTime, endTime)) {        
            try {
                DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy H:m");
                Date startDate = fmt.parse(date + " " + startTime);
                Date endDate = fmt.parse(date + " " + endTime);
                Staff staff = Staff.getStaffWithPosition(partner).get(0);
                Appointment a;
                
                if (patientID.isEmpty()) {
                    a = new Appointment(startDate, endDate, staff);
                } else {
                    int patientId = Integer.parseInt(patientID);
                    a = new Appointment(new Patient(patientId), startDate, endDate, staff);
                }
                
                if (a.getID() != 0) {
                    showSuccess();
                } else {
                    JOptionPane.showMessageDialog(this, "Appointments overlap!");
                }
                
            } catch (Exception ex) {
                System.out.println(ex.toString());
            } 
        } else {
            JOptionPane.showMessageDialog(this, "Inputs aren't valid");
        }
        
    }
    
    private void showSuccess() {
        BookAppointmentPanel.removeAll();
        Lbl_BookAppointment_Success = new javax.swing.JLabel();
        Btn_BookAppointment_OK = new javax.swing.JButton();

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
    }

    private void Btn_BookAppointment_OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_BookAppointment_OKActionPerformed
        setVisible(false);
        dispose();
    }

    private void Btn_BookAppointment_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_BookAppointment_CancelActionPerformed
        setVisible(false);
        dispose();
    }

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
}
