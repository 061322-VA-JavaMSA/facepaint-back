package com.revature.facepaint.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.facepaint.exceptions.UserNotFoundException;
import com.revature.facepaint.model.User;
import com.revature.facepaint.repositories.UserRepository;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.facepaint.dtos.UserDTO;
import com.revature.facepaint.exceptions.UserNotFoundException;
import com.revature.facepaint.model.User;
import com.revature.facepaint.services.AuthService;
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



import com.revature.facepaint.exceptions.UserNotFoundException;
import com.revature.facepaint.model.Role;
import com.revature.facepaint.model.User;

import com.revature.facepaint.services.UserService;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:8080")
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
	public ResponseEntity<List<UserDTO>> getAllUsers(@RequestParam(name="role", required=false) Role role){
		List<UserDTO> usersDTO = new ArrayList<>();
		List<User> users;
		
		// if a query param for role is passed, filter by role
		if(role == null) {
			 users = us.getUsers();
		} else {
			users = us.getByRole(role);
		}
		
		for(User u : users) {
			usersDTO.add(new UserDTO(u));
		}
		
		return new ResponseEntity<>(usersDTO, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable("id") int id) throws UserNotFoundException{
			UserDTO userDTO = new UserDTO(us.getUserById(id));
			return new ResponseEntity<>(userDTO, HttpStatus.OK);
	}
	
	//PATHING ISSUE BETWEEN GET BY ID AND GET BY IMAGE ID, POTENTIAL SIMPLE FIX
	/*
	 * @GetMapping("/{imageID}") public User getUserShowcase(String imageID){ return
	 * us.getUserShowcase(imageID); }
	 */

	
	@PostMapping
	public ResponseEntity<UserDTO> createUser(@RequestBody User user){

		
		User newUser = us.addUser(user);
		
		UserDTO userDTO = new UserDTO(newUser);
		
		return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
	}
	
	//MAYBE CHANGE TO USER DTO?
	// Assumes front end changes imageID
	@PutMapping
	public ResponseEntity<User> updateImageID(@RequestBody User u){
		
		us.updateUserImageId(u);
		
		return new ResponseEntity<>(u, HttpStatus.OK);
	}
	


	@DeleteMapping
	public ResponseEntity<User> deleteUserById(@RequestBody User u){
		
		
		us.removeUserById(u);
		
		
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
		
	}



		
}
