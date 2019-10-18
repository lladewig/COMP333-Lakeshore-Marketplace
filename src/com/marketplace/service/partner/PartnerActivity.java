package com.marketplace.service.partner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.marketplace.domain.partner.Partner;
import com.marketplace.domain.partner.PartnerLogic;

public class PartnerActivity {
	
	public PartnerRepresentation getPartnerByID(int partnerID) {
		PartnerLogic pLogic = new PartnerLogic();
		Partner partner = pLogic.getPartnerByID(partnerID);
		
		PartnerRepresentation pRes = new PartnerRepresentation();
		pRes.setPartnerID(partner.getpartnerID());
		pRes.setPartnerName(partner.getpartnerName());
		pRes.setPartnerType(partner.getpartnerType());
		pRes.setPartnerDetails(partner.getpartnerDetails());
		return pRes;
	}
	
	public List<PartnerRepresentation> getAllPartners(){
		PartnerLogic pLogic = new PartnerLogic();	
		List<Partner> partners = new ArrayList<Partner>();
		List<PartnerRepresentation> pResponses = new ArrayList<PartnerRepresentation>();
		partners = pLogic.getAllPartners();
		
		Iterator<Partner> it = partners.iterator();
		while(it.hasNext()) {
          Partner partner = (Partner)it.next();
          
          PartnerRepresentation pRes = new PartnerRepresentation();
          pRes.setPartnerID(partner.getpartnerID());
          pRes.setPartnerName(partner.getpartnerName());
          pRes.setPartnerType(partner.getpartnerType());
          pRes.setPartnerDetails(partner.getpartnerDetails());
          pResponses.add(pRes);
        }
		return pResponses;		
	}
	
	public PartnerRepresentation addPartner(PartnerRequest pReq) {
		PartnerLogic pLogic = new PartnerLogic();
		Partner partner = pLogic.addPartner(pReq.getPartnerName(), pReq.getPartnerType(), pReq.getPartnerDetails());
		
		PartnerRepresentation pRes = new PartnerRepresentation();
		pRes.setPartnerID(partner.getpartnerID());
		pRes.setPartnerName(partner.getpartnerName());
		pRes.setPartnerType(partner.getpartnerType());
		pRes.setPartnerDetails(partner.getpartnerDetails());
		return pRes;
	}
	
	public PartnerRepresentation deletePartner(int partnerID) {
		PartnerLogic pLogic = new PartnerLogic();
		Partner partner = pLogic.deletePartner(partnerID);
		
		PartnerRepresentation pRes = new PartnerRepresentation();
		pRes.setPartnerID(partner.getpartnerID());
		pRes.setPartnerName(partner.getpartnerName());
		pRes.setPartnerType(partner.getpartnerType());
		pRes.setPartnerDetails(partner.getpartnerDetails());
		return pRes;
	}
	
	public PartnerRepresentation updatePartnerName(PartnerRequest pReq) {
		PartnerLogic pLogic = new PartnerLogic();
		Partner partner = pLogic.updatePartnerName(pReq.getPartnerID(), pReq.getPartnerName());
		
		PartnerRepresentation pRes = new PartnerRepresentation();
		pRes.setPartnerID(partner.getpartnerID());
		pRes.setPartnerName(partner.getpartnerName());
		pRes.setPartnerType(partner.getpartnerType());
		pRes.setPartnerDetails(partner.getpartnerDetails());
		return pRes;
	}
	
	public PartnerRepresentation updatePartnerDetails(PartnerRequest pReq) {
		PartnerLogic pLogic = new PartnerLogic();
		Partner partner = pLogic.updatePartnerDetails(pReq.getPartnerID(), pReq.getPartnerDetails());
		
		PartnerRepresentation pRes = new PartnerRepresentation();
		pRes.setPartnerID(partner.getpartnerID());
		pRes.setPartnerName(partner.getpartnerName());
		pRes.setPartnerType(partner.getpartnerType());
		pRes.setPartnerDetails(partner.getpartnerDetails());
		return pRes;
	}
	
}
