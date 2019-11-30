package com.marketplace.service.customer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.marketplace.domain.customer.Customer;
import com.marketplace.domain.customer.CustomerLogic;
import com.marketplace.service.link.Link;

public class CustomerActivity {
	
	
	public CustomerRepresentation getCustomer(int customerID) {
		CustomerLogic custLogic = new CustomerLogic();
		Customer customer = custLogic.getCustomer(customerID);
		
		Link delCustomer = new Link("deleteCustomer", 
				"http://localhost:8081/customerservice/customers/" + customer.getcustomerID(), "null");	
		Link updateCustomerFirst = new Link("updateCustomerFirstName", 
				"http://localhost:8081/customerservice/customers/first", "application/xml");	
		Link updateCustLast = new Link("updateCustomerLastName", 
				"http://localhost:8081/customerservice/customers/last", "application/xml");
		Link updateCustPhone = new Link("updateCustomerPhoneNumber", 
				"http://localhost:8081/customerservice/customers/phone", "application/xml");
		CustomerRepresentation cRes = buildResponse(customer, delCustomer, updateCustomerFirst, updateCustLast, updateCustPhone);
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
          Link getAllAddresses = new Link("getAllAddress", "http://localhost:8081/addressservice/addresses", "null");
          Link getAllOrders = new Link("getAllOrders", "http://localhost:8081/orderservice/orders", "null");
          Link getAllPartners = new Link("getAllPartners", "http://localhost:8081/partnerservice/partners", "null");
          Link getAllPayments = new Link("getAllPayments", "http://localhost:8081/paymentservice/payments", "null");
          Link getAllProducts = new Link("getAllProducts", "http://localhost:8081/productservice/products", "null");
          CustomerRepresentation cRes = buildResponse(customer, getAllAddresses, getAllOrders, getAllPartners, getAllPayments, getAllProducts);
          cResponses.add(cRes);
        }
		return cResponses;
	}
	
	public CustomerRepresentation addCustomer(CustomerRequest cReq) {
		CustomerLogic custLogic = new CustomerLogic();
		Customer customer = custLogic.addCustomer(cReq.getFirstName(), cReq.getLastName(), cReq.getPhoneNumber());
		Link address = new Link("addAddress", 
				"http://localhost:8081/addressservice/addresses", "application/xml");	
		Link delCustomer = new Link("deleteCustomer", 
				"http://localhost:8081/customerservice/customers/" + customer.getcustomerID(), "null");	
		Link updateCustomerFirst = new Link("updateCustomerFirstName", 
				"http://localhost:8081/customerservice/customers/first", "application/xml");	
		Link updateCustLast = new Link("updateCustomerLastName", 
				"http://localhost:8081/customerservice/customers/last", "application/xml");
		Link updateCustPhone = new Link("updateCustomerPhoneNumber", 
				"http://localhost:8081/customerservice/customers/phone", "application/xml");
		Link addCustomer = new Link("addCustomer", 
				"http://localhost:8081/customerservice/customers", "application/xml");
		CustomerRepresentation cRes = buildResponse(customer, address,delCustomer,updateCustomerFirst,updateCustLast,updateCustPhone,addCustomer);
		return cRes;
	}
	
	public CustomerRepresentation deleteCustomer(int customerID) {
		CustomerLogic custLogic = new CustomerLogic();
		Customer customer = custLogic.deleteCustomer(customerID);
		Link addCustomer = new Link("addCustomer", 
				"http://localhost:8081/customerservice/customers", "application/xml");
		CustomerRepresentation cRes = buildResponse(customer, addCustomer);
		return cRes;
	}
	
	public CustomerRepresentation updateCustomerFirstName(CustomerRequest cReq) {
		CustomerLogic custLogic = new CustomerLogic();
		Customer customer = custLogic.updateCustomerFirstName(cReq.getFirstName(), cReq.getCustomerID());
		Link delCustomer = new Link("deleteCustomer", 
				"http://localhost:8081/customerservice/customers/" + customer.getcustomerID(), "null");	
		Link updateCustLast = new Link("updateCustomerLastName", 
				"http://localhost:8081/customerservice/customers/last", "application/xml");
		Link updateCustPhone = new Link("updateCustomerPhoneNumber", 
				"http://localhost:8081/customerservice/customers/phone", "application/xml");
		Link addCustomer = new Link("addCustomer", 
				"http://localhost:8081/customerservice/customers", "application/xml");
		CustomerRepresentation cRes = buildResponse(customer, delCustomer, updateCustLast, updateCustPhone, addCustomer);
		return cRes;
	}
	
	public CustomerRepresentation updateCustomerLastName(CustomerRequest cReq) {
		CustomerLogic custLogic = new CustomerLogic();
		Customer customer = custLogic.updateCustomerLastName(cReq.getLastName(), cReq.getCustomerID());
		Link delCustomer = new Link("deleteCustomer", 
				"http://localhost:8081/customerservice/customers/" + customer.getcustomerID(), "null");	
		Link updateCustomerFirst = new Link("updateCustomerFirstName", 
				"http://localhost:8081/customerservice/customers/first", "application/xml");	
		Link updateCustPhone = new Link("updateCustomerPhoneNumber", 
				"http://localhost:8081/customerservice/customers/phone", "application/xml");
		Link addCustomer = new Link("addCustomer", 
				"http://localhost:8081/customerservice/customers", "application/xml");
		CustomerRepresentation cRes = buildResponse(customer, addCustomer, delCustomer, updateCustPhone, updateCustomerFirst);
		return cRes;
	}
	
	public CustomerRepresentation updateCustomerPhoneNumber(CustomerRequest cReq) {
		CustomerLogic custLogic = new CustomerLogic();
		Customer customer = custLogic.updateCustomerPhoneNumber(cReq.getPhoneNumber(), cReq.getCustomerID());
		Link delCustomer = new Link("deleteCustomer", 
				"http://localhost:8081/customerservice/customers/" + customer.getcustomerID(), "null");	
		Link updateCustomerFirst = new Link("updateCustomerFirstName", 
				"http://localhost:8081/customerservice/customers/first", "application/xml");	
		Link updateCustLast = new Link("updateCustomerLastName", 
				"http://localhost:8081/customerservice/customers/last", "application/xml");
		Link addCustomer = new Link("addCustomer", 
				"http://localhost:8081/customerservice/customers", "application/xml");
		CustomerRepresentation cRes = buildResponse(customer, delCustomer, updateCustomerFirst, updateCustLast, addCustomer);
		return cRes;
	}
	
	private CustomerRepresentation buildResponse(Customer customer, Link... links) {
		CustomerRepresentation cRes = new CustomerRepresentation();
		cRes.setCustomerID(customer.getcustomerID());
		cRes.setFirstName(customer.getfirstName());
		cRes.setLastName(customer.getlastName());
		cRes.setPhoneNumber(customer.getphoneNumber());
		
		
		cRes.setLinks(links);
		return cRes;
	}
}
