package com.marketplace.dal;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.marketplace.domain.Customer;
import com.marketplace.domain.Partner;

public class PartnerDAL {
	
	public static Partner getPartnerByID(int id) {
		Partner partner = new Partner();
		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    partner = session.get(Partner.class, id);
	    
		session.close();
		return partner;
	}
	
	public static List<Partner> getAllPartners() {
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    

	    Query query = session.createQuery("from Partner");
	    List<Partner> partners = query.list();
	    
		session.close();
		return partners;
	}
	
	public static Partner addPartner(String partnerName, String partnerType, String partnerDetails) {	
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    Partner partner = new Partner(partnerName, partnerType, partnerDetails); 
	    
	    Transaction tx = session.beginTransaction();
	    session.save(partner);
	    tx.commit(); 
	    session.close(); 
	  
	    return partner;
	}
	
	public static Partner deletePartner(int id){
		Partner partner = new Partner();
		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    
	    partner = session.get(Partner.class, id);
	    if (partner != null) {
	    	Transaction tx = session.beginTransaction();
	    	session.delete(partner);
		    tx.commit();
	    } 
		session.close();
		return partner;
	}
	
	public static Partner updatePartnerName(int partnerID, String newName) {
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    Partner partner = session.get(Partner.class, partnerID);
	    if (partner != null) {
	    	partner.setpartnerName(newName);
	    	Transaction tx = session.beginTransaction();
	    	session.save(partner);
		    tx.commit();
	    } 
	    session.close();
	    
	    return partner;
	}
	
	public static Partner updatePartnerDetails(int partnerID, String newDetails) {
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    Partner partner = session.get(Partner.class, partnerID);
	    if (partner != null) {
	    	partner.setpartnerDetails(newDetails);
	    	Transaction tx = session.beginTransaction();
	    	session.save(partner);
		    tx.commit();
	    } 
	    session.close();
	    
	    return partner;
	}

}
