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
import javax.swing.plaf.basic.BasicArrowButton;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class graphicalDisplay {


    private static graphicalDisplay g;
    private Toolkit toolkit = Toolkit.getDefaultToolkit();
    private Dimension screenDimensions = toolkit.getScreenSize();
    private String[] days = {"Monday","Tuesday", "Wednesday", "Thursday", "Friday"};
    private JFrame main;
    private JFrame secretaryUI; // Top Layer
    private JFrame partnerUI;
    private final JPanel mainContentPane = new JPanel(new BorderLayout(3, 3));
    private final JPanel secContentPane = new JPanel(new BorderLayout(3, 3));
    // Divided up calendar
    private JPanel calendarMaster = new JPanel();   //Flow
    private JPanel calendarMain = new JPanel();     //Box horizontal
    private JPanel navWrapper =  new JPanel();      //Gridbag
    private JPanel calendarWrapper =  new JPanel(); //Box horizontal
    private JPanel dateWrapper =  new JPanel();     //Flow
    private JPanel timetableMaster = new JPanel();  //Gridbag
    private JPanel timeHeaders = new JPanel();      //Box horizontal
    private JPanel hourColumns = new JPanel();      //Box horizontal
    private JButton[] dayButtons = new JButton[5];
    private Calendar calendar;
    private String dateActual;
    private BasicArrowButton nextWeek = new BasicArrowButton(BasicArrowButton.EAST);
    private BasicArrowButton prevWeek = new BasicArrowButton(BasicArrowButton.WEST);
    private JLabel weekDates;
    private JLabel viewWeek;
    private JLabel viewYear;


    private String weekStart;
    private String weekEnd;
    private String viewingYear;




    public static void main(String[] args){
        g = new graphicalDisplay();
        g.startMain();
    }

    public void startMain() {
        //Sets up the JFrame
        main = new JFrame("Employee Selection");
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Buttons to handle different users
        JButton secretary = new JButton("Secretary");
        secretary.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //secretaryUI.main();
                main.setVisible(false);
                main.dispose();
            }
        });
        //WIP
        JButton partner = new JButton("Partner");
        partner.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //partnerMain();
            }
        });

        main.setContentPane(mainContentPane);
        JPanel employeeType = new JPanel(new FlowLayout());
        employeeType.add(secretary);
        employeeType.add(partner);
        mainContentPane.add(employeeType);
        main.setSize(screenDimensions.width/4- main.getWidth()/2,screenDimensions.height/6 - main.getWidth()/2);
        main.setLocation(new Point(screenDimensions.width/2 - main.getWidth()/2,screenDimensions.height/2 - main.getWidth()/2));
        main.setVisible(true);
    }


}
