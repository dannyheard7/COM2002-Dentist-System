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
    private JPanel calendarMaster = new JPanel();
    private JPanel calendarMain = new JPanel();
    private JPanel dateWrapper =  new JPanel();
    private JPanel navWrapper =  new JPanel();
    private JPanel calendarWrapper =  new JPanel();
    private JButton[] dayButtons = new JButton[5];
    private int currentYear;
    private int currentMonth;
    private int currentWeek;
    private int currentDay;
    private int DoM;
    private int viewingDay;
    private int viewingWeek;
    private int viewingMonth;
    private BasicArrowButton nextWeek = new BasicArrowButton(BasicArrowButton.EAST);
    private BasicArrowButton prevWeek = new BasicArrowButton(BasicArrowButton.WEST);
    private JLabel weekDates;
    private JLabel viewWeek;
    private JLabel viewYear;




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
                secretaryMain();
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


    ///////// Setup for the secretary UI //////////////////////
    public void secretaryMain() {
        secretaryUI = new JFrame("Secretary Calendar View");
        secretaryUI.setContentPane(secContentPane);

        ///////////////////////// SET UP CALENDAR VALUES ///////////////////////
        Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        Date now = new Date();
        calendar.setTime(now);
        currentYear = calendar.get(Calendar.YEAR);
        currentMonth = calendar.get(Calendar.MONTH);
        currentWeek = calendar.get(Calendar.WEEK_OF_MONTH);
        currentDay = calendar.get(Calendar.DAY_OF_WEEK);
        DoM = calendar.get(Calendar.DAY_OF_MONTH);
        viewingDay = calendar.get(Calendar.DAY_OF_WEEK);
        viewingWeek = calendar.get(Calendar.WEEK_OF_MONTH);
        viewingMonth = calendar.get(Calendar.MONTH);

        viewYear = new JLabel(" ", SwingConstants.CENTER);
        viewYear.setFont(new Font("Helvetica", Font.PLAIN, 20));
        weekDates = new JLabel(" ", SwingConstants.CENTER);
        weekDates.setFont(new Font("Helvetica", Font.PLAIN, 20));
        viewWeek = new JLabel(" ", SwingConstants.CENTER);
        viewWeek.setFont(new Font("Helvetica", Font.PLAIN, 20));
        updateNav();
        //////////////////////////////////////////////////////////////////////////////



        //Build and the CalendarMaster panel
        calendarMaster.setLayout(new BoxLayout(calendarMaster, BoxLayout.Y_AXIS));
        //Gridbag for the nav bar
        navWrapper.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        //c.fill = GridBagConstraints.HORIZONTAL;

        // Week scrolling Buttons
        prevWeek.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewingDay += 7;

                calendarMain.removeAll();
                dateWrapper.removeAll();
                calendarWrapper.removeAll();
                calendarMaster.remove(calendarMain);

                buildCalendarMain(secContentPane);
                calendarMaster.repaint();
                calendarMaster.revalidate();
                updateNav();
            }
        });
        nextWeek.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewingDay -= 7;

                calendarMain.removeAll();
                dateWrapper.removeAll();
                calendarWrapper.removeAll();
                calendarMaster.remove(calendarMain);

                buildCalendarMain(secContentPane);
                calendarMaster.repaint();
                calendarMaster.revalidate();
                updateNav();
            }
        });
        //////////////////////////////////////////////////////////////////////////

        // Gridbag stuff
        c.ipady = 30;
        c.ipadx = 40;
        c.gridx = 0;
        c.gridy = 0;
        navWrapper.add(prevWeek,c);
        c.ipady = 30;
        c.ipadx = 50;
        c.gridx = 2;
        c.gridy = 0;
        c.gridwidth = 5;
        navWrapper.add(weekDates,c);
        c.ipady = 30;
        c.ipadx = 50;
        c.gridx = 7;
        c.gridy = 0;
        c.gridwidth = 4;
        navWrapper.add(viewYear,c);
        c.ipady = 30;
        c.ipadx = 40;
        c.gridx = 11;
        c.gridy = 0;
        navWrapper.add(nextWeek,c);

        calendarMaster.add(navWrapper);


        // build the calendar Main Panel, housing the day buttons
        buildCalendarMain(secContentPane);

        secretaryUI.add(calendarMaster);
        secretaryUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        secretaryUI.setSize(500,300);
        secretaryUI.setLocation(new Point(screenDimensions.width/2 - main.getWidth()/2,screenDimensions.height/2 - main.getWidth()/2));
        secretaryUI.setVisible(true);
    }


    //////////////////// Setup the main calendar panel ///////////////////////////
    public void buildCalendarMain(JPanel content) {

        calendarMain.setLayout(new BoxLayout(calendarMain, BoxLayout.Y_AXIS));

        //WIP
        calendarMain.add(dateWrapper);

        // Build the calendar wrapper
        buildCalendarWrapper();
        calendarMaster.add(calendarMain);

    }

    //////////////// Setup the weapper for the calendar days /////////////////////
    public void buildCalendarWrapper(){

        calendarWrapper.setLayout(new FlowLayout());

        JButton currentButton;

        for (int i=0; i<dayButtons.length; i++){
            JButton day = new JButton(days[i]);
            if (currentDay-2==i && viewingDay==currentDay){
                day.setBackground(Color.LIGHT_GRAY);
            }
            else{
                day.setBackground(Color.WHITE);
            }
            dayButtons[i] = day;
        }

        for (int i=0; i<dayButtons.length; i++){
            currentButton = dayButtons[i];
            calendarWrapper.add(currentButton);
        }

        calendarMain.add(calendarWrapper);

    }


    ///////////// Update the Nav bar ///////////////////
    public void updateNav(){
        int weekSpan;
        int offset = viewingDay-2;
        weekSpan = DoM+(4-offset);

        weekDates.setText(weekSpan-4 + "/" + viewingMonth + "-" + weekSpan + "/" + viewingMonth);
        viewYear.setText(String.valueOf(currentYear));
    }
}
