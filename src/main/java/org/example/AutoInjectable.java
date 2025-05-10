package org.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для пометки полей, которые должны быть автоматически инициализированы
 * механизмом внедрения зависимостей. Поля, помеченные этой аннотацией, будут
 * автоматически заполнены экземплярами классов, указанных в конфигурационном файле.
 *
 * <p>Применяется только к полям класса.</p>
 *
 * @see Injector
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoInjectable {
}