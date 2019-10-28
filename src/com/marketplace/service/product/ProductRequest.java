package com.marketplace.service.product;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.marketplace.domain.partner.Partner;

@XmlRootElement(name = "AddressRequest")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class ProductRequest {
	
	private int productID;
	private Partner partner;
	private String productName;
	private String productDescription;
	private double productCost;
	
	ProductRequest(){
		
	}
	
	public int getProductID() {
		return productID;
	}

	public Partner getpartner() {
		return partner;
	}
	
	public void setpartner(Partner partner) {
		this.partner = partner;
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
