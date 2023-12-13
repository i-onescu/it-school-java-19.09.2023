package org.bogdan.bankingsystem.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

// In order to explain the group of elements the annotation can be placed on
// you can use the @Target annotation
@Target({ElementType.FIELD, ElementType.CONSTRUCTOR})
// In order to create custom annotations you need to use '@' before 'interface' keyword
public @interface TestAnnotation {
}
