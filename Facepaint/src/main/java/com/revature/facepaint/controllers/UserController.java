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
import com.revature.facepaint.services.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/users")
public class UserController {
	
	private UserService us;
	private UserRepository ur;


//	public UserController() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
	
	public UserController(UserService us) {
		super();
		this.us = us;
	}
	
	
	//update the User's showcase by taking the user's Id
	// http://localhost:8080/api/user/{imageID}

//	@PostMapping
//	public ResponseEntity<User> updateImageID(@RequestParam(name="id")int id, @RequestParam(name="imageID") String imageID){
//		User updatedUser = us.getUserById(id);
//		updatedUser.setImageID(imageID);
//		us.updateUserImageId(updatedUser);
//		
//		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
//	}
	
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

}