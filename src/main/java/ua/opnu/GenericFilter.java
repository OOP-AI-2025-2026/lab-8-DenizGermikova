package ua.opnu;

import java.util.Arrays;

public class GenericFilter {

    public static <T> T[] filter(T[] input, Predicate<T> p) {

        T[] temp = Arrays.copyOf(input, input.length); // створюємо масив того ж типу
        int counter = 0;

        for (T element : input) {
            if (p.test(element)) {
                temp[counter++] = element;
            }
        }

        return Arrays.copyOf(temp, counter);
    }
}
