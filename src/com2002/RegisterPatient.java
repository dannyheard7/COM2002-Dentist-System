package com2002;

import com2002.models.Address;
import com2002.models.Patient;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterPatient extends javax.swing.JFrame {

    public RegisterPatient() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        RegisterPatientPanel = new javax.swing.JPanel();
        Lbl_RegisterPatient_Title = new javax.swing.JLabel();
        TxtFld_RegisterPatient_Title = new javax.swing.JTextField();
        TxtFld_RegisterPatient_Forename = new javax.swing.JTextField();
        TxtFld_RegisterPatient_Surname = new javax.swing.JTextField();
        TxtFld_RegisterPatient_Dob = new javax.swing.JTextField();
        TxtFld_RegisterPatient_Contact = new javax.swing.JTextField();
        TxtFld_RegisterPatient_House = new javax.swing.JTextField();
        TxtFld_RegisterPatient_Street = new javax.swing.JTextField();
        TxtFld_RegisterPatient_City = new javax.swing.JTextField();
        TxtFld_RegisterPatient_District = new javax.swing.JTextField();
        TxtFld_RegisterPatient_Postcode = new javax.swing.JTextField();
        Lbl_RegisterPatient_Forename = new javax.swing.JLabel();
        Lbl_RegisterPatient_Surname = new javax.swing.JLabel();
        Lbl_RegisterPatient_Dob = new javax.swing.JLabel();
        Lbl_RegisterPatient_Contact = new javax.swing.JLabel();
        Lbl_RegisterPatient_House = new javax.swing.JLabel();
        Lbl_RegisterPatient_Street = new javax.swing.JLabel();
        Lbl_RegisterPatient_City = new javax.swing.JLabel();
        Lbl_RegisterPatient_District = new javax.swing.JLabel();
        Lbl_RegisterPatient_Postcode = new javax.swing.JLabel();
        Btn_RegisterPatient_Cancel = new javax.swing.JButton();
        Btn_RegisterPatient_Submit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Register Patient");

        Lbl_RegisterPatient_Title.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Lbl_RegisterPatient_Title.setText("Title");

        TxtFld_RegisterPatient_Title.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        TxtFld_RegisterPatient_Forename.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        TxtFld_RegisterPatient_Surname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        TxtFld_RegisterPatient_Dob.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TxtFld_RegisterPatient_Dob.setText("dd/mm/yyyy");
        TxtFld_RegisterPatient_Dob.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TxtFld_RegisterPatient_Dob.setText("");
            }
        });


        TxtFld_RegisterPatient_Contact.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        TxtFld_RegisterPatient_House.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        TxtFld_RegisterPatient_Street.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        TxtFld_RegisterPatient_City.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TxtFld_RegisterPatient_City.setToolTipText("");

        TxtFld_RegisterPatient_District.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        TxtFld_RegisterPatient_Postcode.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        Lbl_RegisterPatient_Forename.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Lbl_RegisterPatient_Forename.setText("Forename");

        Lbl_RegisterPatient_Surname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Lbl_RegisterPatient_Surname.setText("Surname");

        Lbl_RegisterPatient_Dob.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Lbl_RegisterPatient_Dob.setText("Date of Birth");

        Lbl_RegisterPatient_Contact.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Lbl_RegisterPatient_Contact.setText("Contact No.");

        Lbl_RegisterPatient_House.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Lbl_RegisterPatient_House.setText("House No.");

        Lbl_RegisterPatient_Street.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Lbl_RegisterPatient_Street.setText("Street");

        Lbl_RegisterPatient_City.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Lbl_RegisterPatient_City.setText("City");

        Lbl_RegisterPatient_District.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Lbl_RegisterPatient_District.setText("District");

        Lbl_RegisterPatient_Postcode.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Lbl_RegisterPatient_Postcode.setText("Postcode");

        Btn_RegisterPatient_Cancel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Btn_RegisterPatient_Cancel.setText("Cancel");
        Btn_RegisterPatient_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_RegisterPatient_CancelActionPerformed(evt);
            }
        });

        Btn_RegisterPatient_Submit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Btn_RegisterPatient_Submit.setText("Submit");
        Btn_RegisterPatient_Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_RegisterPatient_SubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RegisterPatientPanelLayout = new javax.swing.GroupLayout(RegisterPatientPanel);
        RegisterPatientPanel.setLayout(RegisterPatientPanelLayout);
        RegisterPatientPanelLayout.setHorizontalGroup(
                RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(RegisterPatientPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(RegisterPatientPanelLayout.createSequentialGroup()
                                                .addGroup(RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(Lbl_RegisterPatient_Dob, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(Lbl_RegisterPatient_Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(Lbl_RegisterPatient_Forename, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(Lbl_RegisterPatient_Contact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(RegisterPatientPanelLayout.createSequentialGroup()
                                                                .addGroup(RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(TxtFld_RegisterPatient_Title, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(TxtFld_RegisterPatient_Forename, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                                                        .addComponent(TxtFld_RegisterPatient_Contact))
                                                                .addGap(34, 34, 34)
                                                                .addComponent(Lbl_RegisterPatient_Surname, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(TxtFld_RegisterPatient_Dob, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(TxtFld_RegisterPatient_Surname, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(RegisterPatientPanelLayout.createSequentialGroup()
                                                .addGroup(RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(Lbl_RegisterPatient_House, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(Lbl_RegisterPatient_Street, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(Lbl_RegisterPatient_City, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(Lbl_RegisterPatient_District, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(Lbl_RegisterPatient_Postcode, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(TxtFld_RegisterPatient_House, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(TxtFld_RegisterPatient_City)
                                                                .addComponent(TxtFld_RegisterPatient_District)
                                                                .addComponent(TxtFld_RegisterPatient_Postcode, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(TxtFld_RegisterPatient_Street, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(21, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegisterPatientPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Btn_RegisterPatient_Submit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Btn_RegisterPatient_Cancel)
                                .addContainerGap())
        );
        RegisterPatientPanelLayout.setVerticalGroup(
                RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(RegisterPatientPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TxtFld_RegisterPatient_Title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Lbl_RegisterPatient_Title))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TxtFld_RegisterPatient_Forename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Lbl_RegisterPatient_Forename)
                                        .addComponent(TxtFld_RegisterPatient_Surname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Lbl_RegisterPatient_Surname))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TxtFld_RegisterPatient_Dob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Lbl_RegisterPatient_Dob))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TxtFld_RegisterPatient_Contact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Lbl_RegisterPatient_Contact))
                                .addGap(18, 18, 18)
                                .addGroup(RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TxtFld_RegisterPatient_House, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Lbl_RegisterPatient_House))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TxtFld_RegisterPatient_Street, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Lbl_RegisterPatient_Street))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TxtFld_RegisterPatient_City, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Lbl_RegisterPatient_City))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TxtFld_RegisterPatient_District, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Lbl_RegisterPatient_District))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TxtFld_RegisterPatient_Postcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Lbl_RegisterPatient_Postcode))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Btn_RegisterPatient_Cancel)
                                        .addComponent(Btn_RegisterPatient_Submit))
                                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(RegisterPatientPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(RegisterPatientPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private boolean validate(String title, String forename, String surname, String dob, String contactNo,
            String houseNo, String street, String city, String district, String postcode) {
        boolean titleTrue = !title.isEmpty() && title.length() <= 10;
        boolean forenameTrue = !forename.isEmpty() && forename.length() <= 40;
        boolean surnameTrue = !surname.isEmpty() && surname.length() <= 40;
        boolean dobTrue = !dob.isEmpty() && dob.matches("\\d{2}/\\d{2}/\\d{4}$");
        boolean contactNoTrue = !contactNo.isEmpty() && contactNo.length() <= 15 && contactNo.matches("\\d*");
        boolean houseNoTrue = !houseNo.isEmpty() && houseNo.length() <= 6 && houseNo.matches("\\d+");
        boolean streetTrue = !street.isEmpty() && street.length() <= 30;
        boolean cityTrue = !city.isEmpty() && city.length() <= 30;
        boolean districtTrue = !district.isEmpty() && district.length() <= 30;
        boolean postcodeTrue = !postcode.isEmpty() && postcode.length() <= 8;
        
        return titleTrue && forenameTrue && surnameTrue && dobTrue && contactNoTrue && houseNoTrue && 
                streetTrue && cityTrue && districtTrue && postcodeTrue;
    }

    private void Btn_RegisterPatient_SubmitActionPerformed(java.awt.event.ActionEvent evt) {
        String title = TxtFld_RegisterPatient_Title.getText();
        String forename = TxtFld_RegisterPatient_Forename.getText();
        String surname = TxtFld_RegisterPatient_Surname.getText();
        
        String dobString = TxtFld_RegisterPatient_Dob.getText();
        String contactNo = TxtFld_RegisterPatient_Contact.getText();  
        String houseNoString = TxtFld_RegisterPatient_House.getText().trim();
        String street = TxtFld_RegisterPatient_Street.getText();
        String city = TxtFld_RegisterPatient_City.getText();
        String district = TxtFld_RegisterPatient_District.getText();
        String postcode = TxtFld_RegisterPatient_Postcode.getText();

        if (validate(title, forename, surname, dobString, contactNo, houseNoString, street,
                city, district, postcode)) {
            int houseNo = Integer.parseInt(houseNoString);
            
            try {
                DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
                Date dob = fmt.parse(dobString);
                Patient patient = new Patient(title,forename,surname,dob,contactNo);
                Address a = new Address(houseNo,street,city,district, postcode);
                patient.addAddress(a);
                showSuccess();
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Inputs aren't valid");
        }
    }

    private void Btn_RegisterPatient_CancelActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
    }

    private void showSuccess() {
        RegisterPatientPanel.removeAll();
        Lbl_RegisterPatient_Success = new javax.swing.JLabel();
        Btn_RegisterPatient_OK = new javax.swing.JButton();

        Lbl_RegisterPatient_Success.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_RegisterPatient_Success.setText("Patient successfully registered.");
        Lbl_RegisterPatient_Success.setToolTipText("");

        Btn_RegisterPatient_OK.setText("OK");
        Btn_RegisterPatient_OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_RegisterPatient_OKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BookAppointmentPanelLayout = new javax.swing.GroupLayout(RegisterPatientPanel);
        RegisterPatientPanel.setLayout(BookAppointmentPanelLayout);
        BookAppointmentPanelLayout.setHorizontalGroup(
                BookAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(BookAppointmentPanelLayout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addComponent(Btn_RegisterPatient_OK)
                                .addContainerGap(120, Short.MAX_VALUE))
                        .addComponent(Lbl_RegisterPatient_Success, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        BookAppointmentPanelLayout.setVerticalGroup(
                BookAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(BookAppointmentPanelLayout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(Lbl_RegisterPatient_Success, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Btn_RegisterPatient_OK)
                                .addContainerGap(92, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(RegisterPatientPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(RegisterPatientPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void Btn_RegisterPatient_OKActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
        dispose();
    }

    private javax.swing.JButton Btn_RegisterPatient_Cancel;
    private javax.swing.JButton Btn_RegisterPatient_Submit;
    private javax.swing.JLabel Lbl_RegisterPatient_City;
    private javax.swing.JLabel Lbl_RegisterPatient_Contact;
    private javax.swing.JLabel Lbl_RegisterPatient_District;
    private javax.swing.JLabel Lbl_RegisterPatient_Dob;
    private javax.swing.JLabel Lbl_RegisterPatient_Forename;
    private javax.swing.JLabel Lbl_RegisterPatient_House;
    private javax.swing.JLabel Lbl_RegisterPatient_Postcode;
    private javax.swing.JLabel Lbl_RegisterPatient_Street;
    private javax.swing.JLabel Lbl_RegisterPatient_Surname;
    private javax.swing.JLabel Lbl_RegisterPatient_Title;
    private javax.swing.JPanel RegisterPatientPanel;
    private javax.swing.JTextField TxtFld_RegisterPatient_City;
    private javax.swing.JTextField TxtFld_RegisterPatient_Contact;
    private javax.swing.JTextField TxtFld_RegisterPatient_District;
    private javax.swing.JTextField TxtFld_RegisterPatient_Dob;
    private javax.swing.JTextField TxtFld_RegisterPatient_Forename;
    private javax.swing.JTextField TxtFld_RegisterPatient_House;
    private javax.swing.JTextField TxtFld_RegisterPatient_Postcode;
    private javax.swing.JTextField TxtFld_RegisterPatient_Street;
    private javax.swing.JTextField TxtFld_RegisterPatient_Surname;
    private javax.swing.JTextField TxtFld_RegisterPatient_Title;
    private javax.swing.JButton Btn_RegisterPatient_OK;
    private javax.swing.JLabel Lbl_RegisterPatient_Success;
}
