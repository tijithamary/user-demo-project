package com.demo.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.user.services.HelloService;

@RestController
public class WelcomeController {

	@Autowired
	private HelloService hservice;
	
	@RequestMapping(path = "/hello", method = RequestMethod.GET)
	public String hello() {
		return hservice.hello("Guest");
	}
    
}