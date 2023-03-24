package com.pavan.quotesSocial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pavan.quotesSocial.Enitity.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
	
	@Query(value="select * from post t1 inner join user_friends t2 on t2.friends_user_id = t1.user_id  where user_user_id=?1 order by date desc,time desc", nativeQuery = true)
	public List<Post> getlatestPostsOfFriends(long userId);
	
	@Query(value="select t1.* from post t1 inner join user_friends t2 on t2.friends_user_id = t1.user_id  inner join likes on likes.post_id=t1.post_id  where likes.user_id=?1 order by date desc,time desc", nativeQuery = true)
	public List<Post> getUserLikedPosts(long userId);
}
