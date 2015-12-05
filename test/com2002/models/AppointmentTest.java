package com2002.models;

import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.assertTrue;

public class AppointmentTest {

    @Test
    public void testCreateAppointment() {

        // MyClass is tester
        Staff staff = new Staff("hygienist");
        Patient patient = new Patient();
        patient.create("Ms", "Beth", "Lum", new Date((new java.util.Date()).getTime()), "070");

        Appointment tester1 = new Appointment(patient.getPatientID(), new java.util.Date(), new java.util.Date(), staff.getId());

        // assert statements
        assertTrue(tester1.getID() > 0);
  }

}
