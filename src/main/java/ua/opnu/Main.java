package ua.opnu;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("===== Завдання 1 — MyOptional =====\n");
        System.out.println("Тестуємо власну реалізацію Optional:");
        System.out.println("- створення порожнього optional");
        System.out.println("- створення optional з даними");
        System.out.println("- поведінка get(), isPresent(), orElse()");
        System.out.println("- заборона null у конструкторі\n");

        // 1. Порожній MyOptional
        MyOptional<String> middleName = new MyOptional<>();
        System.out.println("Порожній MyOptional:");
        System.out.println(middleName);
        System.out.println("isPresent: " + middleName.isPresent());
        System.out.println("orElse: " + middleName.orElse("— немає запису —"));

        // 2. Значення існує
        MyOptional<String> username = new MyOptional<>("Користувач_Соняшник");
        System.out.println("\nMyOptional з даними:");
        System.out.println(username);
        System.out.println("isPresent: " + username.isPresent());
        System.out.println("get(): " + username.get());
        System.out.println("orElse: " + username.orElse("Гість"));

        // --- Перевірка get() у порожнього MyOptional ---
        System.out.println("\nПеревірка — get() у порожнього значення:");
        try {
            new MyOptional<>().get();
        } catch (IllegalStateException e) {
            System.out.println("   Очікуваний виняток: " + e.getMessage());
        }

        // --- Перевірка передачі null ---
        System.out.println("\nПеревірка — спроба передати null у конструктор MyOptional:");
        try {
            new MyOptional<>(null);
        } catch (IllegalArgumentException e) {
            System.out.println("   Правильно не дозволив null: " + e.getMessage());
        }




        System.out.println("\n===== Завдання 2 — BookData + Comparable =====\n");
        System.out.println("Тестуємо Comparable:");
        System.out.println("- створюємо масив книг");
        System.out.println("- сортуємо за рейтингом (від більшого до меншого)\n");

        BookData b1 = new BookData("Мистецтво програмування", "Дональд Кнут", 120, 580);
        BookData b2 = new BookData("Чистий код", "Роберт Мартін", 200, 950);
        BookData b3 = new BookData("Мистецтво програмування", "Дональд Кнут", 80, 380);

        BookData[] books = {b1, b2, b3};

        System.out.println("До сортування:");
        Arrays.stream(books).forEach(System.out::println);

        Arrays.sort(books);

        System.out.println("\nПісля сортування:");
        Arrays.stream(books).forEach(System.out::println);




        System.out.println("\n===== Завдання 3 — Printer.printArray() =====\n");
        System.out.println("Тестуємо узагальнений метод printArray() — він друкує будь-який масив.\n");

        Printer printer = new Printer();
        Integer[] nums = {10, 20, 30};
        String[] words = {"Квітка", "Мрія", "Україна"};

        System.out.println("Масив чисел:");
        printer.printArray(nums);

        System.out.println("\nМасив рядків:");
        printer.printArray(words);




        System.out.println("\n===== Завдання 4 — узагальнений filter() =====\n");
        System.out.println("Тестуємо власний generic-фільтр:");
        System.out.println("- лямбда-функція перевіряє елементи масиву");
        System.out.println("- повертається новий масив, який відповідає умові\n");

        Integer[] data = {1, 2, 3, 4, 5, 6};

        Integer[] even = GenericFilter.filter(data, x -> x % 2 == 0);
        System.out.println("Парні числа:");
        System.out.println(Arrays.toString(even));

        Integer[] greater3 = GenericFilter.filter(data, x -> x > 3);
        System.out.println("Числа більше 3:");
        System.out.println(Arrays.toString(greater3));




        System.out.println("\n===== Завдання 5 — contains() =====\n");
        System.out.println("Тестуємо узагальнений contains():");
        System.out.println("- пошук елемента в масиві");
        System.out.println("- метод працює для типів, що реалізують Comparable\n");

        String[] names = {"Андрій", "Олена", "Катерина", "Юрій", "Соломія"};

        boolean r1 = GenericContains.contains(names, "Олена");
        boolean r2 = GenericContains.contains(names, "Микола");

        System.out.println("Містить 'Олена'? " + r1);
        System.out.println("Містить 'Микола'? " + r2);




        System.out.println("\n===== Завдання 6 — GenericTwoTuple та GenericThreeTuple =====\n");
        System.out.println("Тестуємо кортежі:");
        System.out.println("- GenericTwoTuple: пара значень");
        System.out.println("- GenericThreeTuple: трійка значень\n");

        GenericTwoTuple<String, Integer> tuple1 =
                new GenericTwoTuple<>("Полуниця", 25);

        System.out.println("Приклад GenericTwoTuple:");
        System.out.println(tuple1);

        GenericThreeTuple<String, Integer, Double> tuple2 =
                new GenericThreeTuple<>("Студент", 2025, 98.7);

        System.out.println("\nПриклад GenericThreeTuple:");
        System.out.println(tuple2);


        System.out.println("\n===== ВСІ ТЕСТИ ЗАВЕРШЕНО УСПІШНО =====");
    }
}
