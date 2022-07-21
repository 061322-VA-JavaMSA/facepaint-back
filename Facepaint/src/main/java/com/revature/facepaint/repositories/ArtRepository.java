package com.revature.facepaint.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.facepaint.model.Art;
import com.revature.facepaint.model.User;

@Repository
public interface ArtRepository extends JpaRepository<User, Integer>{
	List<Art> findArtByUser(User artassigned); //Art that is owned by a user gets retrieved in list format
	Art findArtById (int id); // Find an art piece by it's id
	Art findArtByArtistName(String name); // Find an art piece by it's creator

}
