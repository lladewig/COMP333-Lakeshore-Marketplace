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
		
		PartnerRepresentation pRes = buildResponse(partner);
		return pRes;
	}
	
	public List<PartnerRepresentation> getAllPartners(int offset, int limit){
		PartnerLogic pLogic = new PartnerLogic();	
		List<Partner> partners = new ArrayList<Partner>();
		List<PartnerRepresentation> pResponses = new ArrayList<PartnerRepresentation>();
		partners = pLogic.getAllPartners(offset, limit);
		
		Iterator<Partner> it = partners.iterator();
		while(it.hasNext()) {
          Partner partner = (Partner)it.next();
          
          PartnerRepresentation pRes = buildResponse(partner);
          pResponses.add(pRes);
        }
		return pResponses;		
	}
	
	public PartnerRepresentation addPartner(PartnerRequest pReq) {
		PartnerLogic pLogic = new PartnerLogic();
		Partner partner = pLogic.addPartner(pReq.getPartnerName(), pReq.getPartnerType(), pReq.getPartnerDetails());
		
		PartnerRepresentation pRes = buildResponse(partner);
		return pRes;
	}
	
	public PartnerRepresentation deletePartner(int partnerID) {
		PartnerLogic pLogic = new PartnerLogic();
		Partner partner = pLogic.deletePartner(partnerID);
		
		PartnerRepresentation pRes = buildResponse(partner);
		return pRes;
	}
	
	public PartnerRepresentation updatePartnerName(PartnerRequest pReq) {
		PartnerLogic pLogic = new PartnerLogic();
		Partner partner = pLogic.updatePartnerName(pReq.getPartnerID(), pReq.getPartnerName());
		
		PartnerRepresentation pRes = buildResponse(partner);
		return pRes;
	}
	
	public PartnerRepresentation updatePartnerDetails(PartnerRequest pReq) {
		PartnerLogic pLogic = new PartnerLogic();
		Partner partner = pLogic.updatePartnerDetails(pReq.getPartnerID(), pReq.getPartnerDetails());
		
		PartnerRepresentation pRes = buildResponse(partner);
		return pRes;
	}
	
	private PartnerRepresentation buildResponse(Partner partner) {
		PartnerRepresentation pRes = new PartnerRepresentation();
		pRes.setPartnerID(partner.getpartnerID());
		pRes.setPartnerName(partner.getpartnerName());
		pRes.setPartnerType(partner.getpartnerType());
		pRes.setPartnerDetails(partner.getpartnerDetails());
		return pRes;
	}
	
}
