package com.demo.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.user.services.GreetingService;
import com.demo.user.services.HelloService;

@RestController
@RequestMapping(path = "demo")
public class DemoRestWebService {
	
	@Autowired
	private HelloService hservice;
	
	@Autowired 
	private GreetingService gservice;
	
	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public String home() {
		return "It's Home";
	}
	
	@RequestMapping(path = "/hello", method = RequestMethod.GET)
	public String hello(@RequestParam(name = "uname") String name) {
		return hservice.hello(name);
	}
	
	@RequestMapping(path = "/greeting", method = RequestMethod.GET)
	public String greeting(@RequestParam(name = "name") String name) {
		return gservice.greeting(name);
	}
	
}
