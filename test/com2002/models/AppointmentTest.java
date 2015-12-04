package com2002.models;

import java.util.Date;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AppointmentTest {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void testCreateTwoAppointments() {

    // MyClass is tested
    Appointment tester1 = new Appointment(1, new java.util.Date(), new java.util.Date(), 1);
    Appointment tester2 = new Appointment(2, new java.util.Date(), new java.util.Date(), 2);

    // assert statements
    assertThat(tester1.getID(), is(not(tester2.getID())));
  }

}
