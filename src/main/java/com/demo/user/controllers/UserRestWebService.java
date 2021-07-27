package com.demo.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.user.dataobjects.User;
import com.demo.user.services.UserService;
import com.demo.user.utils.Today;

@RestController
@RequestMapping("users")
public class UserRestWebService {

	@Autowired
	private UserService service;
	
	@Autowired
	private Today today;
	
	public UserRestWebService() {
	}

	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public String home(@RequestParam(name = "name", required = false, defaultValue = "Guest") String name) {
		return name + ", " + today.greet() + " Welcome to User's Home";
	}
	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String login(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password) throws Exception {
		
		return service.login(username, password);
	}
	
	@RequestMapping(path = "/finduser", method = RequestMethod.GET)
	//@GetMapping("/finduser")
	public User findUser(@RequestParam(name = "username", required = false) String username) throws Exception {

		return service.findUser(username);
	}
	
	@GetMapping("/finduserbyemail")
	public User findUserByEmail(@RequestParam(name = "emailid", required = false) String emailid) throws Exception{
		return service.findUserByEmail(emailid);
	}
	
	@PostMapping("/createuser")
	public String createUser(@RequestParam(name = "username") String username, 
							 @RequestParam(name = "password") String password, 
							 @RequestParam(name = "firstname") String firstname, 
							 @RequestParam(name = "lastname") String lastname,
							 @RequestParam(name = "city") String city,
							 @RequestParam(name = "state") String state,
							 @RequestParam(name = "country") String country,
							 @RequestParam(name = "phone") String phone,
							 @RequestParam(name = "emailid") String emailid,
							 @RequestParam(name = "zipcode") String zipcode) throws Exception
	{
		if(username.isEmpty() || password.isEmpty() || firstname.isEmpty() || lastname.isEmpty()) {
			throw new Exception("Required fields cannot be empty!!!");
		}
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setCity(city);
		user.setState(state);
		user.setCountry(country);
		user.setPhone(phone);
		user.setEmailid(emailid);
		if(zipcode != null && !zipcode.isEmpty()) {
			user.setZipcode(Integer.parseInt(zipcode));
		}
		return service.createUser(user);
	}
}
