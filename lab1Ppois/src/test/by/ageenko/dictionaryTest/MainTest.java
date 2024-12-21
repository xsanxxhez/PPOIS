package by.ageenko.dictionaryTest;

import by.ageenko.dictionary.Main;
import org.junit.jupiter.api.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    public void testAddAndGetTranslation() {
        String input = "add\nhello\nпривет\nget\nhello\nexit\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Main.main(new String[]{});

        String output = outputStream.toString();
        assertTrue(output.contains("Слово добавлено успешно."));
        assertTrue(output.contains("Перевод: привет"));
    }

    @Test
    public void testRemoveWord() {
        String input = "add\nhello\nпривет\nremove\nhello\nget\nhello\nsize\nexit\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Main.main(new String[]{});

        String output = outputStream.toString();
        assertTrue(output.contains("Слово удалено успешно, если оно существовало."));
        assertTrue(output.contains("Слово не найдено."));
        assertTrue(output.contains("Размер словаря: 0"));
    }

    @Test
    public void testUnknownCommand() {
        String input = "unknown\nexit\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Main.main(new String[]{});

        String output = outputStream.toString();
        assertTrue(output.contains("Неизвестная команда. Пожалуйста, попробуйте снова."));
    }

    @Test
    public void testSizeCommand() {
        String input = "add\nhello\nпривет\nsize\nexit\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Main.main(new String[]{});

        String output = outputStream.toString();
        assertTrue(output.contains("Размер словаря: 1"));
    }

    @Test
    public void testExitCommand() {
        String input = "exit\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Main.main(new String[]{});

        String output = outputStream.toString();
        assertTrue(output.contains("Выход из программы."));
    }

    @Test
    public void testGetNonExistentWord() {
        String input = "get\nnonexistent\nexit\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Main.main(new String[]{});

        String output = outputStream.toString();
        assertTrue(output.contains("Слово не найдено."));
    }
}