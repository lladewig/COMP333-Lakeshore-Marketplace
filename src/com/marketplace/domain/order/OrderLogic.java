package com.marketplace.domain.order;

import java.util.List;

import com.marketplace.dal.order.OrderDAL;
import com.marketplace.dal.payment.PaymentDAL;
import com.marketplace.domain.address.Address;

public class OrderLogic {
	
	public Order getOrderByID(int orderID) {
		return OrderDAL.getOrderByID(orderID);
	}	
	
	public List<Order> getAllOrdersForCustomer(int custID){
		return OrderDAL.getAllOrdersForCustomer(custID);
	}
	
	public Order updateOrderStatus(String reviewStatus, int id) {
		Order order = OrderDAL.updateOrderStatus(reviewStatus, id);
		return order;
	}

	public Order updateOrderShipAddress(Address shipAddress, int id) {
		Order order = OrderDAL.updateOrderShipAddress(shipAddress, id);
		return order;
	}
	
	public Order addOrder(int custID, int paymentID, int productID, String status, Address shipmentAddress) {
		return OrderDAL.addOrder(custID, paymentID, productID, status, shipmentAddress);
	}
	
	public static Order deleteOrder(int orderID) {
		return OrderDAL.deleteOrder(orderID);
	}
}

