package com2002;

import com2002.models.Appointment;
import com2002.models.Patient;
import com2002.models.Treatment;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;

public class OutstandingCosts {

    private JList unpaidList;
    private JButton markPaidButton;
    private JTextField totalCostField;
    private JButton doneButton;
    private JPanel MainPanel;
    private JPanel InnerPanel;
    private JPanel ListPanel;
    private JPanel TotalPanel;
    private JPanel DonePanel;
    private DefaultListModel listModel;

    private Patient patient;

    public OutstandingCosts() {
        final JFrame frame = new JFrame("Outstanding Costs");
        frame.setContentPane(MainPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        markPaidButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Treatment t = (Treatment)unpaidList.getSelectedValue();

                if (t.pay()) {
                    BigDecimal totalCost = new BigDecimal(totalCostField.getText());
                    listModel.removeElement(t);
                    totalCostField.setText("£" + totalCost.subtract(t.getCost()).toString());
                }
            }
        });

        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Is this the best way to dispose?
                frame.setVisible(false);
                frame.dispose();
            }
        });
    }

    private void createUIComponents() {
        listModel = new DefaultListModel();
        unpaidList = new JList(listModel);
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
        ArrayList<Appointment> appointments = Appointment.findPatientsAppointments(patient);
        BigDecimal totalCost = new BigDecimal(0);

        for (Appointment a : appointments) {
            ArrayList<Treatment> treatments = a.getUnpaidTreatments();

            for (Treatment t : treatments) {
                listModel.addElement(t);
                totalCost = totalCost.add(t.getCost());
            }
        }

        totalCostField.setText("£" + totalCost.toString());
    }
}
