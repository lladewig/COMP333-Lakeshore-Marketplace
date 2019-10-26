package com.marketplace.service.partner;


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

@Path("/partnerservice/")
public class PartnerResource {
	
	@GET
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/partners/{partnerID}")
	public PartnerRepresentation getPartnerByID(@PathParam("partnerID") int partnerID) {
		System.out.println("GET METHOD Request from Client for Get Partner");
		PartnerActivity pActivity = new PartnerActivity();
		return pActivity.getPartnerByID(partnerID);
	}
	
	@GET
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/partners")
	public List<PartnerRepresentation> getAllPartners(@QueryParam("offset") int offset, @QueryParam("limit") int limit){
		// won't allow a request for 0 addresses, so default to 5
		if (limit == 0) {
			limit = 5;
		}
		System.out.println("GET METHOD Request from Client for Get All Partners with offset " + offset + " and limit "+ limit);
		PartnerActivity pActivity = new PartnerActivity();
		return pActivity.getAllPartners(offset, limit);
	}

	@POST
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/partners")
	public PartnerRepresentation addPartner(PartnerRequest pReq) {
		System.out.println("POST METHOD Request from Client for Add Partner");
		PartnerActivity pActivity = new PartnerActivity();
		return pActivity.addPartner(pReq);
	}
	
	@DELETE
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/partners/{partnerID}")
	public PartnerRepresentation deletePartner(@PathParam("partnerID") int partnerID) {
		System.out.println("DELETE METHOD Request from Client for Delete Partner");
		PartnerActivity pActivity = new PartnerActivity();
		return pActivity.deletePartner(partnerID);
	}
	
	@PUT
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/partners/name")
	public PartnerRepresentation updatePartnerName(PartnerRequest pReq) {
		System.out.println("PUT METHOD Request from Client for Update Partner Name");
		PartnerActivity pActivity = new PartnerActivity();
		return pActivity.updatePartnerName(pReq);
		
	}
	
	@PUT
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/partners/details")
	public PartnerRepresentation updatePartnerDetails(PartnerRequest pReq) {
		System.out.println("PUT METHOD Request from Client for Update Partner Details");
		PartnerActivity pActivity = new PartnerActivity();
		return pActivity.updatePartnerDetails(pReq);
	}

}
