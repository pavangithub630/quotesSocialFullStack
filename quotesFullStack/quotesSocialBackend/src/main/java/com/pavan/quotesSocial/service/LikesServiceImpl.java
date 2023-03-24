package com.pavan.quotesSocial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pavan.quotesSocial.Enitity.Likes;
import com.pavan.quotesSocial.Enitity.Post;
import com.pavan.quotesSocial.Enitity.User;
import com.pavan.quotesSocial.exceptions.LikesException;
import com.pavan.quotesSocial.exceptions.UserException;
import com.pavan.quotesSocial.repository.LikesRepository;
import com.pavan.quotesSocial.repository.PostRepository;
import com.pavan.quotesSocial.repository.UserRepository;

@Service
public class LikesServiceImpl implements LikesService{

	@Autowired
	LikesRepository likesRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	PostRepository postRepository;
	@Autowired
	UserService userService;
	@Override
	public Likes likePost(long userid, long postId) {
		try {
			User user= userRepository.findById(userid).get();
			Post post= postRepository.findById(postId).get();
			boolean friendshipStatus= userService.checkFriendship(userid, post.getUser().getUserId());
			if(friendshipStatus) {
				Likes like = new Likes();
				like.setPost(post);
				like.setUser(user);
				List<Likes> postLikes= post.getLikes();
				postLikes.add(like);
				post.setLikes(postLikes);
				postRepository.save(post);
				return like;

			}
			else {
				throw new UserException("You cannot like posts apart from your friends list");
			}
						
		} catch (Exception e) {
			throw new LikesException(e.getMessage());
		}
	}
	
	
	
	

}
