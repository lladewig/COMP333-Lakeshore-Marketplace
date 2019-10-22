package com.marketplace.dal.payment;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.marketplace.domain.address.Address;
import com.marketplace.domain.customer.Customer;
import com.marketplace.domain.payment.Payment;

public class PaymentDAL {
	
	public Payment getPaymentByID(int id) {
		Payment payment = new Payment();
		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    payment = session.get(Payment.class, id);
	    
		session.close();
		return payment;
	}
	
	public List<Payment> getAllPayments(int offset, int limit) {
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    Query query = session.createQuery("from Payment").setFirstResult(offset).setMaxResults(limit);
	    List<Payment> payments = query.list();
	    
		session.close();
		return payments;
	}
	
	public List<Payment> getAllPaymentsForCustomer(int custID) {
		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    

	    Query query = session.createQuery("from Payment where customer_id=:custID").setParameter("custID", custID);
	    List<Payment> payments = query.list();
	    
		session.close();
		return payments;
	}
	
	
	public Payment addPayment(int custID, int cardNumber, int securityCode, String expirationDate, int billingAddressID) {	
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    Customer customer = session.get(Customer.class, custID);  
	    Address address = session.get(Address.class, billingAddressID);   
	    Payment Pay = new Payment(customer, cardNumber, securityCode, expirationDate, address);
	    
	    Transaction tx = session.beginTransaction();
	    session.save(Pay);
	    tx.commit();
	    session.close();
	    
	    return Pay;
	}
	
	public Payment deletePayment(int id) {
		Payment payment = new Payment();
		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    
	    payment = session.get(Payment.class, id);
	    if (payment != null) {
	    	Transaction tx = session.beginTransaction();
	    	session.delete(payment);
		    tx.commit();
	    } 
		session.close();
		return payment;
	}
	
	public Payment updatePaymentCardNumber(int cardNumber, int id) {
		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    Payment payment = session.get(Payment.class, id);
	    if (payment != null) {
	    	payment.setcardNumber(cardNumber);
	    	Transaction tx = session.beginTransaction();
	    	session.save(payment);
		    tx.commit();
	    } 
	    session.close();
	    
	    return payment;
	}
	
	public Payment updatePaymentSecurityCode(int securityCode, int id) {
		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    Payment payment = session.get(Payment.class, id);
	    if (payment != null) {
	    	payment.setsecurityCode(securityCode);
	    	Transaction tx = session.beginTransaction();
	    	session.save(payment);
		    tx.commit();
	    } 
	    session.close();
	    
	    return payment;
	}
	

	public Payment updatePaymentExpirationDate(String expirationDate, int id) {
		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    Payment payment = session.get(Payment.class, id);
	    if (payment != null) {
	    	payment.setexpirationDate(expirationDate);
	    	Transaction tx = session.beginTransaction();
	    	session.save(payment);
		    tx.commit();
	    } 
	    session.close();
	    
	    return payment;
	}
	
public Payment updatePaymentAddress(int addressID, int id) {
		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    Payment payment = session.get(Payment.class, id);
	    Address address = session.get(Address.class, addressID);
	    if (payment != null) {
	    	payment.setbillingAddress(address);
	    	Transaction tx = session.beginTransaction();
	    	session.save(payment);
		    tx.commit();
	    } 
	    session.close();
	    
	    return payment;
	}
	
}
