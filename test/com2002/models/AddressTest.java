package com2002.models;

import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class AddressTest {

    Address address;

    @BeforeClass
    public static void setup() {
        new Address(40, "Highfield", "Launceston", "Cornwall", "pl157dy");
    }

    @Before
    public void before() {
        address = new Address(40, "pl157dy");
    }

    @Test
    public void testCreateAddress() {
        assertTrue(address.getHouseNo() == 40);
    }

    @Test
    public void testLoadAddress() {
        Address tester = new Address(address.getHouseNo(), address.getPostcode());

        assertEquals(address, tester);
    }
}
