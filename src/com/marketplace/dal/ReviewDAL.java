package com.marketplace.dal;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.marketplace.domain.Review;
import com.marketplace.domain.Product;
import com.marketplace.domain.Customer;


public class ReviewDAL {
	
	
	public static Review getReviewByID(int id) {
		Review review = new Review();
		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    review = session.get(Review.class, id);
	    
		session.close();
		return review;
	}
	
	public static List<Review> getAllReviewForCustomer(int custID) {
		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    

	    Query query = session.createQuery("from Review where customer_id=:custID").setParameter("custID", custID);
	    List<Review> reviews = query.list();
	    
		session.close();
		return reviews;
	}
	
	public static List<Review> getAllReviewForProduct(int productID) {
		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    

	    Query query = session.createQuery("from Review where product_id=:productID").setParameter("productID", productID);
	    List<Review> reviews = query.list();
	    
		session.close();
		return reviews;
	}
	
	public static Review addReview(int custID, int productID, String reviewBody) {	
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    Customer customer = session.get(Customer.class, custID);
	    Product product = session.get(Product.class, productID);
	    Review review = new Review(customer, product, reviewBody); 
	    
	    Transaction tx = session.beginTransaction();
	    session.save(review);
	    tx.commit(); 
	    session.close();
	  
	    return review;
	}
	
	public static Review deleteReview(int id){
		Review review = new Review();
		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    
	    review = session.get(Review.class, id);
	    if (review != null) {
	    	Transaction tx = session.beginTransaction();
	    	session.delete(review);
		    tx.commit();
	    } 
		session.close();
		return review;
	}

}
