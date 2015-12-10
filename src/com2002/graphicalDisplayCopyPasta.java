package com2002;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import com2002.models.*;

/**
 * Created by Abigail on 04/12/2015.
 */
public class graphicalDisplayCopyPasta {
    private static final JPanel gui = new JPanel(new BorderLayout(3, 3));
    private static final JPanel secContentPane = new JPanel(new BorderLayout(3, 3));
    private static final JPanel appOpsContentPane = new JPanel(new BorderLayout(3, 3));
    private static final JPanel bookAppContentPane = new JPanel(new GridLayout(5,2,10,5));
    private static final JPanel cancelAppContentPane = new JPanel(new GridLayout(5,2,10,5));
    private static final JPanel findAppContentPane = new JPanel(new GridLayout(4,4,10,5));
    private static final JPanel getPatientContentPane = new JPanel(new GridLayout(5,2,10,5));
    private static final JPanel ptnGui = new JPanel(new BorderLayout(3, 3));
    private static final JPanel recGui = new JPanel(new GridLayout(4,4,10,5));
    private static final JPanel tmntGui = new JPanel(new GridLayout(3,4,10,5));
    private static final char[] DAYS = {'M','T','W','T','F'};
    private static JButton[] calendar = new JButton[5];
    private static JPanel outerBoard;
    private static JFrame main;
    private static JFrame secretaryUI;
    private static JFrame partnerUI;
    private static JFrame recordVisitUI;
    private static JFrame addTreatmentUI;
    private static JFrame appointmentOpsUI;
    private static JFrame bookFormUI;
    private static JFrame cancelFormUI;
    private static JFrame findFormUI;
    private static JFrame getPatientUI;
    private static graphicalDisplayCopyPasta g;
    private Toolkit toolkit = Toolkit.getDefaultToolkit();
    private Dimension screenDimensions = toolkit.getScreenSize();
    private static JLabel space = new JLabel(" ");

    //private String[] DAYS = {"Monday","Tuesday"}

    public static void main(String[] args){
        g = new graphicalDisplayCopyPasta();
        g.startMain();
    }

