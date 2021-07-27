package com.demo.user.repositories;

import org.springframework.stereotype.Repository;

@Repository
public class HelloServer {

	public String hello(String name) {
		return  "Hello " + name;
	}
}
