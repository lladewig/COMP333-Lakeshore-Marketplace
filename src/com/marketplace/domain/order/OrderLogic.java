package com.marketplace.domain.order;

import java.util.List;

import com.marketplace.dal.order.OrderDAL;
import com.marketplace.dal.payment.PaymentDAL;
import com.marketplace.domain.address.Address;

public class OrderLogic {
	
	public Order getOrderByID(int orderID) {
		OrderDAL od = new OrderDAL();
		return od.getOrderByID(orderID);
	}	
	
	public List<Order> getAllOrders(int offset, int limit){
		OrderDAL od = new OrderDAL();
		return od.getAllOrders(offset, limit);
	}
	
	public List<Order> getAllOrdersForCustomer(int custID, int offset, int limit){
		OrderDAL od = new OrderDAL();
		return od.getAllOrdersForCustomer(custID, offset, limit);
	}
	
	public Order updateOrderStatus(String reviewStatus, int id) {
		OrderDAL od = new OrderDAL();
		Order order = od.updateOrderStatus(reviewStatus, id);
		return order;
	}

	public Order updateOrderShipAddress(Address shipAddress, int id) {
		OrderDAL od = new OrderDAL();
		Order order = od.updateOrderShipAddress(shipAddress, id);
		return order;
	}
	
	public Order addOrder(int custID, int paymentID, int productID, String status, Address shipmentAddress) {
		OrderDAL od = new OrderDAL();
		return od.addOrder(custID, paymentID, productID, status, shipmentAddress);
	}
	
	public static Order deleteOrder(int orderID) {
		OrderDAL od = new OrderDAL();
		return od.deleteOrder(orderID);
	}
}

