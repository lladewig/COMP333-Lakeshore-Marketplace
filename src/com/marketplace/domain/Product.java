package com.marketplace.domain;

public class Product {
	private int product_ID;
	private static String product_name;
	private static String product_detail;
	private static String product_cost;
	
	public Product(String product_name, String product_detail, String product_cost ) {
		this.product_cost= product_cost;
		product_detail = product_detail;
		product_name = product_name;
				
	}
	public Product() {
		
	}
	public int getProduct_ID() {
		return product_ID;
	}
	public String getProduct_name() {
		return product_name;
	}
	public String getProduct_detail() {
		return product_detail;
	}
	public String getProduct_cost() {
		return product_cost;
	}
}
