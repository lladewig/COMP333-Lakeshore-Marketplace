package com.marketplace.service.review;

import java.util.ArrayList;


public class ReviewActivity {
	
	public ReviewRepresentation getReview(int reviewID) {
		ReviewLogic rLogic = new ReviewLogic();
		Review review = rLogic.getReview(reviewID);
		
		ReviewRepresentation rRes = new ReviewRepresentation();
		rRes.setreviewID(review.getreviewID());
		rRes.setcustomer(review.getcustomer());
		rRes.setproduct(review.getproduct());
		rRes.setReviewScore(review.getReviewScore());
		rRes.setReviewBody(review.getReviewBody());	
		return rRes;
	}
	
	public List<ReviewRepresentation> getAllReviews(int offset, int limit) {
		ReviewLogic rLogic = new ReviewLogic();	
		List<Review> reviews = new ArrayList<Review>();
		List<ReviewRepresentation> rResponses = new ArrayList<ReviewRepresentation>();
		reviews = rLogic.getAllReviews(offset, limit);
		
		Iterator<Review> it = reviews.iterator();
		while(it.hasNext()) {
          Review review = (Review)it.next();
          
          ReviewRepresentation rRes = new ReviewRepresentation();
  		  rRes.setreviewID(review.getreviewID());
  		  rRes.setcustomer(review.getcustomer());
  		  rRes.setproduct(review.getproduct());
  		  rRes.setReviewScore(review.getReviewScore());
  		  rRes.setReviewBody(review.getReviewBody());	
  	
          
          rResponses.add(rRes);
        }
		return rResponses;
	}
	
	public ReviewRepresentation addReview(ReviewRequest rReq) {
		ReviewLogic rLogic = new ReviewLogic();
		Review review = rLogic.addReview(rReq.getcustomer(), rReq.getproduct(), rReq.getReviewScore, rReq.getReviewBody());
		
		ReviewRepresentation rRes = new ReviewRepresentation();
		rRes.setreviewID(review.getreviewID());
		rRes.setcustomer(review.getcustomer());
		rRes.setproduct(review.getproduct());
		rRes.setReviewScore(review.getReviewScore());
		rRes.setReviewBody(review.getReviewBody());	
		return rRes;
	}
	
	public ReviewRepresentation deleteReview(int reviewID) {
		ReviewLogic rLogic = new ReviewLogic();
		Review reivew = rLogic.deleteReview(reviewID);
		
		ReviewRepresentation rRes = new ReviewRepresentation();
		rRes.setreviewID(review.getreviewID());
		rRes.setcustomer(review.getcustomer());
		rRes.setproduct(review.getproduct());
		rRes.setReviewScore(review.getReviewScore());
		rRes.setReviewBody(review.getReviewBody());	
		return rRes;
	}
	
	public ReviewRepresentation updateReviewScore(ReviewRequest rReq) {
		ReviewLogic rLogic = new ReviewLogic();
		Review review = rLogic.updateReviewScore(rReq.getReviewScore(), rReq.getreviewID());
		
		ReviewRepresentation rRes = new ReviewRepresentation();
		rRes.setreviewID(review.getreviewID());
		rRes.setcustomer(review.getcustomer());
		rRes.setproduct(review.getproduct());
		rRes.setReviewScore(review.getReviewScore());
		rRes.setReviewBody(review.getReviewBody());	
		return rRes;
	}
	
}