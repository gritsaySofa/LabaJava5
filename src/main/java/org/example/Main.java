package org.example;

/**
 * Класс с точкой входа в приложение.
 * Создает экземпляр SomeBean с внедренными зависимостями и вызывает его метод.
 */
public class Main {
    /**
     * Точка входа в приложение.
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        SomeBean sb = new Injector().inject(new SomeBean());
        sb.foo();
    }
}