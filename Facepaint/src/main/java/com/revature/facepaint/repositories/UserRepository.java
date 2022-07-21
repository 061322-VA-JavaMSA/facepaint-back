package com.revature.facepaint.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.facepaint.model.Role;
import com.revature.facepaint.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	List<User> findUserByRole(Role role);
	
	User findUserByUsername(String username);
	
}
