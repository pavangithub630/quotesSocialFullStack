package com.pavan.quotesSocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pavan.quotesSocial.Enitity.Likes;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Long> {

}
