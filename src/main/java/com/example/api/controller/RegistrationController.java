package com.example.api.controller;

import com.example.api.entity.DTO.UserDTO;
import com.example.api.exception.EmptyArgumentException;
import com.example.api.exception.NotUniqueFieldException;
import com.example.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    @Autowired
    private UserService userService;


    @PostMapping("/registration")
    public ResponseEntity<UserDTO> registration(@RequestBody @Validated UserDTO user) {
        if (user == null) {
            throw new EmptyArgumentException("user");
        }

        if (userService.existsUser(user.getLogin())) {
            throw new NotUniqueFieldException("user");
        }
        userService.save(user);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
