package org.example;

import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * Класс для автоматического внедрения зависимостей в объекты.
 * Ищет поля, помеченные аннотацией и инициализирует их
 * экземплярами классов, указанных в конфигурационном файле.
 */
public class Injector {
    private Properties properties;

    /**
     * Конструктор по умолчанию. Загружает конфигурацию из файла config.properties.
     */
    public Injector() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/dependencies.properties"));
        } catch (Exception e) {
            throw new RuntimeException("Failed to load properties file", e);
        }
    }

    /**
     * Внедряет зависимости в переданный объект.
     * @param object объект, в который нужно внедрить зависимости
     * @return тот же объект с внедренными зависимостями
     * @param <T> тип объекта для внедрения зависимостей
     */
    public <T> T inject(T object) {
        Class<?> clazz = object.getClass();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(AutoInjectable.class)) {
                Class<?> fieldType = field.getType();

                String implementationClassName = properties.getProperty(fieldType.getName());
                if (implementationClassName == null) {
                    throw new RuntimeException("No implementation specified for " + fieldType.getName());
                }

                try {
                    Class<?> implementationClass = Class.forName(implementationClassName);
                    Object implementationInstance = implementationClass.getDeclaredConstructor().newInstance();

                    field.setAccessible(true);
                    field.set(object, implementationInstance);
                } catch (Exception e) {
                    throw new RuntimeException("Failed to inject dependency for field " + field.getName(), e);
                }
            }
        }

        return object;
    }
}