package com.marketplace.domain.product;

import com.marketplace.domain.partner.Partner;

public class Product {
	private int productID;
	private Partner partner;
	private String productName;
	private String productDescription;
	private double productCost;

	public Product(Partner partner, String productName, String productDescription, double productCost) {
		this.partner = partner;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productCost = productCost;
	}
	
	public Product() {
		
	}
	
	public int getproductID() {
		return productID;
	}
	
	public void setproductID(int productID) {
		this.productID = productID;
	}
	
	public String getproductName() {
		return productName;
	}
	
	public void setproductName(String productName) {
		this.productName = productName;
	}
	
	public Partner getpartner() {
		return partner;
	}
	
	public void setpartner(Partner partner) {
		this.partner = partner;
	}
	
	public String getproductDescription() {
		return productDescription;
	}
	
	public void setproductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	public double getproductCost() {
		return productCost;
	}
	
	public void setproductCost(double productCost) {
		this.productCost = productCost;
	}
}
