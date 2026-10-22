package com.example.Evaluations.evaluation.controller;

import com.example.Evaluations.evaluation.dtos.UserDto;
import com.example.Evaluations.evaluation.model.User;
import com.example.Evaluations.evaluation.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> registerUser(@Valid @RequestBody UserDto user) {
        // TODO:
        // 1) Call userService.registerNewUserAccount(user)
        // 2) On success: return ResponseEntity with CREATED (201) and created User in body
        // 3) On exception: return ResponseEntity with CONFLICT (409) and null body

        try {
            User createdUser = userService.registerNewUserAccount(user);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.CONFLICT);
        }
        //return null; // remove this
    }
}
