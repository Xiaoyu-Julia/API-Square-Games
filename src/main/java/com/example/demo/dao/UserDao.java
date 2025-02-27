package com.example.demo.dao;

import com.example.demo.service.User;
import jakarta.validation.constraints.NotNull;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

public interface UserDao {

    @NotNull Stream<User> findAll();
    Optional<User> findUserById(@NotNull UUID userId);
    @NotNull User addUser (@NotNull User user);
    @NotNull User saveUser(@NotNull User user);
    void deleteUser(@NotNull UUID userId);

}
