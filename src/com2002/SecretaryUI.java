package com2002;

import com2002.models.Appointment;
import com2002.models.Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SecretaryUI extends javax.swing.JFrame {

    public SecretaryUI() {

        // Initialise the calendar
        calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        Date now = new Date();
        calendar.setTime(now);
        DateFormat dateAct = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        today = calendar.getTime();
        dateActual = dateAct.format(calendar.getTime());

        // Initialise the UI components
        initComponents();
        this.setLocationRelativeTo(null);

        // Set UI type text
        uiType.setText("Viewing for Secretary");

        // Update individual UI elements, pinging the SQL database
        updateNav();
        updateDays();
        updateDayButtons();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.setTime(today);
        updateTimetable();
        recolourButtons(calendar.getTime());
    }

    // Function to update the Nav bar, adjusting the date to the correct week etc.
    public void updateNav(){
        // Format and display the date values in the Nav bar
        DateFormat dFormat = new SimpleDateFormat("MMMM", Locale.getDefault());
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        displayMonth = dFormat.format(calendar.getTime());

        DateFormat dFormat2 = new SimpleDateFormat("dd", Locale.getDefault());
        weekStart = dFormat2.format(calendar.getTime());
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
        weekEnd = dFormat2.format(calendar.getTime());
        weekDates.setText(displayMonth + "  Week: " + weekStart + " - " + weekEnd);

        DateFormat yFormat = new SimpleDateFormat("yyyy", Locale.getDefault());
        displayYear = yFormat.format(calendar.getTime());
        yearDate.setText(displayYear);
    }

    // Function to update the dates for the days of the week, heading the day buttons
    public void updateDays(){
        DateFormat dFormat = new SimpleDateFormat("dd", Locale.getDefault());
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        date1L.setText("Mon - " + dFormat.format(calendar.getTime()));
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
        date2L.setText("Tues - " + dFormat.format(calendar.getTime()));
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
        date3L.setText("Wed - " + dFormat.format(calendar.getTime()));
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
        date4L.setText("Thurs - " + dFormat.format(calendar.getTime()));
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
        date5L.setText("Fri - " + dFormat.format(calendar.getTime()));
    }

    // Function to update the buttons for each day of the week, displaying the number of appointments
    // on the day, and showing the right colour
    public void updateDayButtons(){

        refdate = calendar.getTime();
        // Colour the buttons appropriately
        recolourButtons(calendar.getTime());

        // Get appointments on each day
        ArrayList<Integer> apts = new ArrayList<>();
        for(int i=0; i<5; i++){
            calendar.set(Calendar.DAY_OF_WEEK, (i+2));
            ArrayList<Appointment> dayApts = Appointment.getAppointmentsOnDate(calendar.getTime());
            apts.add(dayApts.size());
        }

        // Set the value for each button
        day1B.setText(String.valueOf(apts.get(0)));
        day2B.setText(String.valueOf(apts.get(1)));
        day3B.setText(String.valueOf(apts.get(2)));
        day4B.setText(String.valueOf(apts.get(3)));
        day5B.setText(String.valueOf(apts.get(4)));
    }

    // Function to repaint the colour of buttons
    public void recolourButtons(Date currentDate){
        // Default to light gray
        day1B.setBackground(Color.LIGHT_GRAY);
        day2B.setBackground(Color.LIGHT_GRAY);
        day3B.setBackground(Color.LIGHT_GRAY);
        day4B.setBackground(Color.LIGHT_GRAY);
        day5B.setBackground(Color.LIGHT_GRAY);

        // Find today's date
        int trueDay = 0;
        for(int i=0; i<5; i++){
            calendar.set(Calendar.DAY_OF_WEEK, (i+2));
            DateFormat tDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            String tempDate = tDate.format(calendar.getTime());
            if(tempDate.equals(dateActual)){
                trueDay = i+1;
            }
        }
        // Colour it green
        switch (trueDay) {
            case 1:
                day1B.setBackground(new Color(0,153,51));
                break;
            case 2:
                day2B.setBackground(new Color(0,153,51));
                break;
            case 3:
                day3B.setBackground(new Color(0,153,51));
                break;
            case 4:
                day4B.setBackground(new Color(0,153,51));
                break;
            case 5:
                day5B.setBackground(new Color(0,153,51));
                break;
            default:
                break;
        }

        // Colour the day button corresponding to the current day open in the timetable
        calendar.setTime(currentDate);
        int dayInWeek = calendar.get(Calendar.DAY_OF_WEEK);
        switch (dayInWeek-1) {
            case 1:
                day1B.setBackground(Color.GRAY);
                break;
            case 2:
                day2B.setBackground(Color.GRAY);
                break;
            case 3:
                day3B.setBackground(Color.GRAY);
                break;
            case 4:
                day4B.setBackground(Color.GRAY);
                break;
            case 5:
                day5B.setBackground(Color.GRAY);
                break;
        }
    }

    // Function to update the timetable, displaying the correct day.
    // This defaults to Today on open, Monday on next week, and the specific day on search
    public void updateTimetable(){
        // Set the date
        Date now = calendar.getTime();
        ArrayList<Appointment> dayApts = Appointment.getAppointmentsOnDate(calendar.getTime());

        // Lists for each timeslot
        ArrayList<Appointment> slot1apts = new ArrayList<>();
        ArrayList<Appointment> slot2apts = new ArrayList<>();
        ArrayList<Appointment> slot3apts = new ArrayList<>();
        ArrayList<Appointment> slot4apts = new ArrayList<>();
        ArrayList<Appointment> slot5apts = new ArrayList<>();
        ArrayList<Appointment> slot6apts = new ArrayList<>();
        ArrayList<Appointment> slot7apts = new ArrayList<>();
        ArrayList<Appointment> slot8apts = new ArrayList<>();

        // Split the appointments in to their correct time slots based on start time
        for (int i=0; i<dayApts.size(); i++){
            DateFormat time = new SimpleDateFormat("HH");
            Appointment singleApt = dayApts.get(i);
            Date startTime = singleApt.getStartTime();
            Date endTime = singleApt.getEndTime();
            String st = time.format(startTime);
            if (st.equals("09")){
                slot1apts.add(singleApt);
            }
            else if (st.equals("10")){
                slot2apts.add(singleApt);
            }
            else if (st.equals("11")){
                slot3apts.add(singleApt);
            }
            else if (st.equals("12")){
                slot4apts.add(singleApt);
            }
            else if (st.equals("13")){
                slot5apts.add(singleApt);
            }
            else if (st.equals("14")){
                slot6apts.add(singleApt);
            }
            else if (st.equals("15")){
                slot7apts.add(singleApt);
            }
            else if (st.equals("16")){
                slot8apts.add(singleApt);
            }
        }

        // Update each hour slot
        updateHourSlot(appointmentSlot1, slot1apts, now);
        updateHourSlot(appointmentSlot2, slot2apts, now);
        updateHourSlot(appointmentSlot3, slot3apts, now);
        updateHourSlot(appointmentSlot4, slot4apts, now);
        updateHourSlot(appointmentSlot5, slot5apts, now);
        updateHourSlot(appointmentSlot6, slot6apts, now);
        updateHourSlot(appointmentSlot7, slot7apts, now);
        updateHourSlot(appointmentSlot8, slot8apts, now);
    }

    // Update the contents of each Hour slot
    public void updateHourSlot(JPanel slot, ArrayList<Appointment> apts, final Date now){
        // Remove any appointments
        slot.removeAll();

        // Display new appointments, adding a new button for each one
        for (int i=0; i<apts.size(); i++){
            DateFormat time = new SimpleDateFormat("HH:mm");
            final Appointment currentApt = apts.get(i);
            Patient aptPatient;
            String forename;
            String surname;
            String practitioner = currentApt.getStaff().getPosition();
            if (currentApt.getPatient()==null){
                forename = "Time";
                surname = "Off";
            }
            else {
                aptPatient = currentApt.getPatient();
                forename = aptPatient.getForename();
                surname = aptPatient.getSurname();
            }
            Date startTime = currentApt.getStartTime();
            Date endTime = currentApt.getEndTime();
            String st = time.format(startTime);
            String et = time.format(endTime);

            // Add a button for the appointment, showing some rudimentary details
            JButton appointment = new JButton("<html>" + st + " - " + et + "<br />" + forename + " " + surname + "<br />" + practitioner + "</html>");
            // Add a listener to open the full "Appointment View" panel
            appointment.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    // Create the appointment view
                    AppointmentView appointmentDetails = new AppointmentView();
                    appointmentDetails.setAppointment(currentApt);
                    appointmentDetails.setVisible(true);
                    // Had to modify the close action to update the details on screen, to remove the need for manual refreshing
                    appointmentDetails.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                            // Update the relevant UI elements
                            updateDayButtons();
                            calendar.setTime(now);
                            updateTimetable();
                        }
                    });
                }
            });

            // Add the button to the panel
            slot.add(appointment);
        }

        // Repaint
        slot.invalidate();
        slot.revalidate();
        slot.repaint();
    }


    // The code below was generated by the netBeans UI designer //
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        calendarMaster = new javax.swing.JPanel();
        navWrapper = new javax.swing.JPanel();
        nextWeek = new javax.swing.JButton();
        prevWeek = new javax.swing.JButton();
        weekDates = new javax.swing.JLabel();
        yearDate = new javax.swing.JLabel();
        weekWrapper = new javax.swing.JPanel();
        day1B = new javax.swing.JButton();
        day2B = new javax.swing.JButton();
        day3B = new javax.swing.JButton();
        day4B = new javax.swing.JButton();
        day5B = new javax.swing.JButton();
        date1L = new javax.swing.JLabel();
        date2L = new javax.swing.JLabel();
        date3L = new javax.swing.JLabel();
        date4L = new javax.swing.JLabel();
        date5L = new javax.swing.JLabel();
        timetableWrapper = new javax.swing.JPanel();
        hourSlot1 = new javax.swing.JPanel();
        timeLBL1 = new javax.swing.JLabel();
        appointmentSlot1 = new javax.swing.JPanel();
        hourSlot2 = new javax.swing.JPanel();
        timeLBL2 = new javax.swing.JLabel();
        appointmentSlot2 = new javax.swing.JPanel();
        hourSlot3 = new javax.swing.JPanel();
        timeLBL3 = new javax.swing.JLabel();
        appointmentSlot3 = new javax.swing.JPanel();
        hourSlot4 = new javax.swing.JPanel();
        timeLBL4 = new javax.swing.JLabel();
        appointmentSlot4 = new javax.swing.JPanel();
        hourSlot5 = new javax.swing.JPanel();
        timeLBL5 = new javax.swing.JLabel();
        appointmentSlot5 = new javax.swing.JPanel();
        hourSlot6 = new javax.swing.JPanel();
        timeLBL6 = new javax.swing.JLabel();
        appointmentSlot6 = new javax.swing.JPanel();
        hourSlot7 = new javax.swing.JPanel();
        timeLBL7 = new javax.swing.JLabel();
        appointmentSlot7 = new javax.swing.JPanel();
        hourSlot8 = new javax.swing.JPanel();
        timeLBL8 = new javax.swing.JLabel();
        appointmentSlot8 = new javax.swing.JPanel();
        controlMaster = new javax.swing.JPanel();
        lookupPatient = new javax.swing.JButton();
        bookAppointment = new javax.swing.JButton();
        searchDate = new javax.swing.JTextField();
        goToButton = new javax.swing.JButton();
        resetDate = new javax.swing.JButton();
        registerPatient = new javax.swing.JButton();
        uiType = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        calendarMaster.setBackground(new java.awt.Color(255, 255, 255));

        navWrapper.setBackground(new java.awt.Color(204, 204, 204));

        nextWeek.setText("Next Week");
        nextWeek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextWeekActionPerformed(evt);
            }
        });

        prevWeek.setText("Prev. Week");
        prevWeek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevWeekActionPerformed(evt);
            }
        });

        weekDates.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        weekDates.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        weekDates.setText("jLabel1");

        yearDate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        yearDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yearDate.setText("jLabel1");

        javax.swing.GroupLayout navWrapperLayout = new javax.swing.GroupLayout(navWrapper);
        navWrapper.setLayout(navWrapperLayout);
        navWrapperLayout.setHorizontalGroup(
                navWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(navWrapperLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(prevWeek, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(weekDates, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(yearDate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                                .addComponent(nextWeek, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        navWrapperLayout.setVerticalGroup(
                navWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(navWrapperLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(navWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(nextWeek, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(prevWeek, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(weekDates, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(yearDate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(22, Short.MAX_VALUE))
        );

        weekWrapper.setBackground(new java.awt.Color(204, 204, 204));

        day1B.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        day1B.setText("jButton1");
        day1B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                day1BActionPerformed(evt);
            }
        });

        day2B.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        day2B.setText("jButton1");
        day2B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                day2BActionPerformed(evt);
            }
        });

        day3B.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        day3B.setText("jButton1");
        day3B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                day3BActionPerformed(evt);
            }
        });

        day4B.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        day4B.setText("jButton1");
        day4B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                day4BActionPerformed(evt);
            }
        });

        day5B.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        day5B.setText("jButton1");
        day5B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                day5BActionPerformed(evt);
            }
        });

        date1L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        date1L.setText("jLabel1");

        date2L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        date2L.setText("jLabel1");

        date3L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        date3L.setText("jLabel1");

        date4L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        date4L.setText("jLabel1");

        date5L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        date5L.setText("jLabel1");

        javax.swing.GroupLayout weekWrapperLayout = new javax.swing.GroupLayout(weekWrapper);
        weekWrapper.setLayout(weekWrapperLayout);
        weekWrapperLayout.setHorizontalGroup(
                weekWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(weekWrapperLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(weekWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(date1L, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(day1B, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(weekWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(date2L, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(day2B, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(weekWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(date3L, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(day3B, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(weekWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(date4L, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(day4B, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(weekWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(weekWrapperLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(day5B, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(date5L, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        weekWrapperLayout.setVerticalGroup(
                weekWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, weekWrapperLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(weekWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(date1L, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(date2L, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(date3L, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(date4L, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(date5L, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(weekWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(day1B, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(day2B, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(day3B, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(day4B, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(day5B, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23))
        );

        timetableWrapper.setBackground(new java.awt.Color(153, 153, 153));

        hourSlot1.setBackground(new java.awt.Color(204, 204, 204));

        timeLBL1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeLBL1.setText("9:00");

        appointmentSlot1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 10));

        javax.swing.GroupLayout hourSlot1Layout = new javax.swing.GroupLayout(hourSlot1);
        hourSlot1.setLayout(hourSlot1Layout);
        hourSlot1Layout.setHorizontalGroup(
                hourSlot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(hourSlot1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(timeLBL1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(appointmentSlot1, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        hourSlot1Layout.setVerticalGroup(
                hourSlot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(hourSlot1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(timeLBL1)
                                .addContainerGap(33, Short.MAX_VALUE))
                        .addGroup(hourSlot1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(appointmentSlot1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        hourSlot2.setBackground(new java.awt.Color(204, 204, 204));

        timeLBL2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeLBL2.setText("10:00");

        appointmentSlot2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        javax.swing.GroupLayout hourSlot2Layout = new javax.swing.GroupLayout(hourSlot2);
        hourSlot2.setLayout(hourSlot2Layout);
        hourSlot2Layout.setHorizontalGroup(
                hourSlot2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(hourSlot2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(timeLBL2)
                                .addGap(18, 18, 18)
                                .addComponent(appointmentSlot2, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        hourSlot2Layout.setVerticalGroup(
                hourSlot2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(hourSlot2Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(timeLBL2)
                                .addContainerGap(33, Short.MAX_VALUE))
                        .addGroup(hourSlot2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(appointmentSlot2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        hourSlot3.setBackground(new java.awt.Color(204, 204, 204));

        timeLBL3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeLBL3.setText("11:00");

        appointmentSlot3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        javax.swing.GroupLayout hourSlot3Layout = new javax.swing.GroupLayout(hourSlot3);
        hourSlot3.setLayout(hourSlot3Layout);
        hourSlot3Layout.setHorizontalGroup(
                hourSlot3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(hourSlot3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(timeLBL3)
                                .addGap(18, 18, 18)
                                .addComponent(appointmentSlot3, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        hourSlot3Layout.setVerticalGroup(
                hourSlot3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(hourSlot3Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(timeLBL3)
                                .addContainerGap(33, Short.MAX_VALUE))
                        .addGroup(hourSlot3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(appointmentSlot3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        hourSlot4.setBackground(new java.awt.Color(204, 204, 204));

        timeLBL4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeLBL4.setText("12:00");

        appointmentSlot4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        javax.swing.GroupLayout hourSlot4Layout = new javax.swing.GroupLayout(hourSlot4);
        hourSlot4.setLayout(hourSlot4Layout);
        hourSlot4Layout.setHorizontalGroup(
                hourSlot4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(hourSlot4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(timeLBL4)
                                .addGap(18, 18, 18)
                                .addComponent(appointmentSlot4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        hourSlot4Layout.setVerticalGroup(
                hourSlot4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(hourSlot4Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(timeLBL4)
                                .addContainerGap(33, Short.MAX_VALUE))
                        .addGroup(hourSlot4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(appointmentSlot4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        hourSlot5.setBackground(new java.awt.Color(204, 204, 204));

        timeLBL5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeLBL5.setText("13:00");

        appointmentSlot5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        javax.swing.GroupLayout hourSlot5Layout = new javax.swing.GroupLayout(hourSlot5);
        hourSlot5.setLayout(hourSlot5Layout);
        hourSlot5Layout.setHorizontalGroup(
                hourSlot5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(hourSlot5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(timeLBL5)
                                .addGap(18, 18, 18)
                                .addComponent(appointmentSlot5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        hourSlot5Layout.setVerticalGroup(
                hourSlot5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(hourSlot5Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(timeLBL5)
                                .addContainerGap(33, Short.MAX_VALUE))
                        .addGroup(hourSlot5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(appointmentSlot5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        hourSlot6.setBackground(new java.awt.Color(204, 204, 204));

        timeLBL6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeLBL6.setText("14:00");

        appointmentSlot6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        javax.swing.GroupLayout hourSlot6Layout = new javax.swing.GroupLayout(hourSlot6);
        hourSlot6.setLayout(hourSlot6Layout);
        hourSlot6Layout.setHorizontalGroup(
                hourSlot6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(hourSlot6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(timeLBL6)
                                .addGap(18, 18, 18)
                                .addComponent(appointmentSlot6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        hourSlot6Layout.setVerticalGroup(
                hourSlot6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(hourSlot6Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(timeLBL6)
                                .addContainerGap(33, Short.MAX_VALUE))
                        .addGroup(hourSlot6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(appointmentSlot6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        hourSlot7.setBackground(new java.awt.Color(204, 204, 204));

        timeLBL7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeLBL7.setText("15:00");

        appointmentSlot7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        javax.swing.GroupLayout hourSlot7Layout = new javax.swing.GroupLayout(hourSlot7);
        hourSlot7.setLayout(hourSlot7Layout);
        hourSlot7Layout.setHorizontalGroup(
                hourSlot7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(hourSlot7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(timeLBL7)
                                .addGap(18, 18, 18)
                                .addComponent(appointmentSlot7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        hourSlot7Layout.setVerticalGroup(
                hourSlot7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(hourSlot7Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(timeLBL7)
                                .addContainerGap(33, Short.MAX_VALUE))
                        .addGroup(hourSlot7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(appointmentSlot7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        hourSlot8.setBackground(new java.awt.Color(204, 204, 204));

        timeLBL8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeLBL8.setText("16:00");

        appointmentSlot8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        javax.swing.GroupLayout hourSlot8Layout = new javax.swing.GroupLayout(hourSlot8);
        hourSlot8.setLayout(hourSlot8Layout);
        hourSlot8Layout.setHorizontalGroup(
                hourSlot8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(hourSlot8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(timeLBL8)
                                .addGap(18, 18, 18)
                                .addComponent(appointmentSlot8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        hourSlot8Layout.setVerticalGroup(
                hourSlot8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(hourSlot8Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(timeLBL8)
                                .addContainerGap(33, Short.MAX_VALUE))
                        .addGroup(hourSlot8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(appointmentSlot8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout timetableWrapperLayout = new javax.swing.GroupLayout(timetableWrapper);
        timetableWrapper.setLayout(timetableWrapperLayout);
        timetableWrapperLayout.setHorizontalGroup(
                timetableWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(timetableWrapperLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(timetableWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(hourSlot1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(hourSlot2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(hourSlot3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(hourSlot4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(hourSlot5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(hourSlot6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(hourSlot7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(hourSlot8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        timetableWrapperLayout.setVerticalGroup(
                timetableWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(timetableWrapperLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(hourSlot1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hourSlot2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hourSlot3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hourSlot4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hourSlot5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hourSlot6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hourSlot7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hourSlot8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout calendarMasterLayout = new javax.swing.GroupLayout(calendarMaster);
        calendarMaster.setLayout(calendarMasterLayout);
        calendarMasterLayout.setHorizontalGroup(
                calendarMasterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(calendarMasterLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(calendarMasterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(timetableWrapper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(calendarMasterLayout.createSequentialGroup()
                                                .addGroup(calendarMasterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(navWrapper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(weekWrapper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        calendarMasterLayout.setVerticalGroup(
                calendarMasterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(calendarMasterLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(navWrapper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(weekWrapper, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(timetableWrapper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        controlMaster.setBackground(new java.awt.Color(255, 255, 255));

        lookupPatient.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lookupPatient.setText("Lookup Patient");
        lookupPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lookupPatientActionPerformed(evt);
            }
        });

        bookAppointment.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bookAppointment.setText("Book Appointment");
        bookAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookAppointmentActionPerformed(evt);
            }
        });

        searchDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searchDate.setText("dd/mm/yyyy");
        searchDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchDateMouseClicked(evt);
            }
        });

        goToButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        goToButton.setText("Go To");
        goToButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToButtonActionPerformed(evt);
            }
        });

        resetDate.setText("Today");
        resetDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetDateActionPerformed(evt);
            }
        });

        registerPatient.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        registerPatient.setText("Register Patient");
        registerPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerPatientActionPerformed(evt);
            }
        });

        uiType.setText("jLabel1");

        javax.swing.GroupLayout controlMasterLayout = new javax.swing.GroupLayout(controlMaster);
        controlMaster.setLayout(controlMasterLayout);
        controlMasterLayout.setHorizontalGroup(
                controlMasterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(controlMasterLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(controlMasterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(controlMasterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(lookupPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlMasterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(bookAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(registerPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlMasterLayout.createSequentialGroup()
                                                        .addGroup(controlMasterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(controlMasterLayout.createSequentialGroup()
                                                                        .addComponent(searchDate)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                                                .addGroup(controlMasterLayout.createSequentialGroup()
                                                                        .addComponent(resetDate, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(129, 129, 129)))
                                                        .addComponent(goToButton)))
                                        .addComponent(uiType, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(29, Short.MAX_VALUE))
        );
        controlMasterLayout.setVerticalGroup(
                controlMasterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(controlMasterLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(uiType)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(controlMasterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(goToButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(searchDate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(resetDate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90)
                                .addComponent(bookAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lookupPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(registerPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(414, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(calendarMaster, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(controlMaster, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(calendarMaster, javax.swing.GroupLayout.PREFERRED_SIZE, 915, Short.MAX_VALUE)
                                        .addComponent(controlMaster, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>



    // Code below here is functions related to GUI specific elements //

    // Function to advance to the next week
    private void nextWeekActionPerformed(java.awt.event.ActionEvent evt) {
        // Set date to monday, and add 7 Days
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.add(Calendar.DATE, +7);
        // Update the UI elements
        updateNav();
        updateDays();
        updateDayButtons();
        // Default the displayed day to monday
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        updateTimetable();
        // Recolour the buttons
        recolourButtons(calendar.getTime());
    }

    // Same as above, but for previous weeks
    private void prevWeekActionPerformed(java.awt.event.ActionEvent evt) {
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.add(Calendar.DATE, -7);

        updateNav();
        updateDays();
        updateDayButtons();

        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        updateTimetable();
        recolourButtons(calendar.getTime());
    }

    // Function to go to a specific date
    private void goToButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // Convert the string in to a usable date
        String goToString = searchDate.getText();
        DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        try {
            // Instantiate this date and set the calendar
            Date goToDate = fmt.parse(goToString);
            calendar.setTime(goToDate);
            // Update the UI
            updateNav();
            updateDays();
            updateDayButtons();
            // Because of the way the UI updates, calendar needs to be reset before these last 2 updates
            calendar.setTime(goToDate);
            updateTimetable();
            recolourButtons(goToDate);
        } catch (ParseException ex) {
            Logger.getLogger(SecretaryUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Function to reset the calendar to today's date
    private void resetDateActionPerformed(java.awt.event.ActionEvent evt) {
        // Set the calendar
        calendar.setTime(today);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        searchDate.setText("dd/mm/yyyy");
        // Update UI
        updateNav();
        updateDays();
        updateDayButtons();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        updateTimetable();
        calendar.setTime(today);
        recolourButtons(calendar.getTime());
    }

    // Function to lookup a patient
    private void lookupPatientActionPerformed(java.awt.event.ActionEvent evt) {
        // Open the lookup patient GUI, do NOT close the current GUI
        LookUpPatient lookup = new LookUpPatient();
        lookup.setVisible(true);
    }

    // Function to open the book appointment panel
    private void bookAppointmentActionPerformed(java.awt.event.ActionEvent evt) {
        // Open the book appointment GUI, do NOT close the current GUI
        BookAppointment book = new BookAppointment();
        book.setVisible(true);
        // Modify the close operation again, to update on close in real time
        book.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                updateDayButtons();
                calendar.setTime(refdate);
                updateTimetable();
            }
        });
    }

    // Set the text in search to disappear on mouse click
    private void searchDateMouseClicked(java.awt.event.MouseEvent evt) {
        searchDate.setText("");
    }

    // Function to open the Register Patient panel
    private void registerPatientActionPerformed(java.awt.event.ActionEvent evt) {
        RegisterPatient register = new RegisterPatient();
        register.setVisible(true);
    }


    // Code below here is for the functions of each day button //
    private void day1BActionPerformed(java.awt.event.ActionEvent evt) {
        // Set the date and update the UI
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        updateTimetable();
        recolourButtons(calendar.getTime());
    }
    private void day2BActionPerformed(java.awt.event.ActionEvent evt) {
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
        updateTimetable();
        recolourButtons(calendar.getTime());
    }
    private void day3BActionPerformed(java.awt.event.ActionEvent evt) {
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
        updateTimetable();
        recolourButtons(calendar.getTime());
    }
    private void day4BActionPerformed(java.awt.event.ActionEvent evt) {
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
        updateTimetable();
        recolourButtons(calendar.getTime());
    }
    private void day5BActionPerformed(java.awt.event.ActionEvent evt) {
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
        updateTimetable();
        recolourButtons(calendar.getTime());
    }



    // Variables declaration
    private javax.swing.JPanel appointmentSlot1;
    private javax.swing.JPanel appointmentSlot2;
    private javax.swing.JPanel appointmentSlot3;
    private javax.swing.JPanel appointmentSlot4;
    private javax.swing.JPanel appointmentSlot5;
    private javax.swing.JPanel appointmentSlot6;
    private javax.swing.JPanel appointmentSlot7;
    private javax.swing.JPanel appointmentSlot8;
    private javax.swing.JButton bookAppointment;
    private javax.swing.JPanel calendarMaster;
    private javax.swing.JPanel controlMaster;
    private javax.swing.JLabel date1L;
    private javax.swing.JLabel date2L;
    private javax.swing.JLabel date3L;
    private javax.swing.JLabel date4L;
    private javax.swing.JLabel date5L;
    private javax.swing.JButton day1B;
    private javax.swing.JButton day2B;
    private javax.swing.JButton day3B;
    private javax.swing.JButton day4B;
    private javax.swing.JButton day5B;
    private javax.swing.JButton goToButton;
    private javax.swing.JPanel hourSlot1;
    private javax.swing.JPanel hourSlot2;
    private javax.swing.JPanel hourSlot3;
    private javax.swing.JPanel hourSlot4;
    private javax.swing.JPanel hourSlot5;
    private javax.swing.JPanel hourSlot6;
    private javax.swing.JPanel hourSlot7;
    private javax.swing.JPanel hourSlot8;
    private javax.swing.JButton lookupPatient;
    private javax.swing.JPanel navWrapper;
    private javax.swing.JButton nextWeek;
    private javax.swing.JButton prevWeek;
    private javax.swing.JButton registerPatient;
    private javax.swing.JButton resetDate;
    private javax.swing.JTextField searchDate;
    private javax.swing.JLabel timeLBL1;
    private javax.swing.JLabel timeLBL2;
    private javax.swing.JLabel timeLBL3;
    private javax.swing.JLabel timeLBL4;
    private javax.swing.JLabel timeLBL5;
    private javax.swing.JLabel timeLBL6;
    private javax.swing.JLabel timeLBL7;
    private javax.swing.JLabel timeLBL8;
    private javax.swing.JPanel timetableWrapper;
    private javax.swing.JLabel uiType;
    private javax.swing.JLabel weekDates;
    private javax.swing.JPanel weekWrapper;
    private javax.swing.JLabel yearDate;
    private Calendar calendar;
    private String weekStart;
    private String weekEnd;
    private String displayMonth;
    private String displayYear;
    private String dateActual;
    private final Date today;
    private Date refdate;

}
