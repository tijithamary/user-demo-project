package com.demo.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.user.dataobjects.User;
import com.demo.user.repositories.UserRepository;

@SpringBootTest
public class UserRepositoryTests {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void login() {
		boolean result = userRepository.login("vini", "vini1231");
		System.out.println(result);
	}
	
	//@Test
	public void createUser() {
		
		User user = new User();
		user.setUsername("aaa");
		user.setPassword("bbb");
		user.setFirstname("aaa");
		user.setLastname("bbb");
		user.setCity("Chennai");
		user.setState("TN");
		user.setCountry("India");
		user.setZipcode(898989);
		user.setPhone("9349302843");
		user.setEmailid("aaaa@gmail.com");
		int id = userRepository.createUser(user);
		System.out.println(id);
	}
	
}
