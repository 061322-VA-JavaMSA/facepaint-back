package com.revature.facepaint.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.facepaint.exceptions.ArtNotFoundException;
import com.revature.facepaint.model.Art;
import com.revature.facepaint.services.ArtService;

@Controller
public class ArtController {
	private ArtService as;
	private ObjectMapper om;
	
	public ArtController(ArtService as, ObjectMapper om) {
		super();
		this.as = as;
		this.om = om;
	}
	
	@GetMapping(
			value="/art/{id}",
			produces="application/json")
	@ResponseBody
	public String getArtById(@PathVariable int id) {
		Art art;
		try {
			art = as.findArtById(id);
			return om.writeValueAsString(art);
		} catch (ArtNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return String.format("Art was not found." , id);
		} catch(JsonProcessingException e) {
			e.printStackTrace();
			return "";
		}
	}

}
