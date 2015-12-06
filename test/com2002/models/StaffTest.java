package com2002.models;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class StaffTest {

    @Test
    public void testCreateStaffMember() {

        // MyClass is tested
        Staff staff = new Staff("hygienist");

        // assert statements
        assertTrue(staff.getId() > 0);
    }

    @Test
    public void testGetHygienist() {
        Staff staff = new Staff("hygienist");

        ArrayList<Staff> hygienists = Staff.getStaffWithPosition("hygienist");
        Staff hygienist = hygienists.get(0);

        assertTrue(hygienist.getId() > 0);
        assertTrue(hygienist.getPosition().equals("hygienist"));
    }
}