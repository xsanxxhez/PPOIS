package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class CarsTest {

    @Test
    public void testGetDetails() {
        Cars car = new Cars("Toyota", "Camry", 2020, 24000, "Petrol");
        String expectedDetails = "Toyota Camry (2020) - $24000";
        assertEquals(expectedDetails, car.getDetails());
    }

    @Test
    public void testSell() {
        Cars car = new Cars("Toyota", "Camry", 2020, 24000, "Petrol");

        // Переопределяем System.out для перехвата вывода
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        car.sell(); // Вызываем метод sell

        // Проверяем, что вывод соответствует ожидаемому
        String expectedOutput = "Selling car: Toyota Camry (2020) - $24000";
        assertEquals(expectedOutput, outContent.toString().trim());

        // Восстанавливаем оригинальный System.out
        System.setOut(originalOut);
    }

    @Test
    public void testFuelTypeGettersAndSetters() {
        Cars car = new Cars("Toyota", "Camry", 2020, 24000, "Petrol");

        // Проверяем начальное значение fuelType
        assertEquals("Petrol", car.getFuelType());

        // Устанавливаем новое значение и проверяем
        car.setFuelType("Diesel");
        assertEquals("Diesel", car.getFuelType());
    }

    @Test
    public void testEqualsAndHashCode() {
        Cars car1 = new Cars("Toyota", "Camry", 2020, 24000, "Petrol");
        Cars car2 = new Cars("Toyota", "Camry", 2020, 24000, "Petrol");
        Cars car3 = new Cars("Ford", "Focus", 2019, 22000, "Petrol");

        // Тестируем equals
        assertEquals(car1, car2);
        assertNotEquals(car1, car3);

        // Тестируем hashCode
        assertEquals(car1.hashCode(), car2.hashCode());
        assertNotEquals(car1.hashCode(), car3.hashCode());
    }
    class Sedan extends Cars {
        public Sedan(String brand, String model, int year, double price) {
            super(brand, model, year, price, "Petrol");
        }
    }

}
