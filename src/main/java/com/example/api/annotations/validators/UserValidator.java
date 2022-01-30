package com.example.api.annotations.validators;

import com.example.api.annotations.UserConstraint;
import com.example.api.entity.DTO.UserDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class UserValidator implements ConstraintValidator<UserConstraint, UserDTO> {

    @Override
    public boolean isValid(UserDTO user, ConstraintValidatorContext constraintValidatorContext) {
        String login = user.getLogin();
        String password = user.getPassword();
        return (login != null && password != null)
                && (login.matches("(?=^)[a-zA-Z1-9_!#$%*]*(?=$)") && password.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,}"));
    }
}
