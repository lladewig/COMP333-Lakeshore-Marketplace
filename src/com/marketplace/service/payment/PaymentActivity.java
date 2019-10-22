package com.marketplace.service.payment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.marketplace.domain.payment.Payment;
import com.marketplace.domain.payment.PaymentLogic;

public class PaymentActivity {
	
	public PaymentRepresentation getPayment(int paymentID) {
		PaymentLogic pLogic = new PaymentLogic();
		Payment payment = pLogic.getPayment(paymentID);
		
		PaymentRepresentation pRes = new PaymentRepresentation();
		pRes.setPaymentID(payment.getpaymentID());
		pRes.setCardNumber(payment.getcardNumber());
		pRes.setSecurityCode(payment.getsecurityCode());
		pRes.setExpirationDate(payment.getexpirationDate());
		pRes.setAddress(payment.getbillingAddress());	
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
		  
		  	PaymentRepresentation pRes = new PaymentRepresentation();
		  	pRes.setPaymentID(payment.getpaymentID());
			pRes.setCardNumber(payment.getcardNumber());
			pRes.setSecurityCode(payment.getsecurityCode());
			pRes.setExpirationDate(payment.getexpirationDate());
			pRes.setAddress(payment.getbillingAddress());
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
          
          	PaymentRepresentation pRes = new PaymentRepresentation();
          	pRes.setPaymentID(payment.getpaymentID());
  			pRes.setCardNumber(payment.getcardNumber());
  			pRes.setSecurityCode(payment.getsecurityCode());
  			pRes.setExpirationDate(payment.getexpirationDate());
  			pRes.setAddress(payment.getbillingAddress());
  			pResponses.add(pRes);
        }
		return pResponses;
	}
	
	public PaymentRepresentation addPayment(PaymentRequest pReq) {		
		PaymentLogic pLogic = new PaymentLogic();
		Payment payment = pLogic.addPayment(pReq.getCustomerID(), pReq.getCardNumber(), pReq.getSecurityCode(), pReq.getExpirationDate(), pReq.getAddressID());
		
		PaymentRepresentation pRes = new PaymentRepresentation();
		pRes.setPaymentID(payment.getpaymentID());
		pRes.setCardNumber(payment.getcardNumber());
		pRes.setSecurityCode(payment.getsecurityCode());
		pRes.setExpirationDate(payment.getexpirationDate());
		pRes.setAddress(payment.getbillingAddress());	
		return pRes;
	}
	
	public PaymentRepresentation deletePayment(int paymentID) {
		PaymentLogic pLogic = new PaymentLogic();
		Payment payment = pLogic.deletePayment(paymentID);
		
		PaymentRepresentation pRes = new PaymentRepresentation();
		pRes.setPaymentID(payment.getpaymentID());
		pRes.setCardNumber(payment.getcardNumber());
		pRes.setSecurityCode(payment.getsecurityCode());
		pRes.setExpirationDate(payment.getexpirationDate());
		pRes.setAddress(payment.getbillingAddress());	
		return pRes;
	}
	
	public PaymentRepresentation updatePaymentCardNumber(PaymentRequest pReq) {
		PaymentLogic pLogic = new PaymentLogic();
		Payment payment = pLogic.updatePaymentCardNumber(pReq.getCardNumber(), pReq.getPaymentID());
		
		PaymentRepresentation pRes = new PaymentRepresentation();
		pRes.setPaymentID(payment.getpaymentID());
		pRes.setCardNumber(payment.getcardNumber());
		pRes.setSecurityCode(payment.getsecurityCode());
		pRes.setExpirationDate(payment.getexpirationDate());
		pRes.setAddress(payment.getbillingAddress());	
		return pRes;
	}

	public PaymentRepresentation updatePaymentSecurityCode(PaymentRequest pReq) {
		PaymentLogic pLogic = new PaymentLogic();
		Payment payment = pLogic.updatePaymentSecurityCode(pReq.getSecurityCode(), pReq.getPaymentID());
		
		PaymentRepresentation pRes = new PaymentRepresentation();
		pRes.setPaymentID(payment.getpaymentID());
		pRes.setCardNumber(payment.getcardNumber());
		pRes.setSecurityCode(payment.getsecurityCode());
		pRes.setExpirationDate(payment.getexpirationDate());
		pRes.setAddress(payment.getbillingAddress());	
		return pRes;
	}
	
	public PaymentRepresentation updatePaymentExpirationDate(PaymentRequest pReq) {		
		PaymentLogic pLogic = new PaymentLogic();
		Payment payment = pLogic.updatePaymentExpirationDate(pReq.getExpirationDate(), pReq.getPaymentID());
		
		PaymentRepresentation pRes = new PaymentRepresentation();
		pRes.setPaymentID(payment.getpaymentID());
		pRes.setCardNumber(payment.getcardNumber());
		pRes.setSecurityCode(payment.getsecurityCode());
		pRes.setExpirationDate(payment.getexpirationDate());
		pRes.setAddress(payment.getbillingAddress());	
		return pRes;
	}
	
	public PaymentRepresentation updatePaymentAddress(PaymentRequest pReq) {
		PaymentLogic pLogic = new PaymentLogic();
		Payment payment = pLogic.updatePaymentAddress(pReq.getAddressID(), pReq.getPaymentID());
		
		PaymentRepresentation pRes = new PaymentRepresentation();
		pRes.setPaymentID(payment.getpaymentID());
		pRes.setCardNumber(payment.getcardNumber());
		pRes.setSecurityCode(payment.getsecurityCode());
		pRes.setExpirationDate(payment.getexpirationDate());
		pRes.setAddress(payment.getbillingAddress());	
		return pRes;
	}
}
