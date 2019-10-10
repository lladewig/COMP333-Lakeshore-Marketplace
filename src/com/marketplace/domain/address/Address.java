package com.marketplace.domain.address;

import com.marketplace.domain.customer.Customer;

public class Address {
	private int addressID;
	private Customer customer;
	private String streetAddress;
	private String unitNumber;
	private int zipCode;
	private String city;
	private String state;
	
	public Address(Customer customer, String streetAddress, String unitNumber, int zipCode, String city, String state) {
		this.customer = customer;
		this.streetAddress = streetAddress;
		this.unitNumber = unitNumber;
		this.zipCode = zipCode;
		this.city = city;
		this.state = state;
	}
	
	public Address() {
	}
	
	
	public int getaddressID() {
		return addressID;
	}
	
	public void setaddressID(int newID) {
		addressID = newID;
	}
	
	public Customer getcustomer() {
		return customer;
	}
	
	public void setcustomer(Customer customer) {
		this.customer = customer;
	}
	
	public String getstreetAddress() {
		return streetAddress;
	}
	
	public void setstreetAddress(String newStreetAddr) {
		streetAddress = newStreetAddr;
	}
	
	public String getunitNumber() {
		return unitNumber;
	}
	
	public void setunitNumber(String newUnitNum) {
		unitNumber = newUnitNum;
	}
	
	public int getzipCode() {
		return zipCode;
	}
	
	public void setzipCode(int newZip) {
		zipCode = newZip;
	}
	
	public String getcity() {
		return city;
	}
	
	public void setcity(String newCity) {
		city = newCity;
	}

	public String getstate() {
		return state;
	}
	
	public void setstate(String newState) {
		state = newState;
	}
	
	

}
