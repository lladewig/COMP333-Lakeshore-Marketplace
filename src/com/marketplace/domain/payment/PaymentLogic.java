package com.marketplace.domain.payment;

import java.util.ArrayList;
import java.util.List;

import com.marketplace.dal.payment.PaymentDAL;
import com.marketplace.domain.address.Address;

public class PaymentLogic {
	
	public Payment getPayment(int paymentID) {
		PaymentDAL pd = new PaymentDAL();
		Payment payment = pd.getPaymentByID(paymentID);
		return payment;
	}
	
	public List<Payment> getAllPayments(int offset, int limit) {
		PaymentDAL pd = new PaymentDAL();
		List<Payment> payments = new ArrayList<Payment>();
		payments = pd.getAllPayments(offset, limit);
		return payments;
	}
	
	public List<Payment> getAllPaymentsForCustomer(int custID, int offset, int limit){
		PaymentDAL pd = new PaymentDAL();
		return pd.getAllPaymentsForCustomer(custID, offset, limit);
	}
	
	public Payment addPayment(int custID, int cardNumber, int securityCode, String expirationDate, int billingAddressID) {
		PaymentDAL pd = new PaymentDAL();
		return pd.addPayment(custID, cardNumber, securityCode, expirationDate, billingAddressID);
	}
	
	public Payment deletePayment(int id) {
		PaymentDAL pd = new PaymentDAL();
		Payment payment = pd.deletePayment(id);
		return payment;
	}
	
	public Payment updatePaymentCardNumber(int cardNumber, int id) {
		PaymentDAL pd = new PaymentDAL();
		Payment payment = pd.updatePaymentCardNumber(cardNumber, id);
		return payment;
	}
	
	public Payment updatePaymentSecurityCode(int securityCode, int id) {
		PaymentDAL pd = new PaymentDAL();
		Payment payment = pd.updatePaymentSecurityCode(securityCode, id);
		return payment;
	}
	
	public Payment updatePaymentExpirationDate(String expirationDate, int id) {
		PaymentDAL pd = new PaymentDAL();
		Payment payment = pd.updatePaymentExpirationDate(expirationDate, id);
		return payment;
	}	
	
	public Payment updatePaymentAddress(int addressID, int id) {
		PaymentDAL pd = new PaymentDAL();
		Payment payment = pd.updatePaymentAddress(addressID, id);
		return payment;
	}	
}
