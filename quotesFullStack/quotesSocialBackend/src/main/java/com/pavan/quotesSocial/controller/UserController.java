package com.pavan.quotesSocial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pavan.quotesSocial.DTO.SignInDto;
import com.pavan.quotesSocial.Enitity.User;
import com.pavan.quotesSocial.exceptions.UserException;
import com.pavan.quotesSocial.service.UserService;

@RestController
@RequestMapping(value = "user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<User>> getallUser(){
		
		
			List<User> users= userService.getallusers();
			return new ResponseEntity<List<User>>(users,HttpStatus.OK);
		
		
		
	}
	
	@PostMapping(value = "/add")
	public ResponseEntity<User> addUser(@RequestBody User user) {

		
			User user2 = userService.addUser(user);
			return new ResponseEntity<User>(user2, HttpStatus.OK);
		

	}
	@PutMapping(value = "/update-user")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		
			User user2= userService.updateUser(user);
			return new ResponseEntity<User>(user2, HttpStatus.OK);	
	}
	
	@GetMapping(value = "/{userId}")
	public ResponseEntity<User> findUserByUserId(@PathVariable("userId") long userId){
		
		
			User user= userService.findUserByUserId(userId);
			return new ResponseEntity<User>(user,HttpStatus.OK);	
	}
	
	@PutMapping(value = "/add-freind/{userId}/{freindId}")
	public ResponseEntity<User> addUser(@PathVariable Long userId, @PathVariable Long freindId) {

		User user2 = userService.addFriend(userId, freindId);
		return new ResponseEntity<User>(user2, HttpStatus.OK);

	}
	
	@PostMapping(value = "/user-signin")
	public ResponseEntity<User> findUserByUserId(@RequestBody SignInDto signInDto){
		
		
			User user= userService.userSignIn(signInDto.getEmail(), signInDto.getPassword());
			return new ResponseEntity<User>(user,HttpStatus.OK);	
	}
	
	
	
	
	
	
	

}
