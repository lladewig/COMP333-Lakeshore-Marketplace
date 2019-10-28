package com.marketplace.service.order;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.marketplace.domain.address.Address;
import com.marketplace.domain.customer.Customer;
import com.marketplace.domain.partner.Partner;
import com.marketplace.domain.payment.Payment;
import com.marketplace.domain.product.Product;

@XmlRootElement(name = "AddressRequest")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class OrderRequest {
	
	private int orderID;
	private Customer customer;
	private Product product;
	private Payment payment;
	private String status;
	private Address shipmentAddress;
	
	OrderRequest(){
		
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
