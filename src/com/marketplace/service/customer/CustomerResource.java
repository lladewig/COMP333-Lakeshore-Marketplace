package com.marketplace.service.customer;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;

import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;

import com.marketplace.service.customer.CustomerRepresentation;


@Path("/customerservice/")
public class CustomerResource {
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/customers/{customerID}")
	public CustomerRepresentation getCustomer(@PathParam("customerID") int customerID) {
		System.out.println("GET METHOD Request from Client for Customer with ID " + customerID );
		CustomerActivity cActivity = new CustomerActivity();
		return cActivity.getCustomer(customerID);
	}
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/customers")
	public List<CustomerRepresentation> getAllCustomers(@QueryParam("offset") int offset, @QueryParam("limit") int limit) {
		// won't allow a request for 0 addresses, so default to 5
		if (limit == 0) {
			limit = 5;
		}
		System.out.println("GET METHOD Request from Client for Get All Customers with offset " + offset + " and limit " + limit);
		CustomerActivity cActivity = new CustomerActivity();
		return cActivity.getAllCustomers(offset, limit);
	}
	
	@POST
	@Consumes({"application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/customers")
	public CustomerRepresentation addCustomer(CustomerRequest cReq) {
		System.out.println("POST METHOD Request from Client for Add Customer");
		System.out.println(cReq);
		CustomerActivity cActivity = new CustomerActivity();
		return cActivity.addCustomer(cReq);
	}
	
	
	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/customers/{customerID}")
	public CustomerRepresentation deleteCustomer(@PathParam("customerID") int customerID) {
		System.out.println("DELETE METHOD Request from Client for Delete Customer");
		CustomerActivity cActivity = new CustomerActivity();
		return cActivity.deleteCustomer(customerID);
	}
	
	@PUT
	@Produces({"application/xml" , "application/json"})
	@Path("/customers/first")
	public CustomerRepresentation updateCustomerFirstName(CustomerRequest cReq) {
		System.out.println("POST METHOD Request from Client for Update Customer First Name");
		CustomerActivity cActivity = new CustomerActivity();
		return cActivity.updateCustomerFirstName(cReq);
	}
	
	@PUT
	@Produces({"application/xml" , "application/json"})
	@Path("/customer/last")
	public CustomerRepresentation updateCustomerLastName(CustomerRequest cReq) {
		System.out.println("POST METHOD Request from Client for Update Customer Last Name");
		CustomerActivity cActivity = new CustomerActivity();
		return cActivity.updateCustomerLastName(cReq);
	}
	
	
	@PUT
	@Produces({"application/xml" , "application/json"})
	@Path("/customer/phone")
	public CustomerRepresentation updateCustomerPhoneNumber(CustomerRequest cReq) {
		System.out.println("POST METHOD Request from Client for Update Customer Phone Number");
		CustomerActivity cActivity = new CustomerActivity();
		return cActivity.updateCustomerPhoneNumber(cReq);
	}
}
