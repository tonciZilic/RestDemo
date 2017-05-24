package com.buddy.services;

import java.util.ArrayList;


import com.buddy.model.User;

public interface UserService {
	
	public User insertNewUser(User user);
	public User getUser(String userID);
	
	public User DeleteUser(User user);

	public int UpdateInfo(User user);
	
}
