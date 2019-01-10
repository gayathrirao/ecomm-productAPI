package com.gayathri.spring.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.gayathri.spring.model.User;
import com.gayathri.spring.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/user/{username}")
	public ResponseEntity<User> findByUsername(@PathVariable("username") String user_name)
	{
		logger.info("Username received is" + user_name);
		Optional<User> userfound =  userService.findByUsername(user_name);
		return ResponseEntity.ok(userfound.get());
	}
	
	@PostMapping("/user")
	public ResponseEntity<?> save(@RequestBody User usr)
	{
		logger.info("User to be saved"+usr);
		User savedUser = userService.save(usr);
		return (ResponseEntity.ok("User saved successfully" + savedUser ));
	}
	
	   @PutMapping("/user/{user_name}")
	   public ResponseEntity<?> update(@PathVariable("user_name") String userName, @RequestBody User user) {
	      
		  userService.update(userName, user);
	      
	      return ResponseEntity.ok().body("User has been updated successfully.");
	   }

	   /*---Delete a Product by id---*/
	   @DeleteMapping("/user/{user_name}")
	   public ResponseEntity<?> delete(@PathVariable("user_name") String username) {
	      userService.delete(username);
	      return ResponseEntity.ok().body("User has been deleted successfully.");
	   }
	   
}
