package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {
    private Client client;
    private Vehicle vehicle;
    private Order order;

    @BeforeEach
    public void setUp() {
        client = new Client("John Doe", "johndoe@example.com");
        vehicle = new Cars("Toyota", "Camry", 2020, 24000, "Petrol");
        order = new Order(client, vehicle);
    }

    @Test
    public void testProcessOrder() {
        // Перенаправляем System.out для перехвата вывода
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        order.processOrder(); // Обрабатываем заказ

        // Проверяем, что вывод соответствует ожидаемому
        String expectedOutput = "Processing order for John Doe for vehicle: Toyota Camry (2020) - $24000";
        assertEquals(expectedOutput, outContent.toString().trim());

        // Восстанавливаем оригинальный System.out
        System.setOut(originalOut);
    }

    @Test
    public void testGetClient() {
        assertEquals(client, order.getClient());
    }

    @Test
    public void testSetClient() {
        Client newClient = new Client("Jane Smith", "janesmith@example.com");
        order.setClient(newClient);
        assertEquals(newClient, order.getClient());
    }

    @Test
    public void testGetVehicle() {
        assertEquals(vehicle, order.getVehicle());
    }

    @Test
    public void testSetVehicle() {
        Vehicle newVehicle = new Cars("Honda", "Accord", 2021, 26000, "Diesel");
        order.setVehicle(newVehicle);
        assertEquals(newVehicle, order.getVehicle());
    }
}