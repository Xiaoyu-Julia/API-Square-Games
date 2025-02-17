package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userServiceImpl;

    @PostMapping("/users")
    public UserDto addUser(@RequestBody UserCreationParams params) {
        User user = this.userServiceImpl.createUser(params.email, params.password);
        return new UserDto(user.getUserId(), user.getEmail());
    }

    @GetMapping("/users")
    public List<UserDto> getAllUsers() {
        List<UserDto> userDtoList = new ArrayList<>();
        List<User> users = this.userServiceImpl.getAllUsers();
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
        User user =  userServiceImpl.getUserById(userId);
        //System.out.println("user: " + user.getUserId());
        return new UserDto(user.getUserId(), user.getEmail());
    }

    @PutMapping("/users/{userId}")
    public UserDto updateUser(@PathVariable int userId, @RequestBody UserCreationParams params) {
        User user = this.userServiceImpl.modifyUser(userId, params.email, params.password);
        return new UserDto(user.getUserId(), user.getEmail());
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable int userId) {
        userServiceImpl.deleteUser(userId);
    }

}
