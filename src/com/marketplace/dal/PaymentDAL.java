package com.marketplace.dal;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.marketplace.domain.Payment;
import com.marketplace.domain.Customer;

public class PaymentDAL {
	
	public static Payment getPaymentByID(int id) {
		Payment payment = new Payment();
		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    payment = session.get(Payment.class, id);
	    
		session.close();
		return payment;
	}
	
	public static List<Payment> getAllPayments() {
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    Query query = session.createQuery("from Payment");
	    List<Payment> payments = query.list();
	    
		session.close();
		return payments;
	}
	
	public static List<Payment> getAllPaymentsForCustomer(int custID) {
		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    

	    Query query = session.createQuery("from Payment where customer_id=:custID").setParameter("custID", custID);
	    List<Payment> payments = query.list();
	    
		session.close();
		return payments;
	}
	
	
	public static Payment addPayment(int custID, int cardNumber, int securityCode, String expirationDate, String billingAddress) {	
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    Customer customer = session.get(Customer.class, custID);   
	    Payment Pay = new Payment(customer, cardNumber, securityCode, expirationDate, billingAddress);
	    
	    Transaction tx = session.beginTransaction();
	    session.save(Pay);
	    tx.commit();
	    session.close();
	    
	    return Pay;
	}
	
	public static Payment deletePayment(int id) {
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
	
	public static Payment updatePaymentCardNumber(int cardNumber, int id) {
		
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
	
	public static Payment updatePaymentSecurityCode(int securityCode, int id) {
		
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
	

	public static Payment updatePaymentExpirationDate(String expirationDate, int id) {
		
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
	
}
