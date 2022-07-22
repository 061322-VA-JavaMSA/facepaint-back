package com.revature.facepaint.controllers;


import com.revature.facepaint.dto.UserDTO;
import com.revature.facepaint.exceptions.UserNotFoundException;
import com.revature.facepaint.model.Role;
import com.revature.facepaint.model.User;
import com.revature.facepaint.repositories.UserRepository;
import com.revature.facepaint.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController

@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/users")
public class UserController {

	private UserService us;
	private UserRepository ur;


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

	// Assumes front end changes imageID
	@PutMapping
	public ResponseEntity<User> updateImageID(@RequestBody User u){
		
		us.updateUserImageId(u);
		
		return new ResponseEntity<>(u, HttpStatus.OK);
	}
	
	
	@GetMapping("/{imageID}")
	public User getUserShowcase(String imageID){
		return us.getUserShowcase(imageID);
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable("id") int id) throws UserNotFoundException{
			UserDTO userDTO = new UserDTO(us.getUserById(id));
			return new ResponseEntity<>(userDTO, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<UserDTO> createUser(@RequestBody User user){

		
		User newUser = us.addUser(user);
		
		UserDTO userDTO = new UserDTO(newUser);
		
		return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
	}
}
