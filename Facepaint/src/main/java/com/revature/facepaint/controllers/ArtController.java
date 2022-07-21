package com.revature.facepaint.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.revature.facepaint.dto.UserDTO;
import com.revature.facepaint.exceptions.UserNotFoundException;
import com.revature.facepaint.model.User;
import com.revature.facepaint.services.UserService;

@RestController
//@RequestMapping("/art")
public class ArtController {
	
	private UserService us;

	public ArtController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	public ArtController(UserService us) {
		super();
		this.us = us;
	}
	
	
	
	@GetMapping(value = "/artInfo")
    public ResponseEntity<String> getArtAttributes(@RequestParam(name="fields") String fields){
		String urlFront = "https://api.artic.edu/api/v1/artworks?fields=";
		String url = urlFront+fields;
		RestTemplate restTemplate = new RestTemplate();

		String artAttr = restTemplate.getForObject(url, String.class);
		return new ResponseEntity<String>(artAttr, HttpStatus.OK);
	}
    
    
	@GetMapping(value = "/artwork", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getArtPiece(@RequestParam(name="imageID") String imageID){
		String urlFront = "https://www.artic.edu/iiif/2/";
		String urlBack = "/full/843,/0/default.jpg";
		String url = urlFront+imageID+urlBack;
		RestTemplate restTemplate = new RestTemplate();

		byte[] artPiece = restTemplate.getForObject(url, byte[].class);
		return new ResponseEntity<byte[]>(artPiece, HttpStatus.OK);
	}
}
