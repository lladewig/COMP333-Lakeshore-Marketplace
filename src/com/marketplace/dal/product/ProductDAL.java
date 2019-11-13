package com.marketplace.dal.product;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.marketplace.domain.partner.Partner;
import com.marketplace.domain.product.Product;

public class ProductDAL {

	
	public Product getProductByID(int id) {
		Product product = new Product();
		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    product = session.get(Product.class, id);
	    
		session.close();
		return product;
	}
	
	public List<Product> getAllProducts(int offset, int limit) {
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    

	    Query query = session.createQuery("from Product").setFirstResult(offset).setMaxResults(limit);
	    List<Product> products = query.list();
	    
		session.close();
		return products;
	}
	
	public List<Product> getAllProductsByPartner(int partnerID){
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    

	    Query query = session.createQuery("from Product where partner_id=:partnerID").setParameter("partnerID", partnerID);
	    List<Product> products = query.list();
	    
		session.close();
		return products;
	}
	
	public Product addProduct(Partner partner, String productName, String productDescription, double cost) {	
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    Product product = new Product(partner, productName, productDescription, cost);
	    
	    Transaction tx = session.beginTransaction();
	    session.save(product); 
	    tx.commit();
	    session.close(); 
	  
	    return product;
	}
	
	public Product deleteProduct(int id){
		Product product = new Product();
		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    
	    product = session.get(Product.class, id);
	    if (product != null) {
	    	Transaction tx = session.beginTransaction();
	    	session.delete(product);
		    tx.commit();
	    } 
		session.close();
		return product;
	}
	
	public Product updateCost(int productID, double newCost) {
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    Product product = session.get(Product.class, productID);
	    if (product != null) {
	    	product.setproductCost(newCost);
	    	Transaction tx = session.beginTransaction();
	    	session.save(product);
		    tx.commit();
	    } 
	    session.close();
	    
	    return product;
	}
	
}
