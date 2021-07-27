package com.demo.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.user.repositories.GreetingServer;
import com.demo.user.utils.Today;

@Service
public class GreetingService {

	@Autowired
	private GreetingServer greetServer;
	
	@Autowired
	private Today today;
	
	public String greeting(String name) {
		return greetServer.greeting(name) + " " + today.greet();
	}
}
