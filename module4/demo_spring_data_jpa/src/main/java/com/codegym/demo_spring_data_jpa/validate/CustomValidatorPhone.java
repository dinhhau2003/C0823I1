package com.codegym.demo_spring_data_jpa.validate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CustomValidatorPhone implements ConstraintValidator<ValidatePhone, String> {
    @Override
    public void initialize(ValidatePhone constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.matches("\\d{10}"); // Kiểm tra chuỗi có chứa 10 chữ số hay không
    }
}
