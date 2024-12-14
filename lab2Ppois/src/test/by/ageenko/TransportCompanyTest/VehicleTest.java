package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VehicleTest {

    @Test
    public void testGetDetails() {
        Vehicle vehicle = new Cars("Toyota", "Camry", 2020, 24000, "Petrol");
        String expectedDetails = "Toyota Camry (2020) - $24000";
        assertEquals(expectedDetails, vehicle.getDetails());
    }

    @Test
    public void testEqualsAndHashCode() {
        Vehicle vehicle1 = new Cars("Toyota", "Camry", 2020, 24000, "Petrol");
        Vehicle vehicle2 = new Cars("Toyota", "Camry", 2020, 24000, "Petrol");
        Vehicle vehicle3 = new Cars("Ford", "Focus", 2019, 22000, "Petrol");

        // Проверка равенства
        assertEquals(vehicle1, vehicle2);
        assertNotEquals(vehicle1, vehicle3);

        // Проверка хэш-кодов
        assertEquals(vehicle1.hashCode(), vehicle2.hashCode());
        assertNotEquals(vehicle1.hashCode(), vehicle3.hashCode());
    }

    @Test
    public void testSettersAndGetters() {
        Vehicle vehicle = new Cars("Toyota", "Camry", 2020, 24000, "Petrol");

        // Проверка начальных значений
        assertEquals("Toyota", vehicle.getBrand());
        assertEquals("Camry", vehicle.getModel());
        assertEquals(2020, vehicle.getYear());
        assertEquals(24000, vehicle.getPrice());

        // Установка новых значений
        vehicle.setBrand("Honda");
        vehicle.setModel("Accord");
        vehicle.setYear(2021);
        vehicle.setPrice(26000);

        // Проверка обновленных значений
        assertEquals("Honda", vehicle.getBrand());
        assertEquals("Accord", vehicle.getModel());
        assertEquals(2021, vehicle.getYear());
        assertEquals(26000, vehicle.getPrice());
    }
    class Motorcycle extends Vehicle {
        public Motorcycle(String brand, String model, int year, double price) {
            super(brand, model, year, price);
        }

        @Override
        public void sell() {
            System.out.println("Selling motorcycle: " + getDetails());
        }
    }
}