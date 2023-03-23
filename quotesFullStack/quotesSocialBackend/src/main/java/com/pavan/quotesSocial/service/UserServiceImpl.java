package com.pavan.quotesSocial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pavan.quotesSocial.Enitity.User;
import com.pavan.quotesSocial.exceptions.UserException;
import com.pavan.quotesSocial.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User addUser(User user) {
		try {
			user.setActive(true);
			 User user2= userRepository.save(user);
			 return user2;
			 
		} catch (Exception e) {
			throw new UserException(e.getLocalizedMessage());
		} 
		
	}

	@Override
	public List<User> getallusers() {
		return userRepository.findAll();
	}

	@Override
	public User updateUser(User user) {
		try {
			return userRepository.save(user);
		} catch (Exception e) {
			throw new UserException(e.getMessage());
		}
		
	}

	@Override
	public User findUserByUserId(long userId)throws UserException {
		User user= userRepository.findById(userId).orElseThrow(()-> new UserException("User with that user id did not found"));
		return user;
	}

	@Override
	public User addFriend(Long userId, Long friendId) {
		
		User user= userRepository.findById(userId).get();
		
		List<Long> frindIds= user.getFriendIds();
		frindIds.add(friendId);
		System.out.println(frindIds.size());
		user.setFriendIds(frindIds);
		return userRepository.save(user);
	}

	@Override
	public User userSignIn(String email, String password) {
		System.out.println(email);
	try {
		User user = userRepository.findByEmail(email);
		
			if(user.getPassword().equals(password)) {
				return user;
			}
			
			else {
				throw new UserException("Password you have enter did not matched");
			}
		
	} catch (Exception e) {
		throw new UserException("Pleach chek your email id");
	}
	
	
		
	}

	
	
	
	
	

}
