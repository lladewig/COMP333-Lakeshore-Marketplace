package com.marketplace.service.payment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "PaymentRequest")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class PaymentRequest {

	private int paymentID;
	private int customerID;
	private int cardNumber;
	private int securityCode;
	private String expirationDate;
	private int addressID;
	
	public PaymentRequest(){
		
	}
	
	public int getPaymentID() {
		return paymentID;
	}
	
	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}
	
	public int getCustomerID() {
		return customerID;
	}
	
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
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
	
	public int getAddressID() {
		return addressID;
	}
	
	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}
}
