package com2002.models;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class StaffTest {

    @Test
    public void testCreateStaffMember() {

        // MyClass is tested
        Staff staff = new Staff("hygienist");

        // assert statements
        assertTrue(staff.getId() > 0);
    }

}