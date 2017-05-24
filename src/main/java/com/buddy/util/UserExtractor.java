package com.buddy.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
//import static com.buddy.dao.UserDAOImpl.buddy_id;
import com.buddy.model.User;

public class UserExtractor implements ResultSetExtractor<User> {  
	  
	 public User extractData(ResultSet resultSet) throws SQLException,  DataAccessException 
	 {  
	  User user = new User();  
	  user.setUsername(resultSet.getString(1));  
	  user.setPassword(resultSet.getString(2));
	 
	  user.setName(resultSet.getString(3));
	  
	  user.setOperation_status(1);
	  
      
      
      
	  return user;  
	 }  
	
	}  