package com.demo.user;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.user.dataobjects.Customer;
import com.demo.user.repositories.CustomerRepository;

@SpringBootTest
class CustomerRepositoryTests {

	@Autowired
	private CustomerRepository customerRepository;
	
	//@Test
	public void createCustomer() {
		
		Customer c = new Customer();
		//c.setId(102L);
		c.setFirstName("A1");
		c.setLastName("A2");
		c.setCountry("INDIA");
		Long id = customerRepository.createCustomer(c);
		
		System.out.println(id);
	}
	
	@Test
	public void getCustomer() {
		
		Customer temp = customerRepository.getCustomer(5L);
		
		System.out.println(temp);
	}
	
	//@Test
	public void getAllCustomers() {
		
		List<Customer> temp = customerRepository.getAllCustomers();
		
		for (Customer customer : temp) {
			System.out.println(customer);
		}
	}
}
