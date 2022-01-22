package com.example.api.annotations.validators;

import com.example.api.annotations.LoginConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LoginValidator implements ConstraintValidator<LoginConstraint, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext cvc) {
        return s != null && s.matches("(?=^)[a-zA-Z1-9_!#$%*]*(?=$)");
    }
}
