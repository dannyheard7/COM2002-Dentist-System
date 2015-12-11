package com2002.models;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class AppointmentTest {

    Staff staff;
    Patient patient;
    Appointment tester;

    @BeforeClass
    public static void setup() {
        new Staff("hygienist");
        new Patient("Ms", "Beth", "Lum", new Date(), "070");
    }

    @Before
    public void before() {
        staff = new Staff(1);
        patient = new Patient(1);
        tester = new Appointment(patient.getPatientID(), new Date(), new Date(), staff.getId());
    }

    @After
    public void cleanup() {
        // Remove from database
        tester.cancel();
    }

    @Test
    public void testCreateAppointment() {
        assertTrue(tester.getID() > 0);
    }

    @Test
    public void testCancelAppointment() {
        assertTrue(tester.cancel());
        assertTrue(tester.getID() == 0);
    }
    
    @Test
    public void testGetAppointmentsOnDate() {
        ArrayList<Appointment> appointments = Appointment.getAppointmentsOnDate(new Date());

        assertThat(appointments, hasItem(tester));
    }

}
