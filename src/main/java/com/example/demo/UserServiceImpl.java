package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public UserServiceImpl() {
        this.userDao = userDao;
    }

    //List<User> users = new ArrayList<>();
    private int userIdCounter = 1;

    @Override
    public User createUser(String email, String password) {
        User user = new User(userIdCounter++, email, password);
        user.setEmail(email);
        user.setPassword(password);
        // Cas pour List
        //users.add(user);

        // Cas pour JPA
        userDao.addUser(user);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll().toList();
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
        return userDao.saveUser(user);

        //before add userDAO
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
