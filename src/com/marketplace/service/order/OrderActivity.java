package com.marketplace.service.order;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.marketplace.domain.order.Order;
import com.marketplace.domain.order.OrderLogic;
import com.marketplace.service.address.AddressRepresentation;
import com.marketplace.service.customer.CustomerRepresentation;
import com.marketplace.service.link.Link;
import com.marketplace.service.partner.PartnerRepresentation;
import com.marketplace.service.payment.PaymentRepresentation;
import com.marketplace.service.product.ProductRepresentation;

public class OrderActivity {
	
	public OrderRepresentation getOrderByID(int orderID) {
		OrderLogic oLogic = new OrderLogic();
		Order order = oLogic.getOrderByID(orderID);
		
		Link delOrder = new Link("deleteOrder", "http://localhost:8081/orderservice/orders/" + orderID, "application/xml");
		Link updateOrder = new Link("updateOrderStatus", "http://localhost:8081/orderservice/orders/update", "application/xml");
		Link addReview = new Link("addReview", "http://localhost:8081/reviewservice/reviews", "application/xml");
		OrderRepresentation oRes = buildResponse(order, delOrder, updateOrder, addReview);
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
          Link getAllAddresses = new Link("getAllAddress", "http://localhost:8081/addressservice/addresses", "null");
          Link getAllCustomers = new Link("getAllCustomers", "http://localhost:8081/customerservice/customers", "null");
          Link getAllPartners = new Link("getAllPartners", "http://localhost:8081/partnerservice/partners", "null");
          Link getAllPayments = new Link("getAllPayments", "http://localhost:8081/paymentservice/payments", "null");
          Link getAllProducts = new Link("getAllProducts", "http://localhost:8081/productservice/products", "null");
        OrderRepresentation oRes = buildResponse(order, getAllAddresses, getAllCustomers, getAllPartners, getAllPayments, getAllProducts);
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
          Link getAllAddresses = new Link("getAllAddress", "http://localhost:8081/addressservice/addresses", "null");
          Link getAllCustomers = new Link("getAllCustomers", "http://localhost:8081/customerservice/customers", "null");
          Link getAllPartners = new Link("getAllPartners", "http://localhost:8081/partnerservice/partners", "null");
          Link getAllPayments = new Link("getAllPayments", "http://localhost:8081/paymentservice/payments", "null");
          Link getAllProducts = new Link("getAllProducts", "http://localhost:8081/productservice/products", "null");
        OrderRepresentation oRes = buildResponse(order, getAllAddresses, getAllCustomers, getAllPartners, getAllPayments, getAllProducts);
        aResponses.add(oRes);
        }
		
		return aResponses;
	}
	

	
	public OrderRepresentation addOrder(OrderRequest aReq) {
		OrderLogic oLogic = new OrderLogic();
		Order order = oLogic.addOrder(aReq.getCustomerID(), aReq.getPaymentID(), aReq.getProductID(), aReq.getStatus(), aReq.getAddressID());
		
		Link getOrderByID = new Link("getOrder", "http://localhost:8081/orderservice/orders/" + order.getorderID(), "null");
		Link deleteOrder = new Link("deleteOrder", "http://localhost:8081/orderservice/orders/" + order.getorderID(), "null");
		Link getAllOrders = new Link("getAllOrdersForCustomer", "http://localhost:8081/orderservice/orders?custID="+order.getcustomer().getcustomerID()+"&offset=0&limit=20", "null");
		Link addReview = new Link("addReview", "http://localhost:8081/reviewservice/reviews/" + order.getProduct().getproductID(), "application/xml");
		
		OrderRepresentation oRes = buildResponse(order, getOrderByID, deleteOrder, getAllOrders, addReview);
		return oRes;
	}
	
	public OrderRepresentation deleteOrder(int orderID) {
		OrderLogic oLogic = new OrderLogic();
		Order order = oLogic.deleteOrder(orderID);
		
		Link addOrder = new Link("addOrder", "http://localhost:8081/orderservice/orders", "application/xml");
		OrderRepresentation oRes = buildResponse(order, addOrder);
		return oRes;
	}
	
	public OrderRepresentation updateOrderStatus(OrderRequest aReq) {
		OrderLogic oLogic = new OrderLogic();
		Order order = oLogic.updateOrderStatus(aReq.getStatus(), aReq.getOrderID());
		Link delOrder = new Link("deleteOrder", "http://localhost:8081/orderservice/orders/" + aReq.getOrderID(), "application/xml");
		OrderRepresentation oRes = buildResponse(order, delOrder);
		return oRes;
	}

	
	private OrderRepresentation buildResponse(Order order, Link...links) {
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
		
		cRes.setCustomerID(order.getcustomer().getcustomerID());
		cRes.setFirstName(order.getcustomer().getfirstName());
		cRes.setLastName(order.getcustomer().getlastName());
		cRes.setPhoneNumber(order.getcustomer().getphoneNumber());
		
		oRes.setorderID(order.getorderID());
		oRes.setcustomer(cRes);
		oRes.setProduct(prodRes);
		oRes.setPayment(payRes);
		oRes.setStatus(order.getStatus());
		oRes.setshipmentAddress(aRes);
		oRes.setLinks(links);
		return oRes;
	}
}
