package com.revature.facepaint.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.facepaint.model.Role;
import com.revature.facepaint.model.User;
import com.revature.facepaint.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private UserService us;

	public UserController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	public UserController(UserService us) {
		super();
		this.us = us;
	}
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<User>> getAllUsers(@RequestParam(name="role", required=false)Role role){
		List<User> users;
		 
			users = us.getUsers();
		
		return new ResponseEntity<>(users, HttpStatus.OK);
		
	}
	@DeleteMapping
	public ResponseEntity<User> deleteUserById(@RequestBody User u){
		
		
		us.removeUserById(u);
		
		
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
		
	}
	
	
	
	
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		
		User newUser = us.addUser(user);
		
		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
		
	}

}
