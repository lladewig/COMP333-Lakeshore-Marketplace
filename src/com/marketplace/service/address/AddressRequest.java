package com.marketplace.service.address;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "AddressRequest")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class AddressRequest {
	
	private int customerID;
	private String streetAddress;
	private String unitNumber;
	private int zipCode;
	private String city;
	private String state;
	
	public AddressRequest(){
		
	}
	
	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
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
