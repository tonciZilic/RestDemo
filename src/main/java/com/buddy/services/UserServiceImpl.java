package com.buddy.services;

import java.io.ByteArrayInputStream;
import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.buddy.dao.UserDAO;

import com.buddy.model.User;


@Service("UserService")
public class UserServiceImpl implements  UserService {

	@Autowired private 
	
	
	UserDAO userDAO;
	
	
	@Autowired
	private HttpServletRequest  request;
	@Override
	public User insertNewUser(User user) {
		return userDAO.insertNewUser(user);
	}
	@Override
	public User getUser(String userID) {
		
		User user = userDAO.getUser(userID);
		return user;
	}
	
	
	@Override
	public int UpdateInfo(User user) {
		

		//String root="";
		String root=  request.getSession().getServletContext().getRealPath("/")+"resources";
		
		System.out.println(root);
	   
		
	    	
			
			String path="";
			
			
				 
			
			
			
		
		return  userDAO.UpdateInfo(user);
	}
	

	@Override
	public User DeleteUser(User user) {
		
		return userDAO.DeleteUser(user); 
	}
	
	
	
	
	
	
	
	
	
	//private UserDAO userDAO;
	

}
