package com.pavan.quotesSocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pavan.quotesSocial.Enitity.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
	
	
}
