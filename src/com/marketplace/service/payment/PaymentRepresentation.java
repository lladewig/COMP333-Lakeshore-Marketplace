package com.marketplace.service.payment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.marketplace.domain.address.Address;
import com.marketplace.domain.customer.Customer;
import com.marketplace.service.address.AddressRepresentation;

@XmlRootElement(name = "Payment")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class PaymentRepresentation {

	private int paymentID;
	private int cardNumber;
	private int securityCode;
	private String expirationDate;
	private AddressRepresentation address;
	
	public PaymentRepresentation(){
		
	}
	
	public int getPaymentOD() {
		return paymentID;
	}
	
	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}
	
	public int getCardNumber() {
		return cardNumber;
	}
	
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public int getSecurityCode() {
		return securityCode;
	}
	
	public void setSecurityCode(int securityCode) {
		this.securityCode = securityCode;
	}
	
	public String getExpirationDate() {
		return expirationDate;
	}
	
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	public AddressRepresentation getAddress() {
		return address;
	}
	
	public void setAddress(AddressRepresentation address) {
		this.address = address;
	}
}
