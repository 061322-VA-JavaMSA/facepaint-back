package com.revature.facepaint.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.facepaint.exceptions.UserNotFoundException;
import com.revature.facepaint.model.User;
import com.revature.facepaint.repositories.UserRepository;

@Service
@Transactional
public class UserService {

	private UserRepository ur;
	
	public UserService(UserRepository ur) {
		super();
		this.ur = ur;
	}
	
//	public User updateUserShowcase(User user, int id) throws UserNotFoundException {
////		User user = ur.getUserByUsername(username);
////		ur.getUserByImageID(imageID);
////		ur.updateUserShowcase(imageID);
//		
//		User updatedUser = ur.findById(id).orElseThrow(() -> new UserNotFoundException()); //check if the user in the DB has an id
//		updatedUser.setImageID(user.getImageID()); //set the showcase_art
//		//save the updated User to the DB that has an imageID
//		ur.save(updatedUser);
//		return updatedUser;
//	}
	
//	public User updateUserPassword(String password) {
//		return ur.updateUserPassword(password);
//	}
	
	public User getUserShowcase(String imageID) {
		return ur.getUserByImageID(imageID);
	}
	public User getUserById(int id) {
		return ur.getUserById(id);
	}
//	public User saveUser(User user) {
//		return ur.save(user);
//	}
	public User updateUserImageId(User u) {
		return ur.save(u);
	}
}
