package com.demo.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.user.repositories.HelloDBServer;
import com.demo.user.utils.Today;

@Service
public class HelloService {

	@Autowired
	private HelloDBServer server;
	
	@Autowired
	private Today today;
	
	public String hello(String name) {
		return server.hello(name) + " " + today.greet();
	}
}
