package com.pavan.quotesSocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pavan.quotesSocial.Enitity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	public  User findByEmail(String email);

}
