package com.marketplace.service.partner;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.marketplace.service.link.LinkRepresentation;

@XmlRootElement(name = "Partner")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class PartnerRepresentation extends LinkRepresentation {
	private int partnerID;
	private String partnerName;
	private String partnerType;
	private String partnerDetails;
	
	public PartnerRepresentation(){
		
	}

	public int getPartnerID() {
		return partnerID;
	}
	
	public void setPartnerID(int partnerID) {
		this.partnerID = partnerID;
	}
	
	public String getPartnerName() {
		return partnerName;
	}
	
	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}
	
	public String getPartnerType() {
		return partnerType;
	}
	
	public void setPartnerType(String partnerType) {
		this.partnerType = partnerType;
	}
	
	public String getPartnerDetails() {
		return partnerDetails;
	}
	
	public void setPartnerDetails(String partnerDetails) {
		this.partnerDetails = partnerDetails;
	}
}
