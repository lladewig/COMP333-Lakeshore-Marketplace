package com.marketplace.service.payment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.marketplace.domain.payment.Payment;
import com.marketplace.domain.payment.PaymentLogic;
import com.marketplace.service.address.AddressRepresentation;
import com.marketplace.service.customer.CustomerRepresentation;
import com.marketplace.service.link.Link;

public class PaymentActivity {
	
	public PaymentRepresentation getPayment(int paymentID) {
		PaymentLogic pLogic = new PaymentLogic();
		Payment payment = pLogic.getPayment(paymentID);
		
		PaymentRepresentation pRes = buildResponse(payment);
		return pRes;
	}
	
	public List<PaymentRepresentation> getAllPayments(int offset, int limit) {
		PaymentLogic pLogic = new PaymentLogic();	
		List<Payment> payments = new ArrayList<Payment>();
		List<PaymentRepresentation> pResponses = new ArrayList<PaymentRepresentation>();
		payments = pLogic.getAllPayments(offset, limit);
		
		Iterator<Payment> it = payments.iterator();
		while(it.hasNext()) {
			Payment payment = (Payment)it.next();
		  
			PaymentRepresentation pRes = buildResponse(payment);
			pResponses.add(pRes);
        }
		return pResponses;
	}
	
	public List<PaymentRepresentation> getAllPaymentsForCustomer(int customerID, int offset, int limit){

		PaymentLogic pLogic = new PaymentLogic();	
		List<Payment> payments = new ArrayList<Payment>();
		List<PaymentRepresentation> pResponses = new ArrayList<PaymentRepresentation>();
		payments = pLogic.getAllPaymentsForCustomer(customerID, offset, limit);
		
		Iterator<Payment> it = payments.iterator();
		while(it.hasNext()) {
          Payment payment = (Payment)it.next();
          
          PaymentRepresentation pRes = buildResponse(payment);
  			pResponses.add(pRes);
        }
		return pResponses;
	}
	
	public PaymentRepresentation addPayment(PaymentRequest pReq) {		
		PaymentLogic pLogic = new PaymentLogic();
		Payment payment = pLogic.addPayment(pReq.getCustomerID(), pReq.getCardNumber(), pReq.getSecurityCode(), pReq.getExpirationDate(), pReq.getAddressID());
		
		Link getAllProd = new Link("getAllProducts", 
				"http://localhost:8081/productservice/products?offset=0&limit=10", "null");	
		Link updatePaymentCardNum = new Link("updatePaymentCardNum", 
				"http://localhost:8081/paymentservice/payments/card", "application/xm");	
		Link updatePaymentExpir = new Link("updatePaymentCardExpiration", 
				"http://localhost:8081/paymentservice/payments/expiration", "application/xml");
		Link updatePaymentAddress = new Link("updatePaymentAddress", 
				"http://localhost:8081/paymentservice/payments/address", "application/xml");
		Link updatePaymentSecurityCode = new Link("updatePaymentSecurityCode", 
				"http://localhost:8081/paymentservice/payments/security", "application/xml");
		Link delPayment = new Link("delPayment", 
				"http://localhost:8081/paymentservice/payments/"+payment.getpaymentID(), "null");
		PaymentRepresentation pRes = buildResponse(payment, getAllProd,updatePaymentCardNum,updatePaymentExpir,updatePaymentAddress,updatePaymentSecurityCode, delPayment);
		return pRes;
	}
	
	public PaymentRepresentation deletePayment(int paymentID) {
		PaymentLogic pLogic = new PaymentLogic();
		Payment payment = pLogic.deletePayment(paymentID);
		
		PaymentRepresentation pRes = buildResponse(payment);
		return pRes;
	}
	
	public PaymentRepresentation updatePaymentCardNumber(PaymentRequest pReq) {
		PaymentLogic pLogic = new PaymentLogic();
		Payment payment = pLogic.updatePaymentCardNumber(pReq.getCardNumber(), pReq.getPaymentID());
		
		PaymentRepresentation pRes = buildResponse(payment);
		return pRes;
	}

	public PaymentRepresentation updatePaymentSecurityCode(PaymentRequest pReq) {
		PaymentLogic pLogic = new PaymentLogic();
		Payment payment = pLogic.updatePaymentSecurityCode(pReq.getSecurityCode(), pReq.getPaymentID());
		
		PaymentRepresentation pRes = buildResponse(payment);
		return pRes;
	}
	
	public PaymentRepresentation updatePaymentExpirationDate(PaymentRequest pReq) {		
		PaymentLogic pLogic = new PaymentLogic();
		Payment payment = pLogic.updatePaymentExpirationDate(pReq.getExpirationDate(), pReq.getPaymentID());
		
		PaymentRepresentation pRes = buildResponse(payment);
		return pRes;
	}
	
	public PaymentRepresentation updatePaymentAddress(PaymentRequest pReq) {
		PaymentLogic pLogic = new PaymentLogic();
		Payment payment = pLogic.updatePaymentAddress(pReq.getAddressID(), pReq.getPaymentID());
		
		PaymentRepresentation pRes = buildResponse(payment);
		return pRes;
	}
	
	private PaymentRepresentation buildResponse(Payment payment, Link...links) {
		PaymentRepresentation pRes = new PaymentRepresentation();
		AddressRepresentation aRes = new AddressRepresentation();
		CustomerRepresentation cRes = new CustomerRepresentation();
		
		cRes.setCustomerID(payment.getcustomer().getcustomerID());
		cRes.setFirstName(payment.getcustomer().getfirstName());
		cRes.setLastName(payment.getcustomer().getlastName());
		cRes.setPhoneNumber(payment.getcustomer().getphoneNumber());
		
		aRes.setAddressID(payment.getbillingAddress().getaddressID());
		aRes.setCity(payment.getbillingAddress().getcity());
		aRes.setCustomer(cRes);
		aRes.setState(payment.getbillingAddress().getstate());
		aRes.setStreetAddress(payment.getbillingAddress().getstreetAddress());
		aRes.setUnitNUmber(payment.getbillingAddress().getunitNumber());
		aRes.setZipCode(payment.getbillingAddress().getzipCode());
		
		pRes.setPaymentID(payment.getpaymentID());
		pRes.setCardNumber(payment.getcardNumber());
		pRes.setSecurityCode(payment.getsecurityCode());
		pRes.setExpirationDate(payment.getexpirationDate());
		pRes.setAddress(aRes);	
		pRes.setLinks(links);
		return pRes;
	}
}
