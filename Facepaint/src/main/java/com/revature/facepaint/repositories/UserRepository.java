package com.revature.facepaint.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.revature.facepaint.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
//	User updateUserImageID(User user, int id);
//	User updateUserPassword(String password);
	
	User getUserById(int id);
	User getUserByImageID(String imageID);
	
//	User getUserByUsername(String username);

}
