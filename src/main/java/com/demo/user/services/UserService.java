package com.demo.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.user.dataobjects.User;
import com.demo.user.repositories.UserJdbcServer;

@Service
public class UserService {

	@Autowired
	private UserJdbcServer userJdbc;
	
	public String login(String username, String password) throws Exception {
		
		if(username == null || username.length() < 4) {
			throw new Exception ("Username should be atleast 4 characters length");
		}
		
		if(password == null || password.length() < 4) {
			throw new Exception("Password should be atleast 4 characters length");
		}
		
		boolean success = userJdbc.login(username, password);
		
		if(!success) {
			return "Username or Password is Invalid, Please try again!!!";
		}
		
		return "Success";
	}


	public User findUser(String username) throws Exception {
		
		if(username == null || username.isEmpty()) {
			throw new Exception("Username is Empty. Plz enter the valid username.");
		}
		return userJdbc.findUser(username);
	}
	
	public User findUserByEmail(String emailid) {
		return userJdbc.findUserByEmail(emailid);
	}
	
	public String createUser(User user) {
		return userJdbc.createUser(user);
	}
}
