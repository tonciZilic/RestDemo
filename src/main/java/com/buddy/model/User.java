package com.buddy.model;

import java.sql.Date;



public class User {
	public String username,password,name;
	int operation_status;

	public int getOperation_status() {
		return operation_status;
	}

	public void setOperation_status(int operation_status) {
		this.operation_status = operation_status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	 
	
	
	
}