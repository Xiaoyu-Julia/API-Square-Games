package com.example.demo.controller;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class UserCreationParams {

    public @NotNull @Email String email;
    public @NotEmpty String password;
   // public @NotNull UUID userId;

    public UserCreationParams(/*@NotNull UUID userId, */@NotNull @Email String email, @NotEmpty String password) {
        //this.userId = userId;
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
