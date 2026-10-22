package com.example.Evaluations.evaluation.controller;

import com.example.Evaluations.evaluation.dtos.LoginRequestDto;
import com.example.Evaluations.evaluation.dtos.LoginResponseDto;
import com.example.Evaluations.evaluation.dtos.LoginStatus;
import com.example.Evaluations.evaluation.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping
    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto) {
        // TODO:
        // In case of success, LoginResponseDto will contain status "SUCCESS" and token
        // In case of exception, LoginResponseDto will contain status "FAILURE" and null token

        LoginResponseDto response = new LoginResponseDto();

        try {
            String token = userService.login(loginRequestDto);
            response.setStatus(LoginStatus.SUCCESS);
            response.setToken(token);
        } catch (Exception e) {
            response.setStatus(LoginStatus.FAILURE);
            response.setToken(null);
        }

        return response;
        //return null;
    }
}
