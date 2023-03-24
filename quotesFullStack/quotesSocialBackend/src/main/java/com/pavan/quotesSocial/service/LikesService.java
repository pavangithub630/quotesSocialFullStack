package com.pavan.quotesSocial.service;

import com.pavan.quotesSocial.Enitity.Likes;

public interface LikesService {
	
	public abstract Likes likePost(long userid,long postId);

}
