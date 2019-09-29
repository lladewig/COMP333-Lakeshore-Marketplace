package com.marketplace.domain;

public class Partner {

	private int partner_ID;
	private static String partner_name;
	private static String partner_type;
	private static String partner_details;
	
	public PartnerDAL(String partner_name, String partner_type, String partner_details) {
		this.partner_name = partner_name;
		this.partner_type= partner_type;
		this.partner_details = partner_details;
		
	}
	public Partner() {
		
	}
	public int getPartner_ID() {
		return partner_ID;
	}
	public String getPartner_name() {
		return partner_name;
	}
	public String getPartner_type() {
		return partner_type;
	}
	public String getPartner_details;
		return partner_details;
}
}
