package com.marketplace.domain.review;

import java.util.List;

import com.marketplace.dal.review.ReviewDAL;

public class ReviewLogic {
	
	public Review getReviewByID(int reviewID) {
		ReviewDAL rd = new ReviewDAL();
		return rd.getReviewByID(reviewID);
	}
	
	public List<Review> getAllReviewForCustomer(int custID){
		ReviewDAL rd = new ReviewDAL();
		return rd.getAllReviewForCustomer(custID);
	}

	public List<Review> getAllReviewForProduct(int productID){
		ReviewDAL rd = new ReviewDAL();
		return rd.getAllReviewForProduct(productID);
	}
	
	public Review addReview(int custID, int reviewScore, int productID, String reviewBody) {
		ReviewDAL rd = new ReviewDAL();
		return rd.addReview(custID, reviewScore, productID, reviewBody);
	}
	
	public static Review deleteReview(int reviewID) {
		ReviewDAL rd = new ReviewDAL();
		return rd.deleteReview(reviewID);
	}
}

