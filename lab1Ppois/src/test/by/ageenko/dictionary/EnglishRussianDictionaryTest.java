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
        dictionary.remove("world");
        assertEquals(1, dictionary.size(), "Размер словаря должен оставаться 1 после удаления несуществующего слова");
    }

    @Test
    public void testSetTranslationNonExistentWord() {
        EnglishRussianDictionary dictionary = new EnglishRussianDictionary();
        dictionary.add("hello", "привет");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            dictionary.setTranslation("world", "мир");
        });
        assertEquals("Word not found in dictionary.", exception.getMessage());
    }

    @Test
    public void testAddExistingWordUpdatesTranslation() {
        EnglishRussianDictionary dictionary = new EnglishRussianDictionary();
        dictionary.add("hello", "привет");
        dictionary.add("hello", "здорово");
        assertEquals("здорово", dictionary.getTranslation("hello"), "Перевод 'hello' должен быть 'здорово'");
    }

    @Test
    public void testGetTranslationMultipleWords() {
        EnglishRussianDictionary dictionary = new EnglishRussianDictionary();
        dictionary.add("hello", "привет");
        dictionary.add("world", "мир");
        assertEquals("привет", dictionary.getTranslation("hello"), "Перевод 'hello' должен быть 'привет'");
        assertEquals("мир", dictionary.getTranslation("world"), "Перевод 'world' должен быть 'мир'");
        assertNull(dictionary.getTranslation("nonexistent"), "Перевод для несуществующего слова должен быть null");
    }

    @Test
    public void testAddEmptyWord() {
        EnglishRussianDictionary dictionary = new EnglishRussianDictionary();
        dictionary.add("", "пусто");
        assertEquals("пусто", dictionary.getTranslation(""), "Перевод пустого слова должен быть 'пусто'");
        assertEquals(1, dictionary.size(), "Размер словаря должен быть 1 после добавления пустого слова");
    }

    @Test
    public void testRemoveEmptyWord() {
        EnglishRussianDictionary dictionary = new EnglishRussianDictionary();
        dictionary.add("", "пусто");
        dictionary.remove("");
        assertNull(dictionary.getTranslation(""), "Перевод пустого слова должен быть null после удаления");
        assertEquals(0, dictionary.size(), "Размер словаря должен быть 0 после удаления пустого слова");
    }

    @Test
    public void testSizeAfterVariousOperations() {
        EnglishRussianDictionary dictionary = new EnglishRussianDictionary();
        assertEquals(0, dictionary.size(), "Размер словаря должен быть 0 при инициализации");

        dictionary.add("hello", "привет");
        assertEquals(1, dictionary.size(), "Размер словаря должен быть 1 после добавления слова");

        dictionary.add("world", "мир");
        assertEquals(2, dictionary.size(), "Размер словаря должен быть 2 после добавления второго слова");

        dictionary.remove("hello");
        assertEquals(1, dictionary.size(), "Размер словаря должен быть 1 после удаления одного слова");
    }

    @Test
    public void testGetTranslationWithSpaces() {
        EnglishRussianDictionary dictionary = new EnglishRussianDictionary();
        dictionary.add("hello world", "привет мир");
        assertEquals("привет мир", dictionary.getTranslation("hello world"), "Перевод 'hello world' должен быть 'привет мир'");
        assertNull(dictionary.getTranslation("nonexistent"), "Перевод для несуществующего слова должен быть null");
    }

    @Test
    public void testSetAndGetLeftNode() {
        DictionaryNode parentNode = new DictionaryNode("hello", "привет");
        DictionaryNode leftNode = new DictionaryNode("apple", "яблоко");
        parentNode.setLeft(leftNode);

        assertEquals(leftNode, parentNode.getLeft(), "Левый узел должен быть установлен правильно");
    }

    @Test
    public void testSetAndGetRightNode() {
        DictionaryNode parentNode = new DictionaryNode("hello", "привет");
        DictionaryNode rightNode = new DictionaryNode("world", "мир");
        parentNode.setRight(rightNode);

        assertEquals(rightNode, parentNode.getRight(), "Правый узел должен быть установлен правильно");
    }

    @Test
    public void testSetRussianWord() {
        DictionaryNode node = new DictionaryNode("hello", "привет");
        node.setRussianWord("здорово");

        assertEquals("здорово", node.getRussianWord(), "Русский перевод должен быть обновлен на 'здорово'");
    }

    @Test
    public void testSetTranslationNullValue() {
        EnglishRussianDictionary dictionary = new EnglishRussianDictionary();
        dictionary.add("hello", "привет");
        dictionary.setTranslation("hello", null);
        assertNull(dictionary.getTranslation("hello"), "Перевод 'hello' должен быть null после обновления на null");
    }
}