package com.marketplace.domain.partner;

import java.util.List;

import com.marketplace.dal.partner.PartnerDAL;

public class PartnerLogic {
	
	public Partner getPartnerByID(int partnerID) {
		return PartnerDAL.getPartnerByID(partnerID);
	}
	
	public List<Partner> getAllPartners(){
		return PartnerDAL.getAllPartners();
	}

	public Partner addPartner(String partnerName, String partnerType, String partnerDetails) {
		return PartnerDAL.addPartner(partnerName, partnerType, partnerDetails);
	}
	
	public Partner deletePartner(int partnerID) {
		return PartnerDAL.deletePartner(partnerID);
	}
	
	public Partner updatePartnerName(int partnerID, String partnerName) {
		return PartnerDAL.updatePartnerName(partnerID, partnerName);
	}
	
	public Partner updatePartnerDetails(int partnerID, String partnerDetails) {
		return PartnerDAL.updatePartnerDetails(partnerID, partnerDetails);
	}
}
