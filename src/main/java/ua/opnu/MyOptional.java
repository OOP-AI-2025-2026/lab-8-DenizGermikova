package ua.opnu;

public class MyOptional<T> {

    private T value;
    private boolean present;

    // Порожній конструктор
    public MyOptional() {
        this.present = false;
        this.value = null;
    }

    // Конструктор з параметром
    public MyOptional(T value) {
        if (value == null) {
            throw new IllegalArgumentException("MyOptional не приймає null");
        }
        this.value = value;
        this.present = true;
    }

    // Перевірка наявності значення
    public boolean isPresent() {
        return present;
    }

    // Протилежність isPresent()
    public boolean isEmpty() {
        return !present;
    }

    // Отримати значення
    public T get() {
        if (!present) {
            throw new IllegalStateException("Значення відсутнє!");
        }
        return value;
    }

    // Отримати значення або заміну
    public T orElse(T defaultValue) {
        return present ? value : defaultValue;
    }

    // Для дебага
    @Override
    public String toString() {
        if (present) {
            return "MyOptional[value=" + value + "]";
        }
        return "MyOptional[empty]";
    }
}
