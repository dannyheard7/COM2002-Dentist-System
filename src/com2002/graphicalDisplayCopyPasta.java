package com2002;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Abigail on 04/12/2015.
 */
public class graphicalDisplayCopyPasta {
    private static final JPanel gui = new JPanel(new BorderLayout(3, 3));
    private static final JPanel secGui = new JPanel(new BorderLayout(3, 3));
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
    private static graphicalDisplayCopyPasta g;
    private Toolkit toolkit = Toolkit.getDefaultToolkit();
    private Dimension screenDimensions = toolkit.getScreenSize();
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
                //secretaryMain();
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

}
