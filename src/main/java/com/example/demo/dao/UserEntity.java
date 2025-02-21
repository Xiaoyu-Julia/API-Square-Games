package com.example.demo.dao;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jdk.jfr.DataAmount;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    //@GeneratedValue( strategy= GenerationType.AUTO)
    @Column(name="user_id")
    private int user_id;

    @Column(name="email")
    public @NotNull @Email String email;

    @Column(name="password")
    public @NotNull String password;

    public UserEntity(int user_id, String password, String email) {
        this.user_id = user_id;
        this.password = password;
        this.email = email;
    }

    public UserEntity() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int id) {
        this.user_id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("User [id=%d, email=%s, password=%s]", user_id, email, password);
    }

}

