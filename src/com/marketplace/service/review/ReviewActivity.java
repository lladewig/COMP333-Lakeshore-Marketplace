package com.marketplace.service.review;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import com.marketplace.domain.review.ReviewLogic;
import com.marketplace.service.customer.CustomerRepresentation;
import com.marketplace.service.partner.PartnerRepresentation;
import com.marketplace.service.product.ProductRepresentation;
import com.marketplace.domain.review.Review;


public class ReviewActivity  {
	
	public ReviewRepresentation getReview(int reviewID) {
		ReviewLogic rLogic = new ReviewLogic();
		Review review = rLogic.getReviewByID(reviewID);
		
		ReviewRepresentation rRes = buildResponse(review);
		return rRes;
	}
	
	public List<ReviewRepresentation> getAllReviews(int productID, int offset, int limit) {
		ReviewLogic rLogic = new ReviewLogic();	
		List<Review> reviews = new ArrayList<Review>();
		List<ReviewRepresentation> rResponses = new ArrayList<ReviewRepresentation>();
		reviews = rLogic.getAllReviewForProduct(productID, offset, limit);
		
		Iterator<Review> it = reviews.iterator();
		while(it.hasNext()) {
	          Review review = (Review)it.next();
	          
	          ReviewRepresentation rRes = buildResponse(review);
	          rResponses.add(rRes);
        }
		return rResponses;
	}
	
	public ReviewRepresentation addReview(ReviewRequest rReq) {
		ReviewLogic rLogic = new ReviewLogic();
		Review review = rLogic.addReview(rReq.getCustomerID(), rReq.getReviewScore(), rReq.getProductID(), rReq.getReviewBody());
		
		ReviewRepresentation rRes = buildResponse(review);
		return rRes;
	}
	
	public ReviewRepresentation deleteReview(int reviewID) {
		ReviewLogic rLogic = new ReviewLogic();
		Review review = rLogic.deleteReview(reviewID);
		
		ReviewRepresentation rRes = buildResponse(review);
		return rRes;
	}
	
	private ReviewRepresentation buildResponse(Review review) {
		ReviewRepresentation rRes = new ReviewRepresentation();
		CustomerRepresentation cRes = new CustomerRepresentation();
		ProductRepresentation pRes = new ProductRepresentation();
		PartnerRepresentation parRes = new PartnerRepresentation();
		
		parRes.setPartnerID(review.getproduct().getpartner().getpartnerID());
		parRes.setPartnerName(review.getproduct().getpartner().getpartnerName());
		parRes.setPartnerType(review.getproduct().getpartner().getpartnerType());
		parRes.setPartnerDetails(review.getproduct().getpartner().getpartnerDetails());
		
		cRes.setCustomerID(review.getcustomer().getcustomerID());
		cRes.setFirstName(review.getcustomer().getfirstName());
		cRes.setLastName(review.getcustomer().getlastName());
		cRes.setPhoneNumber(review.getcustomer().getphoneNumber());
		
		pRes.setProductID(review.getproduct().getproductID());
		pRes.setProductName(review.getproduct().getproductName());
		pRes.setPartner(parRes);
		pRes.setProductCost(review.getproduct().getproductCost());
		pRes.setProductDescription(review.getproduct().getproductDescription());
		
		rRes.setReviewID(review.getreviewID());
		rRes.setCustomer(cRes);
		rRes.setProduct(pRes);
		rRes.setReviewScore(review.getReviewScore());
		rRes.setReviewBody(review.getReviewBody());	
		return rRes;
	}
	
}
