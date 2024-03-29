package com.marketplace.service.product;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.marketplace.service.link.LinkRepresentation;
import com.marketplace.service.partner.PartnerRepresentation;

@XmlRootElement(name = "Product")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class ProductRepresentation extends LinkRepresentation {

	
	private int productID;
	private PartnerRepresentation partner;
	private String productName;
	private String productDescription;
	private double productCost;
	
	public ProductRepresentation(){
		
	}
	
	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}
	
	public PartnerRepresentation getPartner() {
		return partner;
	}
	
	public void setPartner(PartnerRepresentation partner) {
		this.partner = partner;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getProductDescription() {
		return productDescription;
	}
	
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	public double getProductCost() {
		return productCost;
	}
	
	public void setProductCost(double productCost) {
		this.productCost = productCost;
	}
}
