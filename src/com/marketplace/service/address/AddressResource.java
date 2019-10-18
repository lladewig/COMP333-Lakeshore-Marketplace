package com.marketplace.service.address;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/addressservice/")
public class AddressResource {
	
	@GET
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/addresses/{addressID}")
	public AddressRepresentation getAddressByID(@PathParam("addressID") int addressID) {
		System.out.println("GET METHOD Request from Client for Get Address");
		AddressActivity addActivity = new AddressActivity();
		return addActivity.getAddressByID(addressID);
		
	}
	
	@GET
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/addresses")
	public List<AddressRepresentation> getAllAddress(){
		System.out.println("GET METHOD Request from Client for Get All Addresses");
		AddressActivity addActivity = new AddressActivity();
		return addActivity.getAllAddress();
	}
	
	@POST
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/addresses")
	public AddressRepresentation addAddress(AddressRequest aReq) {
		System.out.println("POST METHOD Request from Client for Add Address");
		AddressActivity addActivity = new AddressActivity();
		return addActivity.addAddress(aReq);
	}
	
	@DELETE
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/addresses/{addressID}")
	public AddressRepresentation deleteAddress(@PathParam("addressID") int addressID) {
		System.out.println("DELETE METHOD Request from Client for Delete Address");
		AddressActivity addActivity = new AddressActivity();
		return addActivity.deleteAddress(addressID);
	}
}
