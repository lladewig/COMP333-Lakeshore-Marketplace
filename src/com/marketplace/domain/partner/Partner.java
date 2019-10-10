package com.marketplace.domain.partner;

public class Partner {
	private int partnerID;
	private String partnerName;
	private String partnerType;
	private String partnerDetails;
	
	public Partner(String partnerName, String partnerType, String partnerDetails) {
		this.partnerName = partnerName;
		this.partnerType = partnerType;
		this.partnerDetails = partnerDetails;
	}
	
	public Partner() {
		
	}
	
	public int getpartnerID() {
		return partnerID;
	}
	
	public void setpartnerID(int partnerID) {
		this.partnerID = partnerID;
	}
	
	public String getpartnerName() {
		return partnerName;
	}
	
	public void setpartnerName(String partnerName) {
		this.partnerName = partnerName;
	}
	
	public String getpartnerType() {
		return partnerType;
	}
	
	public void setpartnerType(String partnerType) {
		this.partnerType = partnerType;
	}
	
	public String getpartnerDetails() {
		return partnerDetails;
	}
	
	public void setpartnerDetails(String partnerDetails) {
		this.partnerDetails = partnerDetails;
	}
}
