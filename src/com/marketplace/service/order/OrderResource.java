package com.marketplace.service.order;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/orderservice/")
public class OrderResource {
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/orders/{orderID}")
	public OrderRepresentation getOrderByID(@PathParam("orderID") int orderID) {
		System.out.println("GET METHOD Request from Client for Get Order");
		OrderActivity addActivity = new OrderActivity();
		return addActivity.getOrderByID(orderID);
		
	}
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/orders")
	public List<OrderRepresentation> getAllOrders(@QueryParam("offset") int offset, @QueryParam("limit") int limit){
		if (limit == 0) {
			limit = 5;
		}
		System.out.println("GET METHOD Request from Client for Get All Orders with offset " + offset + " and limit " + limit);
		OrderActivity addActivity = new OrderActivity();
		return addActivity.getAllOrders(offset, limit);
	}
	
	@POST
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/orders")
	public OrderRepresentation addOrder(OrderRequest aReq) {
		System.out.println("POST METHOD Request from Client for Add Order");
		OrderActivity addActivity = new OrderActivity();
		return addActivity.addOrder(aReq);
	}
	
	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/orders/{orderID}")
	public OrderRepresentation deleteOrder(@PathParam("orderID") int orderID) {
		System.out.println("DELETE METHOD Request from Client for Delete Order");
		OrderActivity addActivity = new OrderActivity();
		return addActivity.deleteOrder(orderID);
	}
}
