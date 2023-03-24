package com.pavan.quotesSocial.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pavan.quotesSocial.DTO.PostClientDto;
import com.pavan.quotesSocial.DTO.PostDTO;
import com.pavan.quotesSocial.Enitity.Post;
import com.pavan.quotesSocial.repository.PostRepository;
import com.pavan.quotesSocial.service.PostService;

@RestController
@RequestMapping("post")
@CrossOrigin(origins = "http://localhost:4200")
public class PostController {

	@Autowired
	PostService postService;
	
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	
	ModelMapper modelMapper;

	@PostMapping(value = "/add")
	public ResponseEntity<Post> addUser(@RequestBody PostDTO postDTO) {

		Post post = postService.addPost(postDTO);
		return new ResponseEntity<Post>(post, HttpStatus.OK);

	}
	
	@GetMapping("/getallquotes/{userId}")
	public ResponseEntity<List<PostClientDto>> getfriendsPosts(@PathVariable long userId){
		
		
		List<PostClientDto> myPostFeed= new ArrayList<PostClientDto>();
		
		List<Post>  posts = postService.getallPostsOfFriends(userId);
		
		List<Post> likedPosts=postService.getmylikedposts(userId);
		
		for (Post post1 : posts) {
			
			PostClientDto postClientDto = new PostClientDto();
			postClientDto.setDate(post1.getDate());
			postClientDto.setPostId(post1.getPostId());
			postClientDto.setQuote(post1.getQuote());
			postClientDto.setTime(post1.getTime());
			if(likedPosts.contains(post1)) {
				postClientDto.setLiked(true);
			}
			else {
				postClientDto.setLiked(false);
			}
			
			myPostFeed.add(postClientDto);
			
		}
		
		System.out.println(posts.size());
		System.out.println(likedPosts.size());
		
		return new ResponseEntity<List<PostClientDto>>(myPostFeed,HttpStatus.OK);
	}
	
	@GetMapping("/getmyquotes/{userId}")
	public ResponseEntity<List<Post>> getMyquotes(@PathVariable long userId){
		
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
