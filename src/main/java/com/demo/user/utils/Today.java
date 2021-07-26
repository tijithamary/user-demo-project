package com.demo.user.utils;

import java.util.Calendar;

import org.springframework.stereotype.Component;

@Component
public class Today {
	
	public String greet() {
		
		Calendar calendar = Calendar.getInstance();
		
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		
		if (hour >= 0 && hour < 12) {
			return "Good Morning !!!";
		}
		else if (hour >= 12 && hour < 4) {
			return "Good AfterNoon !!!";
		}
		else if (hour >= 4 && hour < 7) {
			return "Good Evening !!!";
		}
		else {
			return "Good Night !!!";
		}
	}
	
}
