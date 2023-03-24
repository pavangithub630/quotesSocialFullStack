package com.pavan.quotesSocial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pavan.quotesSocial.Enitity.Likes;
import com.pavan.quotesSocial.service.LikesService;

@RestController
@RequestMapping(value = "/likes")
public class LikeController {
	
	@Autowired
	LikesService likesService;
	
	@PostMapping(value = "/{userId}/{postId}")
	public ResponseEntity<Likes> likeAPost(@PathVariable long userId,@PathVariable  long postId) {
		Likes like= likesService.likePost(userId, postId);
		
		return new ResponseEntity<Likes>(like,HttpStatus.OK);
	}

}
