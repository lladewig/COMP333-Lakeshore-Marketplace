package com.marketplace.service.product;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "ProductRequest")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class ProductRequest {
	
	private int productID;
	private int partnerID;
	private String productName;
	private String productDescription;
	private double productCost;
	
	public ProductRequest(){
		
	}
	
	public int getProductID() {
		return productID;
	}

	public int getPartnerID() {
		return partnerID;
	}
	
	public void setPartnerID(int partnerID) {
		this.partnerID = partnerID;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName=productName;
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
