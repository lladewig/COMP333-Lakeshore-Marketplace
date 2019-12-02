package com.marketplace.service.address;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;

@CrossOriginResourceSharing(
		allowOrigins = {"http://localhost:8082"},
		allowCredentials = true,
		allowHeaders = {
					"'Accept': 'application/json'",
					"'Content-Type': 'application/json'"
		}
)	
@Path("/addressservice/")
public class AddressResource {
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/addresses/{addressID}")
	public AddressRepresentation getAddressByID(@PathParam("addressID") int addressID) {
		System.out.println("GET METHOD Request from Client for Get Address");
		AddressActivity addActivity = new AddressActivity();
		return addActivity.getAddressByID(addressID);
		
	}
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/addresses")
	public List<AddressRepresentation> getAllAddress(@QueryParam("offset") int offset, @QueryParam("limit") int limit){
		// won't allow a request for 0 addresses, so default to 5
		if (limit == 0) {
			limit = 5;
		}
		System.out.println("GET METHOD Request from Client for Get All Addresses with offset " + offset + " and limit " + limit);
		AddressActivity addActivity = new AddressActivity();
		return addActivity.getAllAddress(offset, limit);
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
	@Produces({"application/xml" , "application/json"})
	@Path("/addresses/{addressID}")
	public AddressRepresentation deleteAddress(@PathParam("addressID") int addressID) {
		System.out.println("DELETE METHOD Request from Client for Delete Address");
		AddressActivity addActivity = new AddressActivity();
		return addActivity.deleteAddress(addressID);
	}
}
