package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EnglishRussianDictionaryTest {

    @Test
    public void testAddAndSize() {
        EnglishRussianDictionary dictionary = new EnglishRussianDictionary();
        dictionary.add("hello", "привет");
        dictionary.add("world", "мир");
        assertEquals(2, dictionary.size(), "Размер словаря должен быть 2");
    }

    @Test
    public void testGetTranslation() {
        EnglishRussianDictionary dictionary = new EnglishRussianDictionary();
        dictionary.add("hello", "привет");
        assertEquals("привет", dictionary.getTranslation("hello"), "Перевод 'hello' должен быть 'привет'");
        assertNull(dictionary.getTranslation("nonexistent"), "Перевод для несуществующего слова должен быть null");
    }

    @Test
    public void testSetTranslation() {
        EnglishRussianDictionary dictionary = new EnglishRussianDictionary();
        dictionary.add("hello", "привет");
        dictionary.setTranslation("hello", "здорово");
        assertEquals("здорово", dictionary.getTranslation("hello"));
    }

    @Test
    public void testRemove() {
        EnglishRussianDictionary dictionary = new EnglishRussianDictionary();
        dictionary.add("hello", "привет");
        dictionary.remove("hello");
        assertNull(dictionary.getTranslation("hello"), "Перевод 'hello' должен быть null после удаления");
        assertEquals(0, dictionary.size(), "Размер словаря должен быть 0 после удаления");
    }

    @Test
    public void testUpdateTranslation() {
        EnglishRussianDictionary dictionary = new EnglishRussianDictionary();
        dictionary.add("hello", "привет");
        dictionary.setTranslation("hello", "здорово");
        assertEquals("здорово", dictionary.getTranslation("hello"), "Перевод 'hello' должен быть 'здорово'");
    }

    @Test
    public void testRemoveNonExistentWord() {
        EnglishRussianDictionary dictionary = new EnglishRussianDictionary();
        dictionary.add("hello", "привет");
        dictionary.remove("world"); // Удаляем слово, которого нет
        assertEquals(1, dictionary.size(), "Размер словаря должен оставаться 1 после удаления несуществующего слова");
    }
}
