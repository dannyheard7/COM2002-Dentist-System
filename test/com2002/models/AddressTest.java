package com2002.models;

import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;

import java.util.Date;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class AddressTest {

    Address address;

    @BeforeClass
    public static void setup() {
        new Address(40, "Highfield", "Trezaise", "Cornwall", "pl157dy");
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

    @Test
    public void testAddPatientAddress() {
        Patient patient = new Patient("Ms", "Beth", "Lum", new Date(), "070");
        patient.addAddress(address);

        assertEquals(patient.getAddress(), address);
    }
}
