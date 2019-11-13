package com.marketplace.service.address;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.marketplace.domain.customer.Customer;
import com.marketplace.service.customer.CustomerRepresentation;

@XmlRootElement(name = "Address")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class AddressRepresentation {

	
	private int addressID;
	private CustomerRepresentation customer;
	private String streetAddress;
	private String unitNumber;
	private int zipCode;
	private String city;
	private String state;
	
	public AddressRepresentation(){
		
	}
	
	public int getAddressID() {
		return addressID;
	}

	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}
	
	public CustomerRepresentation getCustomer() {
		return customer;
	}
	
	public void setCustomer(CustomerRepresentation customer) {
		this.customer = customer;
	}
	
	public String getStreetAddress() {
		return streetAddress;
	}
	
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	
	public String getUnitNumber() {
		return unitNumber;
	}
	
	public void setUnitNUmber(String unitNumber) {
		this.unitNumber = unitNumber;
	}
	
	public int getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
}
