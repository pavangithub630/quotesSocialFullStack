package com.pavan.quotesSocial.service;

import java.util.List;

import com.pavan.quotesSocial.DTO.PostDTO;
import com.pavan.quotesSocial.Enitity.Post;
import com.pavan.quotesSocial.exceptions.PostExeption;


public interface PostService {
	
	public abstract Post addPost(PostDTO post);
	public abstract List<Post> getAllPotsts();
	public abstract Post updatePost(Post post);
	public abstract Post findPostbyPostId(long postId) throws PostExeption;
	public abstract List<Post> getallPostsOfFriends(Long userId);
	public abstract List<Post> getMyPosts(Long useId);
}
