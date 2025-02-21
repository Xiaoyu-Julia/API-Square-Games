package com.example.demo.service;

import java.util.List;

public interface UserService {

    //User createUser(int userId, String email, String password);
    User createUser(User user);

    List<User> getAllUsers();

    User getUserById(int userId);

    User modifyUser(int userId, String email, String password);

    void deleteUser(int userId);

}
