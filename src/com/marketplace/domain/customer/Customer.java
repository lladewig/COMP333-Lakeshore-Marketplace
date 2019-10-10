package com.marketplace.domain.customer;

public class Customer {
	
	private int customerID;
	private String firstName;
	private String lastName;
	private int phoneNumber;
	
	public Customer(String firstName, String lastName, int phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}
	
	public Customer() {
	}
	
	public int getcustomerID() {
		return customerID;
	}
	
	public void setcustomerID(int newID) {
		customerID = newID;
	}
	
	public String getfirstName() {
		return firstName;
	}
	
	public void setfirstName(String newFirstName) {
		firstName = newFirstName;
	}
	
	public String getlastName() {
		return lastName;
	}
	
	public void setlastName(String newLastName) {
		lastName = newLastName;
	}
	
	public int getphoneNumber() {
		return phoneNumber;
	}
	
	public void setphoneNumber(int newNumber) {
		phoneNumber = newNumber;
	}

}
