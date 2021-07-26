package com.demo.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.user.repositories.GreetingDBServer;
import com.demo.user.utils.Today;

@Service
public class GreetingService {

	@Autowired
	private GreetingDBServer server;
	
	@Autowired
	private Today today;
	
	public String greeting(String name) {
		return server.greeting(name) + " " + today.greet();
	}
}
