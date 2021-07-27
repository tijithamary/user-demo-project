package com.demo.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.user.repositories.HelloServer;
import com.demo.user.utils.Today;

@Service
public class HelloService {

	@Autowired
	private HelloServer helloServer;
	
	@Autowired
	private Today today;
	
	public String hello(String name) {
		
		return helloServer.hello(name) + " " + today.greet();
	}
}
