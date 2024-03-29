package com.marketplace.dal.order;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.marketplace.domain.address.Address;
import com.marketplace.domain.customer.Customer;
import com.marketplace.domain.order.Order;
import com.marketplace.domain.payment.Payment;
import com.marketplace.domain.product.Product;

public class OrderDAL {
	
	
	public Order getOrderByID(int id) {
		Order order = new Order();
		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    order = session.get(Order.class, id);
	    
		session.close();
		return order;
	}
	
	public List<Order> getAllOrders(int offset, int limit) {
		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    

	    Query query = session.createQuery("from Order").setFirstResult(offset).setMaxResults(limit);
	    List<Order> orders = query.list();
	    
		session.close();
		return orders;
	}
	
	public List<Order> getAllOrdersForCustomer(int custID, int offset, int limit) {
		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    

	    Query query = session.createQuery("from Order where customer_id=:custID").setParameter("custID", custID).setFirstResult(offset).setMaxResults(limit);
	    List<Order> orders = query.list();
	    
		session.close();
		return orders;
	}
	
	public Order updateOrderStatus(String reviewStatus, int id) {
		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    Order order = session.get(Order.class, id);
	    if (order != null) {
	    	order.setStatus(reviewStatus);
	    	Transaction tx = session.beginTransaction();
	    	session.save(order);
		    tx.commit();
	    } 
	    session.close();
	    
	    return order;
	}
	
	public Order updateOrderShipAddress(Address shipAddress, int id) {
		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    Order order = session.get(Order.class, id);
	    if (order != null) {
	    	order.setshipmentAddress(shipAddress);
	    	Transaction tx = session.beginTransaction();
	    	session.save(order);
		    tx.commit();
	    } 
	    session.close();
	    
	    return order;
	}
	
	public Order addOrder(int custID, int paymentID, int productID, String status, int addressID) {	
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    Customer customer = session.get(Customer.class, custID);
	    Payment payment = session.get(Payment.class, paymentID);
	    Product product = session.get(Product.class, productID);
	    Address address = session.get(Address.class, addressID);
	    Order order = new Order(customer, product, payment, status, address);
	    
	    Transaction tx = session.beginTransaction();
	    session.save(order);
	    tx.commit(); 
	    session.close(); 
	  
	    return order;
	}
	
	public Order deleteOrder(int id){
		Order order = new Order();
		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    
	    order = session.get(Order.class, id);
	    if (order != null) {
	    	Transaction tx = session.beginTransaction();
	    	session.delete(order);
		    tx.commit();
	    } 
		session.close();
		return order;
	}

}
