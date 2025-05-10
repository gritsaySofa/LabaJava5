package org.example;

/**
 * Реализация интерфейса.
 * Выводит "A" при вызове метода doSomething().
 */
public class SomeImpl implements SomeInterface {
    /**
     * Реализация метода интерфейса.
     * Выводит "A" в стандартный вывод.
     */
    public void doSomething() {
        System.out.println("A");
    }
}
