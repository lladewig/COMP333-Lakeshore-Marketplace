package com.marketplace.service.order;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.marketplace.domain.order.Order;
import com.marketplace.domain.order.OrderLogic;
import com.marketplace.service.address.AddressRepresentation;
import com.marketplace.service.customer.CustomerRepresentation;
import com.marketplace.service.partner.PartnerRepresentation;
import com.marketplace.service.payment.PaymentRepresentation;
import com.marketplace.service.product.ProductRepresentation;

public class OrderActivity {
	
	public OrderRepresentation getOrderByID(int orderID) {
		OrderLogic oLogic = new OrderLogic();
		Order order = oLogic.getOrderByID(orderID);
		
		OrderRepresentation oRes = buildResponse(order);
		return oRes;
	}
	
	public List<OrderRepresentation> getAllOrders(int offset, int limit){
		OrderLogic oLogic = new OrderLogic();	
		List<Order> orders = new ArrayList<Order>();
		List<OrderRepresentation> aResponses = new ArrayList<OrderRepresentation>();
		orders = oLogic.getAllOrders(offset, limit);
		
		Iterator<Order> it = orders.iterator();
		while(it.hasNext()) {
          Order order = (Order)it.next();
          
        OrderRepresentation oRes = buildResponse(order);
        aResponses.add(oRes);
        }
		
		return aResponses;
	}
	
	public List<OrderRepresentation> getAllOrdersForCustomer(int custID, int offset, int limit){
		OrderLogic oLogic = new OrderLogic();	
		List<Order> orders = new ArrayList<Order>();
		List<OrderRepresentation> aResponses = new ArrayList<OrderRepresentation>();
		orders = oLogic.getAllOrdersForCustomer(custID, offset, limit);
		
		Iterator<Order> it = orders.iterator();
		while(it.hasNext()) {
          Order order = (Order)it.next();
          
        OrderRepresentation oRes = buildResponse(order);
        aResponses.add(oRes);
        }
		
		return aResponses;
	}
	
	public OrderRepresentation addOrder(OrderRequest aReq) {
		OrderLogic oLogic = new OrderLogic();
		Order order = oLogic.addOrder(aReq.getCustomerID(), aReq.getProductID(), aReq.getPaymentID(), aReq.getStatus(), aReq.getAddressID());
		
		OrderRepresentation oRes = buildResponse(order);
		return oRes;
	}
	
	public OrderRepresentation deleteOrder(int orderID) {
		OrderLogic oLogic = new OrderLogic();
		Order order = oLogic.deleteOrder(orderID);
		
		OrderRepresentation oRes = buildResponse(order);
		return oRes;
	}

	
	private OrderRepresentation buildResponse(Order order) {
		OrderRepresentation oRes = new OrderRepresentation();
		
		ProductRepresentation prodRes = new ProductRepresentation();
		CustomerRepresentation cRes = new CustomerRepresentation();
		PaymentRepresentation payRes = new PaymentRepresentation();
		AddressRepresentation aRes = new AddressRepresentation();
		PartnerRepresentation parRes = new PartnerRepresentation();
		
		parRes.setPartnerID(order.getProduct().getpartner().getpartnerID());
		parRes.setPartnerName(order.getProduct().getpartner().getpartnerName());
		parRes.setPartnerType(order.getProduct().getpartner().getpartnerType());
		parRes.setPartnerDetails(order.getProduct().getpartner().getpartnerDetails());
		
		prodRes.setProductID(order.getProduct().getproductID());
		prodRes.setProductName(order.getProduct().getproductName());
		prodRes.setPartner(parRes);
		prodRes.setProductCost(order.getProduct().getproductCost());
		prodRes.setProductDescription(order.getProduct().getproductDescription());
		
		aRes.setAddressID(order.getshipmentAddress().getaddressID());
		aRes.setCity(order.getshipmentAddress().getcity());
		aRes.setCustomer(cRes);
		aRes.setState(order.getshipmentAddress().getstate());
		aRes.setStreetAddress(order.getshipmentAddress().getstreetAddress());
		aRes.setUnitNUmber(order.getshipmentAddress().getunitNumber());
		aRes.setZipCode(order.getshipmentAddress().getzipCode());
		
		payRes.setPaymentID(order.getPayment().getpaymentID());
		payRes.setCardNumber(order.getPayment().getcardNumber());
		payRes.setSecurityCode(order.getPayment().getsecurityCode());
		payRes.setExpirationDate(order.getPayment().getexpirationDate());
		payRes.setAddress(aRes);	
		
		
		oRes.setorderID(order.getorderID());
		oRes.setcustomer(cRes);
		oRes.setProduct(prodRes);
		oRes.setPayment(payRes);
		oRes.setStatus(order.getStatus());
		oRes.setshipmentAddress(aRes);
		return oRes;
	}
}
