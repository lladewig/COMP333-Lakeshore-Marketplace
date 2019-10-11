package com.marketplace.domain.partner;

import java.util.List;

import com.marketplace.dal.partner.PartnerDAL;

public class PartnerLogic {
	
	public Partner getPartnerByID(int partnerID) {
		PartnerDAL pd = new PartnerDAL();
		return pd.getPartnerByID(partnerID);
	}
	
	public List<Partner> getAllPartners(){
		PartnerDAL pd = new PartnerDAL();
		return pd.getAllPartners();
	}

	public Partner addPartner(String partnerName, String partnerType, String partnerDetails) {
		PartnerDAL pd = new PartnerDAL();
		return pd.addPartner(partnerName, partnerType, partnerDetails);
	}
	
	public Partner deletePartner(int partnerID) {
		PartnerDAL pd = new PartnerDAL();
		return pd.deletePartner(partnerID);
	}
	
	public Partner updatePartnerName(int partnerID, String partnerName) {
		PartnerDAL pd = new PartnerDAL();
		return pd.updatePartnerName(partnerID, partnerName);
	}
	
	public Partner updatePartnerDetails(int partnerID, String partnerDetails) {
		PartnerDAL pd = new PartnerDAL();
		return pd.updatePartnerDetails(partnerID, partnerDetails);
	}
}
