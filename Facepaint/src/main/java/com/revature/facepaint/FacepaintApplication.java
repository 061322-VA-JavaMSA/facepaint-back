package com.revature.facepaint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.revature.facepaint.model.Role;
import com.revature.facepaint.model.User;
import com.revature.facepaint.services.UserService;

@SpringBootApplication
public class FacepaintApplication {

	public static void main(String[] args) {
		SpringApplication.run(FacepaintApplication.class, args);
	}

	
}

//@Component
//class AppStartupRunner implements ApplicationRunner{
//	
//	@Autowired
//	private UserService us;
//	@Override
//	public void run(ApplicationArguments args) throws Exception{
//		User a = new User();
//		a.setUsername("a");
//		a.setPassword("a pass");
//		a.setRole(Role.ADMIN);
//		
//		User b = new User();
//		b.setUsername("b");
//		b.setPassword("b pass");
//		b.setRole(Role.BASIC_USER);
//		
//		us.addUser(a);
//		us.addUser(b);
//		List<User> users = us.getUsers();
//		
//		users.forEach(user -> System.out.println(user));
//		
//	}
//}
