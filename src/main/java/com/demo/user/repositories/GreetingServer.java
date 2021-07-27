package com.demo.user.repositories;

import org.springframework.stereotype.Repository;

@Repository
public class GreetingServer {

	public String greeting(String name) {
		return  "Greeting " + name;
	}
}
