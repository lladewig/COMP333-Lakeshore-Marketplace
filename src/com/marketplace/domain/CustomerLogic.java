package com.marketplace.domain;

import java.util.ArrayList;
import java.util.List;

import com.marketplace.dal.CustomerDAL;

public class CustomerLogic {
	
	public Customer getCustomer(int custID) {
		Customer customer = CustomerDAL.getCustomerByID(custID);
		return customer;
	}
	
	public List<Customer> getAllCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		customers = CustomerDAL.getAllCustomers();
		return customers;
	}
	
	public Customer deleteCustomer(int id) {
		Customer customer = CustomerDAL.deleteCustomer(id);
		return customer;
	}
	
	public Customer addCustomer(String firstName, String lastName, int phoneNumber) {
		return CustomerDAL.addCustomer(firstName, lastName, phoneNumber);
	}
	
	public Customer updateCustomerFirstName(String firstName, int id) {
		Customer customer = CustomerDAL.updateCustomerFirstName(firstName, id);
		return customer;
	}
	
	public Customer updateCustomerLastName(String lastName, int id) {
		Customer customer = CustomerDAL.updateCustomerLastName(lastName, id);
		return customer;
	}
	
	public Customer updateCustomerPhoneNumber(int phoneNumber, int id) {
		Customer customer = CustomerDAL.updateCustomerPhoneNumber(phoneNumber, id);
		return customer;
	}
	
	

}
