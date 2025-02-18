package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    //List<User> users = new ArrayList<>();
    private int userIdCounter = 1;

    @Override
    public User createUser(String email, String password) {
        User user = new User(userIdCounter++, email, password);
        userDao.addUser(user);
        //users.add(user);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAllUsers().toList();
        //return users;
    }

    @Override
    public User getUserById(int userId) {
        return userDao.findUserById(userId).orElse(null);
        //return users.get(userId);
    }

    @Override
    public User modifyUser(int userId, String email, String password) {
        User user = userDao.findUserById(userId).orElse(null);
        assert user != null;
        user.setEmail(email);
        user.setPassword(password);
        return userDao.saveModifUser(user);

        //before add DAO
//        User user = getUserById(userId);
//        for (User u : users) {
//            if (user.getUserId() == u.getUserId()) {
//                u.setEmail(email);
//                u.setPassword(password);
//            }
//        }
//        return user;
    }

    @Override
    public void deleteUser(int userId){
        userDao.deleteUser(userId);
       // users.remove(userId);
    }


}
