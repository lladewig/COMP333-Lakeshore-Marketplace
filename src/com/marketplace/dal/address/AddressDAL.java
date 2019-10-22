package com.marketplace.dal.address;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.marketplace.domain.address.Address;
import com.marketplace.domain.customer.Customer;

public class AddressDAL {
	
	
	public Address getAddressByID(int id) {
		Address address = new Address();
		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    address = session.get(Address.class, id);
	    
		session.close();
		return address;
	}
	
	public List<Address> getAllAddress(int offset, int limit) {
		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    

	    Query query = session.createQuery("from Address").setFirstResult(offset).setMaxResults(limit);
	    List<Address> addresses = query.list();
	    
		session.close();
		return addresses;
	}
	
	public Address addAddress(int custID, String streetAddress, String unitNumber, int zipCode, String city, String state) {	
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    Customer customer = session.get(Customer.class, custID); //get customer object from provided id
	    Address address = new Address(customer, streetAddress, unitNumber, zipCode, city, state); //create address object now
	    
	    Transaction tx = session.beginTransaction();
	    session.save(address); //save address to DB
	    tx.commit(); //commit the save
	    session.close(); //close the session
	  
	    return address;
	}
	
	public Address deleteAddress(int id){
		Address address = new Address();
		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    
	    address = session.get(Address.class, id);
	    if (address != null) {
	    	Transaction tx = session.beginTransaction();
	    	session.delete(address);
		    tx.commit();
	    } 
		session.close();
		return address;
	}

}
