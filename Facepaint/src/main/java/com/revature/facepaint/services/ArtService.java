package com.revature.facepaint.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.revature.facepaint.exceptions.ArtNotFoundException;
import com.revature.facepaint.model.Art;
import com.revature.facepaint.model.User;
import com.revature.facepaint.repositories.ArtRepository;

@Service
public class ArtService {

	private ArtRepository ar;
	
	public ArtService(ArtRepository ar) {
		super();
		this.ar = ar;
	}
	
	public List<Art> findArtByUser(User u){
//		Art art = ar.findArtByUser(artassigned).orElseThrow(() -> new ArtNotFoundException());
		return ar.findArtByUser(u);
	}
	// /art/{id}
	// - GET: returns all Art 
	
	@Transactional
	public Art findArtById(int id) throws ArtNotFoundException{
		Art art = ar.findArtById(id).orElseThrow(() -> new ArtNotFoundException());
		return art;
	}
}
