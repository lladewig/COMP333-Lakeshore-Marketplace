package com.marketplace.service.product;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/productservice/")
public class ProductResource {
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/products/{productID}")
	public ProductRepresentation getProductByID(@PathParam("productID") int productID) {
		System.out.println("GET METHOD Request from Client for Get Product");
		ProductActivity addActivity = new ProductActivity();
		return addActivity.getProductByID(productID);
		
	}
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/products")
	public List<ProductRepresentation> getAllProducts(@QueryParam("offset") int offset, @QueryParam("limit") int limit){
		if (limit == 0) {
			limit = 5;
		}
		System.out.println("GET METHOD Request from Client for Get All Products with offset " + offset + " and limit " + limit);
		ProductActivity addActivity = new ProductActivity();
		return addActivity.getAllProducts(offset, limit);
	}
	
	@POST
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/products")
	public ProductRepresentation addProduct(ProductRequest aReq) {
		System.out.println("POST METHOD Request from Client for Add Product");
		ProductActivity addActivity = new ProductActivity();
		return addActivity.addProduct(aReq);
	}
	
	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/products/{productID}")
	public ProductRepresentation deleteProduct(@PathParam("productID") int productID) {
		System.out.println("DELETE METHOD Request from Client for Delete Product");
		ProductActivity addActivity = new ProductActivity();
		return addActivity.deleteProduct(productID);
	}
}
