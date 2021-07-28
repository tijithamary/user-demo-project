package com.demo.user.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBConstants {

	@Value("${db.password}")
	public String PASSWORD;
	
	@Value("${db.url}")
	public String URL;
	 
	@Value("${db.username}")
	public String USERNAME;
}
