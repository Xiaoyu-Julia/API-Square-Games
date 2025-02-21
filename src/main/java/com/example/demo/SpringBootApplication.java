package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplication { //implements CommandLineRunner {

//	@Autowired
//	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplication.class, args);

//		UserService userService = new UserServiceImpl();
//		List<User> userList = userService.getAllUsers();
//		for (User user : userList) {
//			System.out.println("User : " + user);
//		}
	}

//	@Override
//	public void run(String... args) throws Exception {
//		Iterable<User> users = userService.getAllUsers();
//		users.forEach(user -> System.out.println("user:" + user.getEmail()));
//	}

}
