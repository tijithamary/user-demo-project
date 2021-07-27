package com.demo.user;

import com.demo.user.dataobjects.User;
import com.demo.user.repositories.UserJdbcServer;

public class FindUserTest {

	public static void main(String[] args) {
		
		UserJdbcServer userdb = new UserJdbcServer();
		User user = userdb.findUser("vini");
		System.out.println(user);
	}
}
