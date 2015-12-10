package com2002.models;

import org.junit.Test;
import java.sql.Date;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class AppointmentTest {

    @Test
    public void testCreateAppointment() {

        Staff staff = new Staff("hygienist");
        Patient patient = new Patient("Ms", "Beth", "Lum", new Date((new java.util.Date()).getTime()), "070");

        Appointment tester1 = new Appointment(patient.getPatientID(), new java.util.Date(), new java.util.Date(), staff.getId());

        // assert statements
        assertTrue(tester1.getID() > 0);
  }

    @Test
    public void testCancelAppointment() {
        Staff staff = new Staff(1);
        Patient patient = new Patient(1);

        Appointment tester1 = new Appointment(patient.getPatientID(), new java.util.Date(), new java.util.Date(), staff.getId());

        assertTrue(tester1.cancel());
        assertTrue(tester1.getID() == 0);
    }
    
    @Test
    public void testGetAppointmentsOnDate() {
        Staff staff = new Staff(1);
        Patient patient = new Patient(1);
        Appointment tester1 = new Appointment(1);
        
        ArrayList<Appointment> appointments = Appointment.getAppointmentsOnDate(new java.util.Date());
        System.out.println(appointments.get(0).getStaff().getId());

        assertEquals(tester1, appointments.get(0));
    }

}
