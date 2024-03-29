package com.marketplace.service.review;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.marketplace.service.review.ReviewActivity;


@Path("/reviewservice/")
public class ReviewResource  {

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/reviews/{reviewID}")
	public ReviewRepresentation getReview(@PathParam("reviewID") int reviewID) {
		System.out.println("GET METHOD Request from Client to Get Reviews");
		ReviewActivity rActivity= new ReviewActivity();
		return rActivity.getReview(reviewID);
		
	}
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/reviews")
	public List<ReviewRepresentation> getAllReviews(@QueryParam("prodID") int productID, @QueryParam("offset") int offset, @QueryParam("limit") int limit) {
		if (limit == 0) {
			limit = 20;
		}
		System.out.println("GET METHOD Request from Client for Get All Reviews with offset " + offset + " and limit " + limit);
		ReviewActivity rActivity = new ReviewActivity();
		return rActivity.getAllReviews(productID, offset, limit);
	}
	
	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/reviews")
	public ReviewRepresentation addReview(ReviewRequest rReq) {
		System.out.println("POST METHOD Request from Client to Add Reviews");
		ReviewActivity rActivity = new ReviewActivity();
		return rActivity.addReview(rReq);
	}
	
	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/reviews")
	public ReviewRepresentation deleteReview(ReviewRequest rReq) {
		System.out.println("Delete METHOD Request from Client to Delete Review");
		ReviewActivity rActivity = new ReviewActivity();
		return rActivity.deleteReview(rReq.getReviewID());
	}
	
	
	}
	
	
