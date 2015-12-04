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
    private static final JPanel gui = new JPanel(new BorderLayout(3, 3));
    private static final JPanel secGui = new JPanel(new BorderLayout(3, 3));
    private static final char[] DAYS = {'M','T','W','T','F'};
    private static JButton[] calendar = new JButton[5];
    private static JPanel outerBoard;
    private static JFrame main;
    private static JFrame secretaryUI;
    private static JFrame partnerUI;
    private static graphicalDisplay g;
    private Toolkit toolkit = Toolkit.getDefaultToolkit();
    private Dimension screenDimensions = toolkit.getScreenSize();
    //private String[] days = ["Monday","Tuesday"]

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
        JPanel calendar = new JPanel(new FlowLayout());
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

        calendar.add(day1);
        calendar.add(day2);
        calendar.add(day3);
        calendar.add(day4);
        calendar.add(day5);

        secGui.add(calendar);

        secretaryUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        secretaryUI.setSize(500,300);

        secretaryUI.setLocation(new Point(screenDimensions.width/2 - main.getWidth()/2,screenDimensions.height/2 - main.getWidth()/2));
        secretaryUI.setVisible(true);
    }



}
