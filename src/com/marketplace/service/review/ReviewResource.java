package com.marketplace.service.review;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


@Path("/reviewservice/")
public class ReviewResource {

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/reviews/{reviewID}")
	public ReviewRepresentation getReview(@PathParam("reviewID") int reviewID) {
		System.out.println("GET METHOD Request from Client to Get Reviews");
		ReviewActivity rActivity = new ReviewActivity();
		return rActivity.getReviewByID(reviewID);
		
	}
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/review")
	public List<ReviewRepresentation> getAllReviews(@QueryParam("offset") int offset, @QueryParam("limit") int limit) {
		if (limit == 0) {
			limit = 20;
		}
		System.out.println("GET METHOD Request from Client for Get All Reviews with offset " + offset + " and limit " + limit);
		ReviewActivity rActivity = new ReviewActivity();
		return rActivity.getAllReviews(offset, limit);
	}
	
	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/reviews")
	public ReviewsRepresentation rCustomer(ReviewRequest rReq) {
		System.out.println("POST METHOD Request from Client to Add Reviews");
		ReviewActivity rActivity = new ReviewActivity();
		return rActivity.rCustomer(rReq);
	}
	
	}
}
