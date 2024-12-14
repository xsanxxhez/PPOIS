package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {
    private Employee employee;

    @BeforeEach
    public void setUp() {
        employee = new Employee("Alice", "Salesperson");
    }

    @Test
    public void testEmployeeInitialization() {
        assertEquals("Alice", employee.getName());
        assertEquals("Salesperson", employee.getPosition());
    }

    @Test
    public void testSetName() {
        employee.setName("Bob");
        assertEquals("Bob", employee.getName());
    }

    @Test
    public void testSetPosition() {
        employee.setPosition("Manager");
        assertEquals("Manager", employee.getPosition());
    }
}