package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EnglishRussianDictionary dictionary = new EnglishRussianDictionary();
        String command;

        System.out.println("Добро пожаловать в Англо-Русский Словарь!");

        while (true) {
            System.out.println("\nВведите команду (add, get, remove, size, exit):");
            command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "add":
                    System.out.print("Введите английское слово: ");
                    String englishWord = scanner.nextLine();
                    System.out.print("Введите русский перевод: ");
                    String russianTranslation = scanner.nextLine();
                    dictionary.add(englishWord, russianTranslation);
                    System.out.println("Слово добавлено успешно.");
                    break;

                case "get":
                    System.out.print("Введите английское слово для перевода: ");
                    englishWord = scanner.nextLine();
                    String translation = dictionary.getTranslation(englishWord);
                    if (translation != null) {
                        System.out.println("Перевод: " + translation);
                    } else {
                        System.out.println("Слово не найдено.");
                    }
                    break;

                case "remove":
                    System.out.print("Введите английское слово для удаления: ");
                    englishWord = scanner.nextLine();
                    dictionary.remove(englishWord);
                    System.out.println("Слово удалено успешно, если оно существовало.");
                    break;

                case "size":
                    System.out.println("Размер словаря: " + dictionary.size());
                    break;

                case "exit":
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Неизвестная команда. Пожалуйста, попробуйте снова.");
                    break;
            }
        }
    }
}
