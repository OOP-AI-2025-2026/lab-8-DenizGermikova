package ua.opnu;

public class Printer {

    // Узагальнений метод, який друкує елементи будь-якого масиву
    public <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }
}
