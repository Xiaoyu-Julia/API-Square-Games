package com.example.demo;

import jakarta.validation.constraints.NotNull;

import java.util.Optional;
import java.util.stream.Stream;

public interface UserDao {
    @NotNull Stream<User> findAllUsers();
    Optional<User> findUserById(@NotNull int userId);
    @NotNull User addUser (@NotNull User user);
    @NotNull User saveModifUser(@NotNull User user);
    void deleteUser(@NotNull int userId);

}
