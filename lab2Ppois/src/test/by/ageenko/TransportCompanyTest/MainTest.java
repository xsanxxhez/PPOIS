package org.example;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    @Test
    public void testMain() {
        // Save the original System.out and System.in
        PrintStream originalOut = System.out;
        InputStream originalIn = System.in;

        // Create a ByteArrayOutputStream to capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Simulate user input: selecting option 1 (show vehicles) and then 0 (exit)
        String simulatedInput = "1\n0\n"; // User chooses to see vehicles and exits
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Call the main method
        Main.main(new String[]{});

        // Check the output
        String output = outputStream.toString();
        assertTrue(output.contains("Выберите действие:"));
        assertTrue(output.contains("Информация о машинах:"));
        assertTrue(output.contains("Toyota Camry")); // Make sure this vehicle is listed

        // Restore original System.out and System.in
        System.setOut(originalOut);
        System.setIn(originalIn);
    }
}