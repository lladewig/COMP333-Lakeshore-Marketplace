package com.marketplace.service.review;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.marketplace.service.customer.CustomerRepresentation;
import com.marketplace.service.link.LinkRepresentation;
import com.marketplace.service.product.ProductRepresentation;



@XmlRootElement(name = "Review")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class ReviewRepresentation extends LinkRepresentation {
	
	
	private int reviewID;
	private int reviewScore;
	private CustomerRepresentation customer;
	private ProductRepresentation product;
	private String reviewBody;
	
	public ReviewRepresentation() {}
	
	public int getReviewID() {
		return reviewID;
	}
	public void setReviewID(int reviewID) {
		this.reviewID = reviewID;
		
	}
	public int getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}
	
	public CustomerRepresentation getCustomer() {
		return customer;
	}
	
	public void setCustomer(CustomerRepresentation customer) {
		this.customer = customer;
	}
	
	public ProductRepresentation getProduct() {
		return product;
	}
	
	public void setProduct(ProductRepresentation product) {
		this.product = product;
	}
	public String getReviewBody() {
		return reviewBody;
	}
	public void setReviewBody(String reviewBody) {
		this.reviewBody = reviewBody;
	}
}
