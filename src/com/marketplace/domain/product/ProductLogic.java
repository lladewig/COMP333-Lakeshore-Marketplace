package com.marketplace.domain.product;

import java.util.List;

import com.marketplace.dal.product.ProductDAL;
import com.marketplace.domain.partner.Partner;

public class ProductLogic {
	
	public Product getProductByID(int id) {
		ProductDAL pd = new ProductDAL();
		return pd.getProductByID(id);
	}
	
	public List<Product> getAllProducts(int offset, int limit) {
		ProductDAL pd = new ProductDAL();
		return pd.getAllProducts(offset, limit);
	}
	
	public List<Product> getAllProductsByPartner(int partnerID, int offset, int limit){
		ProductDAL pd = new ProductDAL();
		return pd.getAllProductsByPartner(partnerID, offset, limit);
	}
	
	public Product addProduct(int partnerID, String productName, String productDescription, double cost) {
		ProductDAL pd = new ProductDAL();
	    return pd.addProduct(partnerID, productName, productDescription, cost);
	}
	
	public Product deleteProduct(int id){
		ProductDAL pd = new ProductDAL();
		return pd.deleteProduct(id);
	}
	
	public Product updateCost(int productID, double newCost) {
		ProductDAL pd = new ProductDAL();
	    return pd.updateCost(productID, newCost);
	}

}
