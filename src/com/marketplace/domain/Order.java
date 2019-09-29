package com.marketplace.domain;

public class Order {
	
	private int orderID;
	private Customer customer;
	private Product product;
	private Payment payment;
	private String status;
	private Address shipmentAddress;

	public Order(Customer customer, Product product, Payment payment, String status, Address shipmentAddress) {
		this.customer = customer;
		this.product = product;
		this.payment = payment;
		this.status = status;
		this.shipmentAddress = shipmentAddress;
	}
	
	public Order() {
	}
	
	public int getorderID() {
		return orderID;
	}
	
	public void setorderID(int newID) {
		orderID = newID;
	}
	
	public Customer getcustomer() {
		return customer;
	}
	
	public void setcustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Payment getPayment() {
		return payment;
	}
	
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String newStatus) {
		status = newStatus;
	}
	
	public Address getshipmentAddress() {
		return shipmentAddress;
	}
	
	public void setshipmentAddress(Address newShipmentAddress) {
		shipmentAddress = newShipmentAddress;
	}
}
