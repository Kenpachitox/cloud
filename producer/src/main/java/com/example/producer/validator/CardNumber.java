package com.example.producer.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = com.example.producer.validator.CardNumberValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
public @interface CardNumber {
    String message() default "incorrect card number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
