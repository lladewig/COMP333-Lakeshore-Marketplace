package com.marketplace.domain;

public class Review {
	private int reviewID;
	private Customer customer;
	private Product product;
	private String reviewBody;
	
	public Review(Customer customer, Product product, String reviewBody) {
		this.customer = customer;
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
	
	public String getReviewBody() {
		return reviewBody;
	}
	
	public void setReviewBody(String newRevBody) {
		reviewBody = newRevBody;
	}
	
}
