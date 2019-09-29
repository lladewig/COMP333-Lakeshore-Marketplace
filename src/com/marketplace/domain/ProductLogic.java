package com.marketplace.domain;

import java.util.List;

import com.marketplace.dal.ProductDAL;

public class ProductLogic {
	
	public static Product getProductByID(int id) {
		return ProductDAL.getProductByID(id);
	}
	
	public List<Product> getAllProducts() {
		return ProductDAL.getAllProducts();
	}
	
	public List<Product> getAllProductsByPartner(int partnerID){
		return ProductDAL.getAllProductsByPartner(partnerID);
	}
	
	public Product addProduct(Partner partner, String productName, String productDescription, double cost) {
	    return ProductDAL.addProduct(partner, productName, productDescription, cost);
	}
	
	public Product deleteProduct(int id){
		return ProductDAL.deleteProduct(id);
	}
	
	public Product updateCost(int productID, double newCost) {
	    return ProductDAL.updateCost(productID, newCost);
	}

}
