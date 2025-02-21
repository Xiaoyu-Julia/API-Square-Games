package com.example.demo.controller;

import com.example.demo.service.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    private int userIdCounter = 1; // ne pas mettre 0 dans le id d'une table, car id est la clé primaire

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public UserDto addUser(@RequestBody UserCreationParams params) {
        //User user = this.userService.createUser(params.userId, params.email, params.password);
        User user = this.userService.createUser(new User(userIdCounter++, params.email, params.password));
        return new UserDto(user.getUserId(), user.getEmail());
    }

    @GetMapping("/users")
    public List<UserDto> getAllUsers() {
        List<UserDto> userDtoList = new ArrayList<>();
        List<User> users = this.userService.getAllUsers();
        for (User user : users) {
            userDtoList.add(new UserDto(user.getUserId(), user.getEmail()));
        }
//        for (int i = 0; i <= users.size(); i++) {
//            userDtoList.add(new UserDto(users.get(i).getUserId(), users.get(i).getEmail()));
//        }

        return userDtoList;
    }

    @GetMapping("/users/{userId}")
    public UserDto getUser(@PathVariable int userId) {
        User user =  userService.getUserById(userId);
        //System.out.println("user: " + user.getUserId());
        return new UserDto(user.getUserId(), user.getEmail());
    }

    @PutMapping("/users/{userId}")
    public UserDto updateUser(@PathVariable int userId, @RequestBody UserCreationParams params) {
        User user = this.userService.modifyUser(userId, params.email, params.password);
        return new UserDto(user.getUserId(), user.getEmail());
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable int userId) {
        System.out.println("User deleted: " + userId);
        this.userService.deleteUser(userId);

    }

}
