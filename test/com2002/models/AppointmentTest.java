package com2002.models;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.*;

public class AppointmentTest {

    Staff staff;
    Patient patient;
    Appointment appointment;
    Date date;

    @BeforeClass
    public static void setup() {
        new Staff("hygienist");
        new Patient("Ms", "Beth", "Lum", new Date(), "070");
    }

    @Before
    public void before() {
        staff = new Staff(1);
        patient = new Patient(1);
        date = new Date();
        appointment = new Appointment(patient,date, date, staff);
    }

    @After
    public void cleanup() {
        // Remove from database
        appointment.cancel();
    }

    @Test
    public void testCreateAppointment() {
        assertTrue(appointment.getID() > 0);
    }
    
    @Test
    public void testCreateTwoIdenticalAppointments() {
        Appointment ident = new Appointment(patient, date, date, staff);
        
        assertTrue(ident.getID() == 0);
    }

    @Test
    public void testCancelAppointment() {
        assertTrue(appointment.cancel());
        assertTrue(appointment.getID() == 0);
    }
    
    @Test
    public void testGetAppointmentsOnDate() {
        ArrayList<Appointment> appointments = Appointment.getAppointmentsOnDate(new Date());

        assertThat(appointments, hasItem(appointment));
    }

    @Test
   public void testAddTreatment() {
        appointment.addTreatment("Tooth Extraction", new BigDecimal("150.10"));
        Treatment t = new Treatment(appointment, "Tooth Extraction");
        
        ArrayList<Treatment> treatments = appointment.getTreatments();
        assertThat(treatments, hasItem(t));
    }
    
    @Test
    public void testLoadAppointment() {
        Appointment tester = new Appointment(appointment.getID());
        
        assertEquals(appointment, tester);
    }
}
