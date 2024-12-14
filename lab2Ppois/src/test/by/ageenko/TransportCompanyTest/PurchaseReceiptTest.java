package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class PurchaseReceiptTest {
    private Client client;
    private Vehicle vehicle;
    private PurchaseReceipt receipt;

    @BeforeEach
    public void setUp() {
        client = new Client("John Doe", "johndoe@example.com");
        vehicle = new Cars("Toyota", "Camry", 2020, 24000, "Petrol");
        receipt = new PurchaseReceipt(vehicle, client, 24000);
    }

    @Test
    public void testPrintReceipt() {
        // Перенаправляем System.out для перехвата вывода
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        receipt.printReceipt(); // Печатаем квитанцию

        // Проверяем, что вывод соответствует ожидаемому
        String expectedOutput = "Receipt:\n" +
                "Client: John Doe\n" +
                "Vehicle: Toyota Camry (2020) - $24000\n" +
                "Amount: $24000.0";
        assertEquals(expectedOutput.trim(), outContent.toString().trim());

        // Восстанавливаем оригинальный System.out
        System.setOut(originalOut);
    }

    @Test
    public void testGetVehicle() {
        assertEquals(vehicle, receipt.getVehicle());
    }

    @Test
    public void testSetVehicle() {
        Vehicle newVehicle = new Cars("Honda", "Accord", 2021, 26000, "Diesel");
        receipt.setVehicle(newVehicle);
        assertEquals(newVehicle, receipt.getVehicle());
    }

    @Test
    public void testGetClient() {
        assertEquals(client, receipt.getClient());
    }

    @Test
    public void testSetClient() {
        Client newClient = new Client("Jane Smith", "janesmith@example.com");
        receipt.setClient(newClient);
        assertEquals(newClient, receipt.getClient());
    }

    @Test
    public void testGetAmount() {
        assertEquals(24000, receipt.getAmount());
    }

    @Test
    public void testSetAmount() {
        receipt.setAmount(26000);
        assertEquals(26000, receipt.getAmount());
    }
}