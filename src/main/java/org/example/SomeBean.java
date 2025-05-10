package org.example;

/**
 * Пример класса с зависимостями, которые должны быть внедрены автоматически.
 * Содержит два поля, помеченные аннотацией {@link AutoInjectable}.
 */
public class SomeBean {
    @AutoInjectable
    private SomeInterface field1;

    @AutoInjectable
    private SomeOtherInterface field2;
    /**
     * Демонстрирует работу внедренных зависимостей.
     * Вызывает методы внедренных объектов.
     */
    public void foo() {
        field1.doSomething();
        field2.doSomeOther();
    }
}
