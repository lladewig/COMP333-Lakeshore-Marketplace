package com.marketplace.service.order;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.marketplace.domain.order.Order;
import com.marketplace.domain.order.OrderLogic;

public class OrderActivity {
	
	public OrderRepresentation getOrderByID(int orderID) {
		OrderLogic aLogic = new OrderLogic();
		Order order = aLogic.getOrderByID(orderID);
		
		OrderRepresentation aRes = new OrderRepresentation();
		aRes.setorderID(order.getorderID());
		aRes.setcustomer(order.getcustomer());
		aRes.setProduct(order.getProduct());
		aRes.setPayment(order.getPayment());
		aRes.setStatus(order.getStatus());
		aRes.setshipmentAddress(order.getshipmentAddress());
		return aRes;
	}
	
	public List<OrderRepresentation> getAllOrders(int offset, int limit){
		OrderLogic aLogic = new OrderLogic();	
		List<Order> orders = new ArrayList<Order>();
		List<OrderRepresentation> aResponses = new ArrayList<OrderRepresentation>();
		orders = aLogic.getAllOrders(offset, limit);
		
		Iterator<Order> it = orders.iterator();
		while(it.hasNext()) {
          Order order = (Order)it.next();
          
        OrderRepresentation aRes = new OrderRepresentation();
		aRes.setorderID(order.getorderID());
		aRes.setcustomer(order.getcustomer());
		aRes.setProduct(order.getProduct());
		aRes.setPayment(order.getPayment());
		aRes.setStatus(order.getStatus());
		aRes.setshipmentAddress(order.getshipmentAddress());
        aResponses.add(aRes);
        }
		
		return aResponses;
	}
	
	public OrderRepresentation addOrder(OrderRequest aReq) {
		OrderLogic aLogic = new OrderLogic();
		Order order = aLogic.addOrder(aReq.getcustomer(), aReq.getProduct(), aReq.getPayment(), aReq.getStatus(), aReq.getshipmentAddress());
		
		OrderRepresentation aRes = new OrderRepresentation();
		aRes.setorderID(order.getorderID());
		aRes.setcustomer(order.getcustomer());
		aRes.setProduct(order.getProduct());
		aRes.setPayment(order.getPayment());
		aRes.setStatus(order.getStatus());
		aRes.setshipmentAddress(order.getshipmentAddress());
		return aRes;
	}
	
	public OrderRepresentation deleteOrder(int orderID) {
		OrderLogic aLogic = new OrderLogic();
		Order order = aLogic.deleteOrder(orderID);
		
		OrderRepresentation aRes = new OrderRepresentation();
		aRes.setorderID(order.getorderID());
		aRes.setcustomer(order.getcustomer());
		aRes.setProduct(order.getProduct());
		aRes.setPayment(order.getPayment());
		aRes.setStatus(order.getStatus());
		aRes.setshipmentAddress(order.getshipmentAddress());
		return aRes;
	}

}
