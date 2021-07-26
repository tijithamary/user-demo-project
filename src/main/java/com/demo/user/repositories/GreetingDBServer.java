package com.demo.user.repositories;

import org.springframework.stereotype.Repository;

@Repository
public class GreetingDBServer {

	public String greeting(String name) {
		return  "Greeting " + name;
	}
}
