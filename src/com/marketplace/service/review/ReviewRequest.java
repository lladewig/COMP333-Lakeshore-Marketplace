package com.marketplace.service.review;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "ReviewRequest")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")

public class ReviewRequest  {
	
	private int reviewID;
	private int reviewScore;
	private Customer customer;
	private Product product;
	private String reviewBody;
	
	public ReviewRequest() {}
	
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
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getProduct() {
		return product;
	}
	public void setProdcut(String product) {
		this.product = product;
	}
	public String getReviewBody() {
		return reviewBody;
	}
	public void setReviewBody(String reviewBody) {
		this.reviewbody = reviewBody;
	}}
