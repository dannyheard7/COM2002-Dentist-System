package com2002.models;

import java.util.Date;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.ArrayList;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;

public class PlanTest {
    Plan plan;

    @BeforeClass
    public static void setup() {
        new Plan("NHS Free", new BigDecimal(0.0), 3, 2, 1);
    }

    @Before
    public void before() {
        plan = new Plan("NHS Free");
    }
    
    @Test
    public void testGetPlans() {
        ArrayList<Plan> plans = Plan.getAllPlans();

        assertThat(plans, hasItem(plan));
    }
}
