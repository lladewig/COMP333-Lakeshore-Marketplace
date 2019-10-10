package com.marketplace.domain.review;

import java.util.List;

import com.marketplace.dal.review.ReviewDAL;

public class ReviewLogic {
	
	public Review getReviewByID(int reviewID) {
		return ReviewDAL.getReviewByID(reviewID);
	}
	
	public List<Review> getAllReviewForCustomer(int custID){
		return ReviewDAL.getAllReviewForCustomer(custID);
	}

	public List<Review> getAllReviewForProduct(int productID){
		return ReviewDAL.getAllReviewForProduct(productID);
	}
	
	public Review addReview(int custID, int reviewScore, int productID, String reviewBody) {
		return ReviewDAL.addReview(custID, reviewScore, productID, reviewBody);
	}
	
	public static Review deleteReview(int reviewID) {
		return ReviewDAL.deleteReview(reviewID);
	}
}

