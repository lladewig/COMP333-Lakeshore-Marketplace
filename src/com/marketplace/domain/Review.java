package com.marketplace.domain;

public class Review {
	private int reviewID;
	private int reviewScore;
	private Customer customer;
	private Product product;
	private String reviewBody;
	
	public Review(Customer customer, int reviewScore, Product product, String reviewBody) {
		this.customer = customer;
		this.reviewScore = reviewScore;
		this.product = product;
		this.reviewBody = reviewBody;
	}
	
	public Review() {
	}
	
	
	public int getreviewID() {
		return reviewID;
	}
	
	public void setreviewID(int newID) {
		reviewID = newID;
	}
	
	public Customer getcustomer() {
		return customer;
	}
	
	public void setcustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Product getproduct() {
		return product;
	}
	
	public void setproduct(Product product) {
		this.product = product;
	}
	
	public int getReviewScore() {
		return reviewScore;
	}
	
	public void setReviewScore(int newreviewScore) {
		reviewScore = newreviewScore;
	}
	
	public String getReviewBody() {
		return reviewBody;
	}
	
	public void setReviewBody(String newRevBody) {
		reviewBody = newRevBody;
	}
	
}
