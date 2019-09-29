package com.marketplace.domain;

import java.util.ArrayList;
import java.util.List;

import com.marketplace.dal.PaymentDAL;

public class PaymentLogic {
	
	public Payment getPayment(int paymentID) {
		Payment payment = PaymentDAL.getPaymentByID(paymentID);
		return payment;
	}
	
	public List<Payment> getAllPayments() {
		List<Payment> payments = new ArrayList<Payment>();
		payments = PaymentDAL.getAllPayments();
		return payments;
	}
	
	public List<Payment> getAllPaymentsForCustomer(int custID){
		return PaymentDAL.getAllPaymentsForCustomer(custID);
	}
	
	public Payment addPayment(int custID, int cardNumber, int securityCode, String expirationDate, Address billingAddress) {
		return PaymentDAL.addPayment(custID, cardNumber, securityCode, expirationDate, billingAddress);
	}
	
	public Payment deletePayment(int id) {
		Payment payment = PaymentDAL.deletePayment(id);
		return payment;
	}
	
	public Payment updatePaymentCardNumber(int cardNumber, int id) {
		Payment payment = PaymentDAL.updatePaymentCardNumber(cardNumber, id);
		return payment;
	}
	
	public Payment updatePaymentSecurityCode(int securityCode, int id) {
		Payment payment = PaymentDAL.updatePaymentSecurityCode(securityCode, id);
		return payment;
	}
	
	public Payment updatePaymentExpirationDate(String expirationDate, int id) {
		Payment payment = PaymentDAL.updatePaymentExpirationDate(expirationDate, id);
		return payment;
	}	
	
	public Payment updatePaymentBillingAddress(Address billingAddress, int id) {
		Payment payment = PaymentDAL.updatePaymentBillingAddress(billingAddress, id);
		return payment;
	}
}
