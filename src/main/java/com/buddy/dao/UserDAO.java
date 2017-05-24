package com.buddy.dao;

import java.util.ArrayList;
import java.util.List;


import com.buddy.model.User;


public interface UserDAO {

	public User insertNewUser(User user);
	public User getUser(String userID);
	
	public User DeleteUser(User user);

	public int UpdateInfo(User user);
	
}
