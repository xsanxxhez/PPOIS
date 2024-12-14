package org.example;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransportTest {

    @Test
    void testAddVehicle() {
        Garage garage = new Garage("Downtown");
        Vehicle motorcycle = new Motorcycle("Harley-Davidson", "Sportster", 2021, 15000);
        garage.addVehicle(motorcycle);
        assertTrue(garage.contains(motorcycle)); // Используйте метод contains
    }

    @Test
    void testRemoveVehicle() {
        Garage garage = new Garage("Downtown");
        Vehicle car = new Sedan("Toyota", "Camry", 2020, 24000);
        garage.addVehicle(car);
        assertTrue(garage.contains(car)); // Проверка на наличие перед удалением
        garage.removeVehicle(car);
        assertFalse(garage.contains(car)); // Проверка на отсутствие после удаления
    }
    @Test
    void testGetVehicles() {
        Garage garage = new Garage("Downtown");
        Vehicle car1 = new Sedan("Toyota", "Camry", 2020, 24000);
        Vehicle car2 = new SUV("Ford", "Explorer", 2021, 32000);
        garage.addVehicle(car1);
        garage.addVehicle(car2);
        assertEquals(2, garage.size());
    }

    @Test
    void testClientInfo() {
        Client client = new Client("John Doe", "johndoe@example.com");
        assertEquals("John Doe", client.getName());
        assertEquals("johndoe@example.com", client.getContactInfo());
    }


    @Test
    void testVehicleDetails() {
        Vehicle car1 = new Sedan("Toyota", "Camry", 2020, 24000);
        assertEquals("Toyota Camry (2020) - $24000", car1.getDetails());
    }

    @Test
    void testEmployeeInfo() {
        Employee employee = new SalesEmployee("Alice");
        assertEquals("Alice", employee.getName());
        assertEquals("Sales", employee.getPosition());
    }

    @Test
    void testShowroom() {
        Garage garage = new Garage("Downtown");
        Showroom showroom = new Showroom(garage, new SalesEmployee("Alice"));
        assertEquals("Downtown", showroom.getGarage().getLocation());
    }

    @Test
    void testAddMultipleVehicles() {
        Garage garage = new Garage("Downtown");
        Vehicle car1 = new Sedan("Toyota", "Camry", 2020, 24000);
        Vehicle car2 = new SUV("Ford", "Explorer", 2021, 32000);
        Vehicle car3 = new Sedan("Honda", "Accord", 2019, 22000);
        garage.addVehicle(car1);
        garage.addVehicle(car2);
        garage.addVehicle(car3);
        assertEquals(3, garage.size());
    }

    @Test
    void testRemoveNonExistentVehicle() {
        Garage garage = new Garage("Downtown");
        Vehicle nonExistentCar = new Sedan("NonExistent", "Car", 2022, 30000);
        garage.removeVehicle(nonExistentCar); // Should not throw an error
        assertEquals(0, garage.size());
    }



    @Test
    void testVehicleNotInGarage() {
        Garage garage = new Garage("Downtown");
        Vehicle motorcycle = new Motorcycle("Harley-Davidson", "Street", 2022, 15000);
        assertFalse(garage.contains(motorcycle));
        garage.addVehicle(motorcycle);
        assertTrue(garage.contains(motorcycle));
    }

    @Test
    void testClientCreation() {
        Client newClient = new Client("Jane Smith", "janesmith@example.com");
        assertEquals("Jane Smith", newClient.getName());
        assertEquals("janesmith@example.com", newClient.getContactInfo());
    }

    @Test
    void testEmployeeCreation() {
        Employee employee = new SalesEmployee("Bob");
        assertEquals("Bob", employee.getName());
        assertEquals("Sales", employee.getPosition());
    }

    @Test
    void testGetVehicleByModel() {
        Garage garage = new Garage("Downtown");
        Vehicle car1 = new Sedan("Toyota", "Camry", 2020, 24000);
        garage.addVehicle(car1);
        Vehicle foundVehicle = garage.getVehicleByModel("Camry");
        assertEquals(car1, foundVehicle);
    }

    @Test
    void testGetNonExistentVehicleByModel() {
        Garage garage = new Garage("Downtown");
        Vehicle foundVehicle = garage.getVehicleByModel("NonExistent Model");
        assertNull(foundVehicle);
    }
}