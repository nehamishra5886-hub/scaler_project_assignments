package com.example.Evaluations.evaluation.dtos;

public class LoginResponseDto {
    private LoginStatus status;
    private String token;

    public LoginStatus getStatus() {
        return status;
    }

    public void setStatus(LoginStatus status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
