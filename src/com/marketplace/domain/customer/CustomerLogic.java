package com.marketplace.domain.customer;

import java.util.ArrayList;
import java.util.List;

import com.marketplace.dal.customer.CustomerDAL;

public class CustomerLogic {
	
	public Customer getCustomer(int custID) {
		CustomerDAL cd = new CustomerDAL();
		Customer customer = cd.getCustomerByID(custID);
		return customer;
	}
	
	public List<Customer> getAllCustomers(int offset, int limit) {
		CustomerDAL cd = new CustomerDAL();
		List<Customer> customers = new ArrayList<Customer>();
		customers = cd.getAllCustomers(offset, limit);
		return customers;
	}
	
	public Customer deleteCustomer(int id) {
		CustomerDAL cd = new CustomerDAL();
		Customer customer = cd.deleteCustomer(id);
		return customer;
	}
	
	public Customer addCustomer(String firstName, String lastName, int phoneNumber) {
		CustomerDAL cd = new CustomerDAL();
		return cd.addCustomer(firstName, lastName, phoneNumber);
	}
	
	public Customer updateCustomerFirstName(String firstName, int id) {
		CustomerDAL cd = new CustomerDAL();
		Customer customer = cd.updateCustomerFirstName(firstName, id);
		return customer;
	}
	
	public Customer updateCustomerLastName(String lastName, int id) {
		CustomerDAL cd = new CustomerDAL();
		Customer customer = cd.updateCustomerLastName(lastName, id);
		return customer;
	}
	
	public Customer updateCustomerPhoneNumber(int phoneNumber, int id) {
		CustomerDAL cd = new CustomerDAL();
		Customer customer = cd.updateCustomerPhoneNumber(phoneNumber, id);
		return customer;
	}
	
	

}
