package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    List<User> users = new ArrayList<>();
    private int userIdCounter = 1;
    @Override
    public User createUser(String email, String password) {
        User user = new User(userIdCounter++, email, password);
        users.add(user);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public User getUserById(int userId) {
        //System.out.println("getUserById: " + userId);
        return users.get(userId);
    }

    @Override
    public User modifyUser(int userId, String email, String password) {
        User user = getUserById(userId);
        for (User u : users) {
            if (user.getUserId() == u.getUserId()) {
                u.setEmail(email);
                u.setPassword(password);
            }
        }
        return user;
    }

    @Override
    public void deleteUser(int userId){
        users.remove(userId);
    }

}
