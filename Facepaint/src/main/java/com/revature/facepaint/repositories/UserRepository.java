package com.revature.facepaint.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.facepaint.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findUserByUsernameAndPassword(String username, String password);
}
