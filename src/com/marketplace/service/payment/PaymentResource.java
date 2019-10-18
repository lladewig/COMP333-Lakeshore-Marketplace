package com.marketplace.service.payment;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/paymentservice/")
public class PaymentResource {
	
	@GET
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/payments/{paymentID}")
	public PaymentRepresentation getPayment(@PathParam("paymentID") int paymentID) {
		System.out.println("GET METHOD Request from Client for Get Payment");
		PaymentActivity pActivity = new PaymentActivity();
		return pActivity.getPayment(paymentID);
	}
	
	@GET
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/payments")
	public List<PaymentRepresentation> getAllPayments() {
		System.out.println("GET METHOD Request from Client for Get All Payments");
		PaymentActivity pActivity = new PaymentActivity();
		return pActivity.getAllPayments();
	}
	
	@GET
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/payments/customer/{customerID}")
	public List<PaymentRepresentation> getAllPaymentsForCustomer(@PathParam("customerID") int customerID){
		System.out.println("GET METHOD Request from Client for Get Payments for Customer");
		PaymentActivity pActivity = new PaymentActivity();
		return pActivity.getAllPaymentsForCustomer(customerID);
	}
	
	@POST
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/payments")
	public PaymentRepresentation addPayment(PaymentRequest pReq) {
		System.out.println("POST METHOD Request from Client for Add Payment");
		PaymentActivity pActivity = new PaymentActivity();
		return pActivity.addPayment(pReq);
	}
	
	@DELETE
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/payments/{paymentID}")
	public PaymentRepresentation deletePayment(@PathParam("paymentID") int paymentID) {
		System.out.println("DELETE METHOD Request from Client for Delete Payment");
		PaymentActivity pActivity = new PaymentActivity();
		return pActivity.deletePayment(paymentID);
	}
	
	@PUT
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/payments/card")
	public PaymentRepresentation updatePaymentCardNumber(PaymentRequest pReq) {
		System.out.println("PUT METHOD Request from Client for Update Payment Card Number");
		PaymentActivity pActivity = new PaymentActivity();
		return pActivity.updatePaymentCardNumber(pReq);
	}
	
	@PUT
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/payments/security")
	public PaymentRepresentation updatePaymentSecurityCode(PaymentRequest pReq) {
		System.out.println("PUT METHOD Request from Client for Update Payment Security Code");
		PaymentActivity pActivity = new PaymentActivity();
		return pActivity.updatePaymentSecurityCode(pReq);
	}
	
	@PUT
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/payments/expiration")
	public PaymentRepresentation updatePaymentExpirationDate(PaymentRequest pReq) {
		System.out.println("PUT METHOD Request from Client for Update Payment Expiration Date");
		PaymentActivity pActivity = new PaymentActivity();
		return pActivity.updatePaymentExpirationDate(pReq);
	}	
	
	@PUT
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/payments/address")
	public PaymentRepresentation updatePaymentAddress(PaymentRequest pReq) {
		System.out.println("PUT METHOD Request from Client for Update Payment Expiration Date");
		PaymentActivity pActivity = new PaymentActivity();
		return pActivity.updatePaymentAddress(pReq);
		
	}	

}
