package com2002;

/**
 * Created by Louis(Not AbiGAYle) on 04/12/2015.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.util.ArrayList;

public class graphicalDisplay {


    private static graphicalDisplay g;
    private Toolkit toolkit = Toolkit.getDefaultToolkit();
    private Dimension screenDimensions = toolkit.getScreenSize();
    private final String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    private JFrame main;
    private JFrame secretaryUI; // Top Layer
    private JFrame partnerUI;
    private final JPanel gui = new JPanel(new BorderLayout(3, 3));
    private final JPanel secGui = new JPanel(new BorderLayout(3, 3));
    private JPanel calendarMaster;
    private JPanel calendar;


    public static void main(String[] args){
        g = new graphicalDisplay();
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
                //partnerMain();
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

    public void secretaryMain() {
        secretaryUI = new JFrame("Secretary Calendar View");
        secretaryUI.setContentPane(secGui);



        secGui.add(buildCalendar());

        secretaryUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        secretaryUI.setSize(500,300);

        secretaryUI.setLocation(new Point(screenDimensions.width/2 - main.getWidth()/2,screenDimensions.height/2 - main.getWidth()/2));
        secretaryUI.setVisible(true);
    }

    public JPanel buildCalendar() {
        calendarMaster = new JPanel(new FlowLayout());
        calendar = new JPanel(new FlowLayout());
        JButton day1 = new JButton("Monday");
        day1.setBackground(Color.WHITE);
        JButton day2 = new JButton("Tuesday");
        day2.setBackground(Color.WHITE);
        JButton day3 = new JButton("Wednesday");
        day3.setBackground(Color.WHITE);
        JButton day4 = new JButton("Thursday");
        day4.setBackground(Color.WHITE);
        JButton day5 = new JButton("Friday");
        day5.setBackground(Color.WHITE);


        for (int i=0; i<5; i++) {
            calendarMaster.add(new JLabel(days[i]));
        }



        calendar.add(day1);
        calendar.add(day2);
        calendar.add(day3);
        calendar.add(day4);
        calendar.add(day5);

        calendarMaster.add(calendar);

        return calendarMaster;

    }

}
