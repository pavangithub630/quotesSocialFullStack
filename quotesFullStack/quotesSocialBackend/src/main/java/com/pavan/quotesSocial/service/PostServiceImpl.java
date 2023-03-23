package com.pavan.quotesSocial.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pavan.quotesSocial.DTO.PostDTO;
import com.pavan.quotesSocial.Enitity.Post;
import com.pavan.quotesSocial.Enitity.User;
import com.pavan.quotesSocial.exceptions.PostExeption;
import com.pavan.quotesSocial.repository.PostRepository;
import com.pavan.quotesSocial.repository.UserRepository;

@Service
public class PostServiceImpl implements PostService{

	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PostRepository postRepository;
	
	@Override
	public Post addPost(PostDTO postDto) {
	
		Post post= modelMapper.map(postDto, Post.class);
		User user=userRepository.findById(postDto.getUserId()).get();
		post.setDate(LocalDate.of(2019, Month.AUGUST, 16));
		post.setTime(LocalTime.now());
		post.setUser(user);
		try {
			return postRepository.save(post);
		} catch (Exception e) {
			throw new PostExeption(e.getMessage());
		}
		
	}

	@Override
	public List<Post> getAllPotsts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post updatePost(Post post) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post findPostbyPostId(long postId) throws PostExeption {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getallPostsOfFriends(Long userId) {
		
		List<Long> userIds= userRepository.findById(userId).get().getFriendIds();
		List<User> users= userRepository.findAllById(userIds);
		
		List<Post> posts= new ArrayList<Post>();
		
		for (User user : users) {
			
			for (Post post : user.getPosts()) {
				posts.add(post);
			}
		}
		
		 List<Post> sortedPosts = posts
	                .stream()
	                .sorted(Comparator.comparing(Post::getLocalDateTime))
	                .collect(Collectors.toList());
		

		
		return posts;
		
	}

	@Override
	public List<Post> getMyPosts(Long useId) {

		try {
			List<Post> posts = userRepository.findById(useId).get().getPosts();
			return posts;
		} catch (Exception e) {
			throw new PostExeption(e.getMessage());
		}
	}

	

}
