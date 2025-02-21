package com.example.demo.dao;

import com.example.demo.service.User;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public class InMemoryUserDao implements UserDao {

    List<User> users = new ArrayList<>();

    @Override
    public @NotNull Stream<User> findAll() {
        return users.stream();
    }

    @Override
    public Optional<User> findUserById(@NotNull int userId) {
        return Optional.ofNullable(users.get(userId));
    }

    @Override
    public @NotNull User addUser (@NotNull User user) {
        users.add(user);
        return user;
    }

    @Override
    public @NotNull User saveUser(@NotNull User user) {
        return users.set(users.indexOf(user), user);
    }

    @Override
    public void deleteUser(@NotNull int userId) {
        users.removeIf(user -> user.getUserId() == userId);
    }

}
