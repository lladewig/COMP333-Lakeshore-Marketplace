package com.marketplace.service.order;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "OrderRequest")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class OrderRequest {
	
	private int orderID;
	private int customerID;
	private int productID;
	private int paymentID;
	private String status;
	private int addressID;
	
	public OrderRequest(){
		
	}
	
	public int getOrderID() {
		return orderID;
	}
	
	public void setOrderID(int newID) {
		orderID = newID;
	}
	
	public int getCustomerID() {
		return customerID;
	}
	
	public void setCustomer(int customer) {
		this.customerID = customer;
	}
	
	public int getProductID() {
		return productID;
	}
	
	public void setProductID(int productID) {
		this.productID = productID;
	}
	
	public int getPaymentID() {
		return paymentID;
	}
	
	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String newStatus) {
		status = newStatus;
	}
	
	public int getAddressID() {
		return addressID;
	}
	
	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}
}
