package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class ShowroomTest {
    private Garage garage;
    private SalesEmployee employee;
    private Showroom showroom;

    @BeforeEach
    public void setUp() {
        garage = new Garage("Downtown");
        employee = new SalesEmployee("Alice");
        showroom = new Showroom(garage, employee);
    }

    @Test
    public void testShowroomInitialization() {
        assertNotNull(showroom.getGarage());
        assertNotNull(showroom.getEmployee());
        assertEquals("Downtown", showroom.getGarage().getLocation());
        assertEquals("Alice", showroom.getEmployee().getName());
    }

    @Test
    public void testShowVehicles() {
        // Перенаправляем System.out для перехвата вывода
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        showroom.showVehicles(); // Вызываем метод

        // Проверяем, что вывод соответствует ожидаемому
        String expectedOutput = "Showroom managed by Alice";
        assertEquals(expectedOutput, outContent.toString().trim());

        // Восстанавливаем оригинальный System.out
        System.setOut(originalOut);
    }

    @Test
    public void testSetGarage() {
        Garage newGarage = new Garage("Uptown");
        showroom.setGarage(newGarage);
        assertEquals(newGarage, showroom.getGarage());
        assertEquals("Uptown", showroom.getGarage().getLocation());
    }

    @Test
    public void testSetEmployee() {
        SalesEmployee newEmployee = new SalesEmployee("Bob");
        showroom.setEmployee(newEmployee);
        assertEquals(newEmployee, showroom.getEmployee());
        assertEquals("Bob", showroom.getEmployee().getName());
    }
}