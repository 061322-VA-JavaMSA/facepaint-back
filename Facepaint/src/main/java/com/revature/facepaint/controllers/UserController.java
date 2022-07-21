package com.revature.facepaint.controllers;

import com.revature.facepaint.dto.UserDTO;
import com.revature.facepaint.exceptions.UserNotFoundException;
import com.revature.facepaint.model.User;
import com.revature.facepaint.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.revature.facepaint.services.UserService;
import org.springframework.web.bind.annotation.*;

//@Controller

//Use this to specify all methods should return a response body.
@RestController
@RequestMapping("/users")
public class UserController {
	
	private UserService us;

	public UserController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	public UserController(UserService us, AuthService as) {
		super();
		this.us = us;
	}

}