    public void startMain() {
        //Sets up the JFrame
        main = new JFrame("Employee Selection");
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton secretary = new JButton("Secretary");
        secretary.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                secretaryMain();
                main.setVisible(false);
                main.dispose();
            }
        });
        JButton partner = new JButton("Partner");
        partner.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                partnerMain();
                main.setVisible(false);
                main.dispose();
            }
        });
        main.setContentPane(gui);
        JPanel employeeType = new JPanel(new FlowLayout());
        employeeType.add(secretary);
        employeeType.add(partner);
        gui.add(employeeType);
        main.setSize(screenDimensions.width/4- main.getWidth()/2,screenDimensions.height/6 - main.getWidth()/2);
        main.setLocation(new Point(screenDimensions.width/2 - main.getWidth()/2,screenDimensions.height/2 - main.getWidth()/2));
        main.setVisible(true);
    }

    public void partnerMain() {
        partnerUI = new JFrame("Partner Calendar View");
        partnerUI.setContentPane(ptnGui);

        JButton recordVisit = new JButton("Record Visit");
        recordVisit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                recordVisitForm();
                partnerUI.setVisible(false);
                partnerUI.dispose();
            }
        });
        JPanel partnerButtons = new JPanel(new FlowLayout());
        partnerButtons.add(recordVisit,BorderLayout.SOUTH);
        ptnGui.add(partnerButtons);

        partnerUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        partnerUI.setSize(500,300);

        partnerUI.setLocation(new Point(screenDimensions.width/2 - main.getWidth()/2,screenDimensions.height/2 - main.getWidth()/2));
        partnerUI.setVisible(true);
    }

    public void recordVisitForm() {
        recordVisitUI = new JFrame ("Record Visit");
        recordVisitUI.setContentPane(recGui);
        recGui.removeAll();

        String[] labels = {"Forename: ", "Surname: ", "Date of Birth: ", "House Number: ", "Street: ", "Postcode: "};
        int numPairs = labels.length;

        for (int i = 0; i < numPairs; i++) {
            JLabel l = new JLabel(labels[i], JLabel.TRAILING);
            recGui.add(l);
            JTextField textField = new JTextField(10);
            l.setLabelFor(textField);
            recGui.add(textField);
        }

        JButton addTreatment = new JButton("Add Treatment");
        addTreatment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addTreatmentForm();
            }
        });
        recGui.add(new JLabel(""));
        recGui.add(addTreatment);
        JButton submit = new JButton("Submit");
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                recordVisitUI.setVisible(false);
                recordVisitUI.dispose();
                partnerMain();
            }
        });
        recGui.add(submit);
        recordVisitUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        recordVisitUI.pack();

        recordVisitUI.setLocation(new Point(screenDimensions.width/2 - main.getWidth()/2,screenDimensions.height/2 - main.getWidth()/2));
        recordVisitUI.setVisible(true);
    }

    public void addTreatmentForm() {
        addTreatmentUI = new JFrame("Add Treatment");
        addTreatmentUI.setContentPane(tmntGui);
        tmntGui.removeAll();

        String[] labels = {"Treatment: ", "Cost: "};
        int numPairs = labels.length;

        for (int i = 0; i < numPairs; i++) {
            JLabel l = new JLabel(labels[i], JLabel.TRAILING);
            tmntGui.add(l);
            JTextField textField = new JTextField(10);
            l.setLabelFor(textField);
            tmntGui.add(textField);
        }
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Need to add code to put inputted info into database
                addTreatmentUI.setVisible(false);
                addTreatmentUI.dispose();
            }
        });
        JButton submit = new JButton("Submit");
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Need to add code to put inputted info into database
                addTreatmentUI.setVisible(false);
                addTreatmentUI.dispose();
            }
        });
        tmntGui.add(cancel);
        tmntGui.add(submit);


        addTreatmentUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addTreatmentUI.pack();

        addTreatmentUI.setLocation(new Point(screenDimensions.width/2 - main.getWidth()/2,screenDimensions.height/2 - main.getWidth()/2));
        addTreatmentUI.setVisible(true);
    }

    public void secretaryMain(){
        secretaryUI = new JFrame("Secretary Calendar View");
        secretaryUI.setContentPane(secContentPane);

        //BUTTONS
        //Patient Operations
        //Find appointment
        //Book appointment
        //Cancel appointment
        JButton appointmentOps = new JButton("Appointment Operations");
        appointmentOps.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                appointmentOperations();
                secretaryUI.setVisible(false);
                secretaryUI.dispose();
            }
        });
        JPanel secretaryButtons = new JPanel(new FlowLayout());
        secretaryButtons.add(appointmentOps,BorderLayout.SOUTH);
        secContentPane.add(secretaryButtons);

        secretaryUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        secretaryUI.pack();

        secretaryUI.setLocation(new Point(screenDimensions.width/2 - main.getWidth()/2,screenDimensions.height/2 - main.getWidth()/2));
        secretaryUI.setVisible(true);
    }

    public void appointmentOperations() {
        appointmentOpsUI = new JFrame("Appointment Operations");
        appointmentOpsUI.setContentPane(appOpsContentPane);

        JButton bookAppointment = new JButton("Book Appointment");
        bookAppointment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bookAppointmentForm();
                appointmentOpsUI.setVisible(false);
                appointmentOpsUI.dispose();
            }
        });

        JButton cancelAppointment = new JButton("Cancel Appointment");
        cancelAppointment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cancelAppointmentForm();
                appointmentOpsUI.setVisible(false);
                appointmentOpsUI.dispose();
            }
        });

        JButton findAppointment = new JButton("Find Appointment");
        findAppointment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                findAppointmentForm();
                appointmentOpsUI.setVisible(false);
                appointmentOpsUI.dispose();
            }
        });

        JPanel appointmentOpsButtons= new JPanel(new FlowLayout());
        appointmentOpsButtons.add(bookAppointment,BorderLayout.SOUTH);
        appointmentOpsButtons.add(cancelAppointment,BorderLayout.SOUTH);
        appointmentOpsButtons.add(findAppointment,BorderLayout.SOUTH);
        appOpsContentPane.add(appointmentOpsButtons);

        appointmentOpsUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appointmentOpsUI.pack();

        appointmentOpsUI.setLocation(new Point(screenDimensions.width/2 - main.getWidth()/2,screenDimensions.height/2 - main.getWidth()/2));
        appointmentOpsUI.setVisible(true);
    }

    public void bookAppointmentForm() {
        bookFormUI = new JFrame("Book Appointment");
        bookFormUI.setContentPane(bookAppContentPane);
        bookFormUI.setResizable(false);
        bookAppContentPane.removeAll();

        JLabel startLabel = new JLabel("Start Time: ", JLabel.TRAILING);
        JTextField startText= new JTextField(15);
        startLabel.setLabelFor(startText);
        bookAppContentPane.add(startLabel);
        bookAppContentPane.add(startText);

        JLabel endLabel = new JLabel("End Time: ", JLabel.TRAILING);
        JTextField endText= new JTextField(15);
        endLabel.setLabelFor(endText);
        bookAppContentPane.add(endLabel);
        bookAppContentPane.add(endText);

        String[] partnerType = {"Dentist", "Hygienist"};
        JComboBox partnerList = new JComboBox(partnerType);
        JLabel partnerLabel = new JLabel("Partner: ", JLabel.TRAILING);
        bookAppContentPane.add(partnerLabel);
        partnerLabel.setLabelFor(partnerList);
        partnerList.setSelectedIndex(0);
        bookAppContentPane.add(partnerList);

        JButton getPatientBtn = new JButton("Get Patient");
        JLabel patientLabel = new JLabel("Patient: ", JLabel.TRAILING);
        bookAppContentPane.add(patientLabel);
        patientLabel.setLabelFor(getPatientBtn);
        bookAppContentPane.add(getPatientBtn);

        getPatientBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                getPatient();
            }
        });

        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                appointmentOperations();
                bookFormUI.setVisible(false);
                bookFormUI.dispose();
            }
        });

        JButton submit = new JButton("Submit");
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //add code to
                    //put the appointment into the database
                    //return book success message
                String startTime = startText.getText();
                String endTime = endText.getText();
                SimpleDateFormat start = new SimpleDateFormat(startTime);
                SimpleDateFormat end = new SimpleDateFormat(endTime);
                String partnerType = partnerList.getSelectedItem().toString();
                Staff partner = new Staff(partnerType);
                int partnerID = partner.getId();
                //Appointment apmnt = new Appointment(start,end,partnerID);

                cancelFormUI.setVisible(false);
                cancelFormUI.dispose();
            }
        });

        bookAppContentPane.add(cancel);
        bookAppContentPane.add(submit);

        bookFormUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bookFormUI.pack();

        bookFormUI.setLocation(new Point(screenDimensions.width/2 - main.getWidth()/2,screenDimensions.height/2 - main.getWidth()/2));
        bookFormUI.setVisible(true);
    }

    public void cancelAppointmentForm() {
        cancelFormUI = new JFrame("Cancel Appointment");
        cancelFormUI.setContentPane(cancelAppContentPane);
        cancelFormUI.setResizable(false);
        cancelAppContentPane.removeAll();

        //Start. End. Partner.
        JLabel startLabel = new JLabel("Start Time: ", JLabel.TRAILING);
        JTextField startText= new JTextField(15);
        startLabel.setLabelFor(startText);
        cancelAppContentPane.add(startLabel);
        cancelAppContentPane.add(startText);

        JLabel endLabel = new JLabel("End Time: ", JLabel.TRAILING);
        JTextField endText= new JTextField(15);
        endLabel.setLabelFor(endText);
        cancelAppContentPane.add(endLabel);
        cancelAppContentPane.add(endText);

        String[] partnerType = {"Dentist", "Hygienist"};
        JComboBox partnerList = new JComboBox(partnerType);
        JLabel partnerLabel = new JLabel("Partner: ", JLabel.TRAILING);
        cancelAppContentPane.add(partnerLabel);
        partnerLabel.setLabelFor(partnerList);
        partnerList.setSelectedIndex(0);
        cancelAppContentPane.add(partnerList);

        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                appointmentOperations();
                cancelFormUI.setVisible(false);
                cancelFormUI.dispose();
            }
        });

        JButton submit = new JButton("Submit");
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //add code to
                    //Use patient ID and partner type to return a list of appointments
                    //foundAppointments(list of apntmnts);
                    //Show cancel success message
                String startTime = startText.getText();
                String endTime = endText.getText();
                SimpleDateFormat start = new SimpleDateFormat(startTime);
                SimpleDateFormat end = new SimpleDateFormat(endTime);
                String partnerType = partnerList.getSelectedItem().toString();
                Staff partner = new Staff(partnerType);
                int partnerID = partner.getId();
                //Appointment apmnt = new Appointment(start,end,partnerID);

                cancelFormUI.setVisible(false);
                cancelFormUI.dispose();
            }
        });

        cancelAppContentPane.add(cancel);
        cancelAppContentPane.add(submit);

        cancelFormUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cancelFormUI.pack();

        cancelFormUI.setLocation(new Point(screenDimensions.width/2 - main.getWidth()/2,screenDimensions.height/2 - main.getWidth()/2));
        cancelFormUI.setVisible(true);
    }

    public void findAppointmentForm() {
        findFormUI = new JFrame("Find Appointment");
        findFormUI.setContentPane(findAppContentPane);
        findFormUI.setResizable(false);
        findAppContentPane.removeAll();

        String[] partnerType = {"Dentist", "Hygienist"};
        JComboBox partnerList = new JComboBox(partnerType);
        JLabel partnerLabel = new JLabel("Partner: ", JLabel.TRAILING);
        findAppContentPane.add(partnerLabel);
        partnerLabel.setLabelFor(partnerList);
        partnerList.setSelectedIndex(0);
        findAppContentPane.add(partnerList);

        JButton getPatientBtn = new JButton("Get Patient");
        JLabel patientLabel = new JLabel("Patient: ", JLabel.TRAILING);
        findAppContentPane.add(patientLabel);
        patientLabel.setLabelFor(getPatientBtn);
        findAppContentPane.add(getPatientBtn);

        getPatientBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                getPatient();
            }
        });

        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                appointmentOperations();
                findFormUI.setVisible(false);
                findFormUI.dispose();
            }
        });

        JButton submit = new JButton("Submit");
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //add code to
                    //Use patient ID and partner type to return a list of appointments
                    //foundAppointments(list of apntmnts);
                String partnerType = partnerList.getSelectedItem().toString();
                //Patient patient = new Patient(forename,surname,dob,postCode);

                findFormUI.setVisible(false);
                findFormUI.dispose();
            }
        });

        findAppContentPane.add(cancel);
        findAppContentPane.add(submit);

        findFormUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        findFormUI.pack();

        findFormUI.setLocation(new Point(screenDimensions.width/2 - findFormUI.getWidth()/2,screenDimensions.height/2 - findFormUI.getWidth()/2));
        findFormUI.setVisible(true);
    }

    public void getPatient() {
        getPatientUI = new JFrame("Get Patient");
        getPatientUI.setContentPane(getPatientContentPane);
        getPatientUI.setResizable(false);
        getPatientContentPane.removeAll();

        JLabel forenameLabel = new JLabel("Forename: ", JLabel.TRAILING);
        JTextField forenameText= new JTextField(15);
        forenameLabel.setLabelFor(forenameText);
        getPatientContentPane.add(forenameLabel);
        getPatientContentPane.add(forenameText);

        JLabel surnameLabel = new JLabel("Surname: ", JLabel.TRAILING);
        JTextField surnameText= new JTextField(15);
        surnameLabel.setLabelFor(surnameText);
        getPatientContentPane.add(surnameLabel);
        getPatientContentPane.add(surnameText);

        JLabel dobLabel = new JLabel("Date of Birth: ", JLabel.TRAILING);
        JTextField dobText= new JTextField(15);
        dobLabel.setLabelFor(dobText);
        getPatientContentPane.add(dobLabel);
        getPatientContentPane.add(dobText);

        JLabel postCodeLabel = new JLabel("Post Code: ", JLabel.TRAILING);
        JTextField postCodeText= new JTextField(15);
        postCodeLabel.setLabelFor(postCodeText);
        getPatientContentPane.add(postCodeLabel);
        getPatientContentPane.add(postCodeText);

        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                getPatientUI.setVisible(false);
                getPatientUI.dispose();
            }
        });

        JButton submit = new JButton("Submit");
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //add code to
                    //return the patient id entered as a patient id field in find appointment

                String forename = forenameText.getText();
                String surname = surnameText.getText();

                //add code to
                    //dob validation
                    //postcode validation
                String dob = dobText.getText();
                String postCode = postCodeText.getText();

                //Patient patient = new Patient(forename,surname,dob,postCode);

                getPatientUI.setVisible(false);
                getPatientUI.dispose();
            }
        });
        getPatientContentPane.add(cancel);
        getPatientContentPane.add(submit);

        getPatientUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getPatientUI.pack();

        getPatientUI.setLocation(new Point(screenDimensions.width/2 - main.getWidth()/2,screenDimensions.height/2 - main.getWidth()/2));
        getPatientUI.setVisible(true);
    }
}
