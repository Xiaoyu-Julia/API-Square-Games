package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DemoSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBootApplication.class, args);

//		UserService userService = new UserServiceImpl();
//		List<User> userList = userService.getAllUsers();
//		for (User user : userList) {
//			System.out.println("User : " + user);
//		}
	}

}
