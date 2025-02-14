package com.duongpham26.LaptopShop.service.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = RegisterDTOValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface RegisterDTOChecked {
    String message() default "User register validation failed";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
