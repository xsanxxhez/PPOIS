package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GarageTest {
    private Garage garage;
    private Vehicle car1;
    private Vehicle car2;

    @BeforeEach
    public void setUp() {
        garage = new Garage("Downtown");
        car1 = new Cars("Toyota", "Camry", 2020, 24000, "Petrol");
        car2 = new Cars("Honda", "Accord", 2021, 26000, "Petrol");
    }

    @Test
    public void testAddVehicle() {
        garage.addVehicle(car1);
        assertEquals(1, garage.size());
        assertTrue(garage.contains(car1));
    }

    @Test
    public void testRemoveVehicle() {
        garage.addVehicle(car1);
        assertTrue(garage.removeVehicle(car1));
        assertFalse(garage.contains(car1));
        assertEquals(0, garage.size());
    }

    @Test
    public void testRemoveVehicleNotFound() {
        garage.addVehicle(car1);
        assertFalse(garage.removeVehicle(car2)); // car2 не добавлялся
        assertEquals(1, garage.size());
    }

    @Test
    public void testGarageFull() {
        for (int i = 0; i < 10; i++) {
            garage.addVehicle(new Cars("Car" + i, "Model" + i, 2020 + i, 20000 + i * 1000, "Petrol"));
        }
        assertEquals(10, garage.size());

        // Попробуем добавить 11-й автомобиль
        garage.addVehicle(new Cars("Extra", "Car", 2021, 30000, "Diesel"));
        assertEquals(10, garage.size()); // Размер должен оставаться 10
    }

    @Test
    public void testContains() {
        garage.addVehicle(car1);
        assertTrue(garage.contains(car1));
        assertFalse(garage.contains(car2)); // car2 не добавлялся
    }

    @Test
    public void testGetVehicleByModel() {
        garage.addVehicle(car1);
        garage.addVehicle(car2);

        assertEquals(car1, garage.getVehicleByModel("Camry"));
        assertEquals(car2, garage.getVehicleByModel("Accord"));
        assertNull(garage.getVehicleByModel("NonExistentModel")); // Не существующая модель
    }

    @Test
    public void testGetLocation() {
        assertEquals("Downtown", garage.getLocation());
    }

    @Test
    public void testSetLocation() {
        garage.setLocation("Uptown");
        assertEquals("Uptown", garage.getLocation());
    }
}