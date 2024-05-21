package com.cts.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.project.entity.User;
import com.cts.project.repository.UserRepository;
import com.cts.project.response.LoginRequest;
import com.cts.project.response.LoginResponse;
import com.cts.project.service.UserService;

@CrossOrigin("http://localhost:3000")
@RestController
public class UserController {

	public static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return ResponseEntity.ok(userService.createUser(user));
	}

	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUser() {
		logger.info("Getting all users");
		List<User> userList = userService.getAllUsers();
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}

	@GetMapping("/getUserById/{id}")
	public User getUserById(@PathVariable Long id){
		logger.info("Getting user by id");
		User checkUser = userService.getUserById(id);
		if (checkUser == null) {
			logger.error("User cannot be found");
			
		}
		logger.info("Getting user by id");
		return checkUser;
	}

	
	
//	-------------------------------------------------------------
	@GetMapping("/getUserByEmailId/{email}")
    public User getUserByEmail(@PathVariable String email) {
        logger.info("fetching User via email");
        return userService.getUserByEmailId(email);
    }

	
	
	
	
//	-------------------------------------------------------------
	
	@PutMapping("/updateUserById/{id}/{attendance}")
	public Long updateUserById(@PathVariable Long attendance, @PathVariable Long id) {
		System.out.println("hi"+attendance);
		logger.info("Updating user");
		return userService.updateUserById(attendance, id);
	}

	@DeleteMapping("/deleteUserById/{id}")
	public void deleteUserById(@PathVariable Long id) {

		logger.info("Deleting user");
		userService.deleteUserById(id);
	}

	@PostMapping(path = "/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest user) {
		LoginResponse loginResponse = userService.loginUser(user);
		return ResponseEntity.ok(loginResponse);
	}

}