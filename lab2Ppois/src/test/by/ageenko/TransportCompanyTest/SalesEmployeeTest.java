package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalesEmployeeTest {

    @Test
    public void testSalesEmployeeCreation() {
        SalesEmployee salesEmployee = new SalesEmployee("Alice");
        assertEquals("Alice", salesEmployee.getName());
        assertEquals("Sales", salesEmployee.getPosition());
    }
}