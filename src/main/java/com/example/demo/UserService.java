package com.example.demo;

import java.util.List;

public interface UserService {
    User createUser(String email, String password);

    /**
     * Pourquoi pas l'objet UserDto pour la liste ?
     * @return
     */
    List<User> getAllUsers();

    User getUserById(int userId);

    User modifyUser(int userId, String email, String password);

    void deleteUser(int userId);

}
