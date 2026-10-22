package com.example.Evaluations.evaluation.util;

import com.example.Evaluations.evaluation.annotations.ValidEmail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return false;
        return EMAIL_PATTERN.matcher(value).matches();
    }
}