package com.pavan.quotesSocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pavan.quotesSocial.Enitity.Likes;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Long> {

	@Query(value = "select * from likes where post_id=?1 and user_id=?2",nativeQuery = true)
	public Likes getLike(long postId,long userId);
}
