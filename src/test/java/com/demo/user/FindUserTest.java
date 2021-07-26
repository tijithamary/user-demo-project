package com.demo.user;

import com.demo.user.dataobjects.User;
import com.demo.user.repositories.UserDBOperations;

public class FindUserTest {

	public static void main(String[] args) {
		
		UserDBOperations userdb = new UserDBOperations();
		User user = userdb.findUser("vini");
		System.out.println(user);
	}
}
