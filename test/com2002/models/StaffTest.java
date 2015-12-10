package com2002.models;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class StaffTest {

    Staff staff;

    @BeforeClass
    public static void setup() {
        new Staff("hygienist");
    }

    @Before
    public void before() {
        staff = new Staff(1);
    }

    @Test
    public void testCreateStaffMember() {
        // assert statements
        assertTrue(staff.getId() > 0);
    }

    @Test
    public void testGetHygienist() {
        ArrayList<Staff> hygienists = Staff.getStaffWithPosition("hygienist");
        Staff hygienist = hygienists.get(0);

        assertTrue(hygienist.getId() > 0);
        assertTrue(hygienist.getPosition().equals("hygienist"));
    }
}