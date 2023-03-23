package com.pavan.quotesSocial.service;

import java.util.List;

import com.pavan.quotesSocial.Enitity.User;
import com.pavan.quotesSocial.exceptions.UserException;

public interface UserService {
	
	public abstract User addUser(User user);
	public abstract List<User> getallusers();
	public abstract User updateUser(User user);
	public abstract User findUserByUserId(long userId) throws UserException;
	public abstract User addFriend(Long userId,Long friendId);
	public abstract User userSignIn(String email,String password);
}
