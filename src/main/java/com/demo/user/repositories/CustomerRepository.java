package com.demo.user.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.user.dataobjects.Customer;

@Repository
public class CustomerRepository {

	@Autowired
    private SessionFactory sessionFactory;
	
	public List<Customer> getAllCustomers() {
		
        Session session = this.sessionFactory.openSession();
        
        Query query = session.createQuery("select c from Customer c where c.firstName = :fn");
        query.setParameter("fn", "A1");
        return query.list();
    }
	
	public Customer getCustomer(Long id) {
		
        Session session = this.sessionFactory.openSession();
        
        Query query = session.createQuery("select c from Customer c where c.id = :identity");
        query.setParameter("identity", id);
        return (Customer)query.uniqueResult();
    }
	
	public Long createCustomer(Customer customer) {
		
        Session session = this.sessionFactory.openSession();
        
        Transaction tx = session.beginTransaction();
        Long id = (Long)session.save(customer);
        tx.commit();
        return id;
    }
}
