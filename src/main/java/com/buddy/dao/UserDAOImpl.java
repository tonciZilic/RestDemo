package com.buddy.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import javax.sql.DataSource;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;



import com.buddy.model.User;

import com.buddy.util.UserRowMapper;


import com.fasterxml.jackson.databind.ObjectMapper;

@Repository("UserDAO")
public class UserDAOImpl  implements UserDAO{

	private JdbcTemplate jdbcTemplate;
	
	//public static String buddy_id="";
	
	
	@Autowired 
	public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	
	    
//	@Autowired
//	private CassandraOperations cassandraOperations;
//	    
		/*   @Autowired
	    protected CassandraOperations getCassandraTemplate() {
	        return cassandraTemplate;
	    }*/

	  /*  public CassandraOperations cassandraTemplate() throws Exception {
	        return new CassandraTemplate(().getObject());
	    }*/

	@Override
	public User insertNewUser(final User user) {
		
		
		
		
		
		User usr=getUser(user.getUsername());
		
		if(usr!=null)
		{
			
			System.out.println(usr.getPassword());
			usr.setOperation_status(0);
			return usr;
		}
		else
		{
	
        
        
	
		
		
	    
	    final String createUserSql = "INSERT INTO users"  
			    + "(username,password,name)"
			    + " VALUES (?,?,?)";  
		int id= 0;
		try{
			 KeyHolder keyHolder = new GeneratedKeyHolder();
		    	jdbcTemplate.update(
		    	    new PreparedStatementCreator() {
		    	    	   @Override
		    	        public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
		    	            PreparedStatement pst = con.prepareStatement(createUserSql);
		    	                pst.setString(1,user.getUsername());
		    	                pst.setString(2,user.getPassword());
		    	                pst.setString(3,user.name);
		    	              
		    	            return pst;
		     	        }
		    	    },
		    	    keyHolder);
		
		
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
		
		
	
		user.setOperation_status(1);
		 return user;
		}
	}

	@Override
	public User getUser(String userID) {
		 List<User> user = null;
		 User usr=null;
		  String sql = "select * from users where username = '"+userID+"'" ;  
		  
		  
		  
		  
		  
		  user = jdbcTemplate.query(sql, new UserRowMapper());
		
		  
		  if(user.size()>0)
		  return user.get(0);
		  else
			  return usr;
			  
	}

	@Override
	public int UpdateInfo(User user) {
		 String query="update users set name='"+user.name+"' where username='"+user.username+"'";  
				    
	
		 return jdbcTemplate.update(query);  
		
	}

	



	

		
		


	

		@Override
		public User DeleteUser(User user) {
		
			
			 String deleteStatement = "DELETE FROM users WHERE username=?";
			   
			 try
			    {
			        
				  jdbcTemplate.update(deleteStatement,user.getUsername());
				  
				  user.setOperation_status(1);
			    }
			    catch (RuntimeException runtimeException) 
			    {
			    	
			    	user.setOperation_status(0);
			    	
			        System.err.println("***NagiosHostDao::deleteObject, RuntimeException occurred, message follows.");
			        System.err.println(runtimeException);
			        throw runtimeException;
			    }
			 
			      
			       
			    
			    
			return user;
		
}
		
	



	
}
		