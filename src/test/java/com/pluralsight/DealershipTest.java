package com.pluralsight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DealershipTest {
    private Dealership dealership;

    @BeforeEach
    public void setUp() {
        dealership = new Dealership("Test Dealership", "123 Main St", "555-1234");
    }

    @Test
    public void testAddVehicle() {
        Vehicle vehicle = new Vehicle(12345, 2021, "Toyota", "Camry", "Sedan", "Blue", 5000, 25000.00);
        dealership.addVehicle(vehicle);

        // Check if the vehicle has been added to the inventory
        assertEquals(1, dealership.getAllVehicles().size(), "The vehicle should be added to the inventory.");
        assertTrue(dealership.getAllVehicles().contains(vehicle), "The inventory should contain the added vehicle.");
    }
}
