package com.marketplace.dal.customer;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.marketplace.domain.customer.Customer;

public class CustomerDAL {
	
	public static Customer getCustomerByID(int id) {
		Customer customer = new Customer();
		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    customer = session.get(Customer.class, id);
	    
		session.close();
		return customer;
	}
	
	public static List<Customer> getAllCustomers() {
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    Query query = session.createQuery("from Customer");
	    List<Customer> customers = query.list();
	    
		session.close();
		return customers;
	}
	
	public static Customer addCustomer(String firstName, String lastName, int phoneNumber) {
		Customer newCust = new Customer(firstName, lastName, phoneNumber);
		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	       
	    Transaction tx = session.beginTransaction();
	    session.save(newCust);
	    tx.commit();
	    session.close();
	    
	    return newCust;
	}
	
	public static Customer deleteCustomer(int id) {
		Customer customer = new Customer();
		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    
	    customer = session.get(Customer.class, id);
	    if (customer != null) {
	    	Transaction tx = session.beginTransaction();
	    	session.delete(customer);
		    tx.commit();
	    } 
		session.close();
		return customer;
	}
	
	public static Customer updateCustomerFirstName(String firstName, int id) {
		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    Customer customer = session.get(Customer.class, id);
	    if (customer != null) {
	    	customer.setfirstName(firstName);
	    	Transaction tx = session.beginTransaction();
	    	session.save(customer);
		    tx.commit();
	    } 
	    session.close();
	    
	    return customer;
	}
	
	public static Customer updateCustomerLastName(String lastName, int id) {
		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    Customer customer = session.get(Customer.class, id);
	    if (customer != null) {
	    	customer.setlastName(lastName);
	    	Transaction tx = session.beginTransaction();
	    	session.save(customer);
		    tx.commit();
	    } 
	    session.close();
	    
	    return customer;
	}
	

	public static Customer updateCustomerPhoneNumber(int phoneNumber, int id) {
	
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		
		Customer customer = session.get(Customer.class, id);
		if (customer != null) {
			customer.setphoneNumber(phoneNumber);
			Transaction tx = session.beginTransaction();
			session.save(customer);
		    tx.commit();
		} 
		session.close();
		
		return customer;
	}
	
}
