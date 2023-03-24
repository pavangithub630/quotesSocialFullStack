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
	public List<User> addFriend(long userId, long friendId) {
		
		User user= userRepository.findById(userId).get();
		System.out.println(user.getUserId());
		User friend = userRepository.findById(friendId).get();
		System.out.println(friend.getUserId());
		List<User> userFriends=user.getFriends();
		if (userFriends.contains(friend)) {
			
			throw new UserException("Friend Already added");
		}
		else {
			userFriends.add(friend);
			user.setFriends(userFriends);
					}
		return userRepository.save(user).getFriends();

		
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

	@Override
	public boolean checkFriendship(long userId, long friendId) {
	
		try {
			List<User> userFriends= userRepository.findById(userId).get().getFriends();
			User checkFriend= userRepository.findById(friendId).get();
			if (userFriends.contains(checkFriend)) {
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			throw new UserException(e.getMessage());
		}
	}

	
	
	
	
	

}
