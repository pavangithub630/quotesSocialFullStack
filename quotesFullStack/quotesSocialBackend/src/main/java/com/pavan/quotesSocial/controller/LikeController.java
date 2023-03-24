package com.pavan.quotesSocial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pavan.quotesSocial.Enitity.Likes;
import com.pavan.quotesSocial.service.LikesService;

@RestController
@RequestMapping(value = "/likes")
@CrossOrigin(origins = "http://localhost:4200")
public class LikeController {
	
	@Autowired
	LikesService likesService;
	
	@PostMapping(value = "/{userId}/{postId}")
	public ResponseEntity<Boolean> likeODeslikeAPost(@PathVariable long userId,@PathVariable  long postId) {
		
		
		boolean val= likesService.likePost(userId, postId);
		
		return new ResponseEntity<Boolean>(val,HttpStatus.OK);
	}

}
