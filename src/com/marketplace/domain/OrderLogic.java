package com.marketplace.domain;

import java.util.List;

import com.marketplace.dal.OrderDAL;

public class OrderLogic {
	
	public Order getOrderByID(int orderID) {
		return OrderDAL.getOrderByID(orderID);
	}	
	
	public List<Order> getAllOrdersForCustomer(int custID){
		return OrderDAL.getAllOrdersForCustomer(custID);
	}

	public Order addOrder(int custID, int paymentID, int productID, String status, String shipmentAddress) {
		return OrderDAL.addOrder(custID, paymentID, productID, status, shipmentAddress);
	}
	
	public static Order deleteOrder(int orderID) {
		return OrderDAL.deleteOrder(orderID);
	}
}

