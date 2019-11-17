package com.marketplace.service.order;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.marketplace.domain.address.Address;
import com.marketplace.domain.customer.Customer;
import com.marketplace.domain.payment.Payment;
import com.marketplace.domain.product.Product;
import com.marketplace.service.address.AddressRepresentation;
import com.marketplace.service.customer.CustomerRepresentation;
import com.marketplace.service.payment.PaymentRepresentation;
import com.marketplace.service.product.ProductRepresentation;

@XmlRootElement(name = "Order")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class OrderRepresentation {
	
	private int orderID;
	private CustomerRepresentation customer;
	private ProductRepresentation product;
	private PaymentRepresentation payment;
	private String status;
	private AddressRepresentation shipmentAddress;
	
	public OrderRepresentation(){
		
	}
	
	public int getorderID() {
		return orderID;
	}
	
	public void setorderID(int newID) {
		orderID = newID;
	}
	
	public CustomerRepresentation getcustomer() {
		return customer;
	}
	
	public void setcustomer(CustomerRepresentation customer) {
		this.customer = customer;
	}
	
	public ProductRepresentation getProduct() {
		return product;
	}
	
	public void setProduct(ProductRepresentation product) {
		this.product = product;
	}
	
	public PaymentRepresentation getPayment() {
		return payment;
	}
	
	public void setPayment(PaymentRepresentation payment) {
		this.payment = payment;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String newStatus) {
		status = newStatus;
	}
	
	public AddressRepresentation getshipmentAddress() {
		return shipmentAddress;
	}
	
	public void setshipmentAddress(AddressRepresentation newShipmentAddress) {
		shipmentAddress = newShipmentAddress;
	}
}
