package com.marketplace.service.customer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.marketplace.domain.customer.Customer;
import com.marketplace.domain.customer.CustomerLogic;

public class CustomerActivity {
	
	
	public CustomerRepresentation getCustomer(int customerID) {
		CustomerLogic custLogic = new CustomerLogic();
		Customer customer = custLogic.getCustomer(customerID);
		
		CustomerRepresentation cRes = buildResponse(customer);
		return cRes;
	}
	
	
	public List<CustomerRepresentation> getAllCustomers(int offset, int limit) {
		CustomerLogic custLogic = new CustomerLogic();	
		List<Customer> customers = new ArrayList<Customer>();
		List<CustomerRepresentation> cResponses = new ArrayList<CustomerRepresentation>();
		customers = custLogic.getAllCustomers(offset, limit);
		
		Iterator<Customer> it = customers.iterator();
		while(it.hasNext()) {
          Customer customer = (Customer)it.next();
          
          CustomerRepresentation cRes = buildResponse(customer);
          cResponses.add(cRes);
        }
		return cResponses;
	}
	
	public CustomerRepresentation addCustomer(CustomerRequest cReq) {
		CustomerLogic custLogic = new CustomerLogic();
		Customer customer = custLogic.addCustomer(cReq.getFirstName(), cReq.getLastName(), cReq.getPhoneNumber());
		
		CustomerRepresentation cRes = buildResponse(customer);
		return cRes;
	}
	
	public CustomerRepresentation deleteCustomer(int customerID) {
		CustomerLogic custLogic = new CustomerLogic();
		Customer customer = custLogic.deleteCustomer(customerID);
		
		CustomerRepresentation cRes = buildResponse(customer);
		return cRes;
	}
	
	public CustomerRepresentation updateCustomerFirstName(CustomerRequest cReq) {
		CustomerLogic custLogic = new CustomerLogic();
		Customer customer = custLogic.updateCustomerFirstName(cReq.getFirstName(), cReq.getCustomerID());
		
		CustomerRepresentation cRes = buildResponse(customer);
		return cRes;
	}
	
	public CustomerRepresentation updateCustomerLastName(CustomerRequest cReq) {
		CustomerLogic custLogic = new CustomerLogic();
		Customer customer = custLogic.updateCustomerLastName(cReq.getLastName(), cReq.getCustomerID());
		
		CustomerRepresentation cRes = buildResponse(customer);
		return cRes;
	}
	
	public CustomerRepresentation updateCustomerPhoneNumber(CustomerRequest cReq) {
		CustomerLogic custLogic = new CustomerLogic();
		Customer customer = custLogic.updateCustomerPhoneNumber(cReq.getPhoneNumber(), cReq.getCustomerID());
		
		CustomerRepresentation cRes = buildResponse(customer);
		return cRes;
	}
	
	private CustomerRepresentation buildResponse(Customer customer) {
		CustomerRepresentation cRes = new CustomerRepresentation();
		cRes.setCustomerID(customer.getcustomerID());
		cRes.setFirstName(customer.getfirstName());
		cRes.setLastName(customer.getlastName());
		cRes.setPhoneNumber(customer.getphoneNumber());
		
		return cRes;
	}
}
