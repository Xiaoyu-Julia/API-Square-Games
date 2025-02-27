package com.example.demo.service;

import java.util.List;
import java.util.UUID;

public interface UserService {

    //User createUser(int userId, String email, String password);
    User createUser(User user);

    List<User> getAllUsers();

    User getUserById(UUID userId);

    User modifyUser(UUID userId, String email, String password);

    void deleteUser(UUID userId);

}
