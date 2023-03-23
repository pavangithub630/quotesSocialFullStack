package com.pavan.quotesSocial.controller;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pavan.quotesSocial.DTO.PostDTO;
import com.pavan.quotesSocial.Enitity.Post;
import com.pavan.quotesSocial.repository.PostRepository;
import com.pavan.quotesSocial.service.PostService;

@RestController
@RequestMapping("post")
public class PostController {

	@Autowired
	PostService postService;
	
	@Autowired
	PostRepository postRepository;

	@PostMapping(value = "/add")
	public ResponseEntity<Post> addUser(@RequestBody PostDTO postDTO) {

		Post post = postService.addPost(postDTO);
		return new ResponseEntity<Post>(post, HttpStatus.OK);

	}
	
	@GetMapping("/getallquotes/{userId}")
	public ResponseEntity<List<Post>> getfriendsPosts(@PathVariable Long userId){
		
		List<Post>  posts = postService.getallPostsOfFriends(userId);
		
		return new ResponseEntity<List<Post>>(posts,HttpStatus.OK);
	}
	
	@GetMapping("/getmyquotes/{userId}")
	public ResponseEntity<List<Post>> getMyquotes(@PathVariable Long userId){
		
		List<Post>  posts = postService.getMyPosts(userId);
		
		List<Post> allpost= postRepository.findAll();
		
		for (Post post : allpost) {
			LocalDateTime localDateTime=LocalDateTime.of(post.getDate(),post.getTime());
			post.setLocalDateTime(localDateTime);
			postRepository.save(post);
		}
		
		return new ResponseEntity<List<Post>>(posts,HttpStatus.OK);
	}

}
