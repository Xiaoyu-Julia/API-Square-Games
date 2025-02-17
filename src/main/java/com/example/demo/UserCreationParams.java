package com.example.demo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class UserCreationParams {
    public @NotNull @Email String email;
    public @NotEmpty String password;

    public UserCreationParams(@NotNull @Email String email, @NotEmpty String password) {
        this.email = email;
        this.password = password;
    }
}
