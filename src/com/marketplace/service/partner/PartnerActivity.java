package com.marketplace.service.partner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.marketplace.domain.partner.Partner;
import com.marketplace.domain.partner.PartnerLogic;
import com.marketplace.service.link.Link;

public class PartnerActivity {
	
	public PartnerRepresentation getPartnerByID(int partnerID) {
		PartnerLogic pLogic = new PartnerLogic();
		Partner partner = pLogic.getPartnerByID(partnerID);
		Link updateName = new Link("updatePartnerName", "http://localhost:8081/partnerservice/partners/name", "application/xml");
		Link updateDetails = new Link("updatePartnerDetails", "http://localhost:8081/partnerservice/partners/details", "application/xml");
		Link delPartner = new Link("deletePartner", "http://localhost:8081/partnerservice/partners/" + partnerID, "null");
		PartnerRepresentation pRes = buildResponse(partner, updateName, updateDetails, delPartner);
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

          Link getAllAddresses = new Link("getAllAddress", "http://localhost:8081/addressservice/addresses", "null");
          Link getAllOrders = new Link("getAllOrders", "http://localhost:8081/orderservice/orders", "null");
          Link getAllCustomers = new Link("getAllCustomers", "http://localhost:8081/customerservice/customers", "null");
          Link getAllPayments = new Link("getAllPayments", "http://localhost:8081/paymentservice/payments", "null");
          Link getAllProducts = new Link("getAllProducts", "http://localhost:8081/productservice/products", "null");
          PartnerRepresentation pRes = buildResponse(partner, getAllAddresses, getAllOrders, getAllCustomers, getAllPayments, getAllProducts);
          pResponses.add(pRes);
        }
		return pResponses;		
	}
	
	public PartnerRepresentation addPartner(PartnerRequest pReq) {
		PartnerLogic pLogic = new PartnerLogic();
		Partner partner = pLogic.addPartner(pReq.getPartnerName(), pReq.getPartnerType(), pReq.getPartnerDetails());
		
		Link addProduct = new Link("addProduct", "http://localhost:8081/productservice/products", "application/xml");
		Link updateName = new Link("updatePartnerName", "http:/localhost:8081/partnerservice/partners/name", "application/xml");
		Link updateDetails = new Link("updatePartnerDetails", "http://localhost:8081/partnerservice/partners/details", "application/xml");
		Link delPartner = new Link("deletePartner", "http://localhost:8081/partnerservice/partners/" + pReq.getPartnerID(), "null");
		PartnerRepresentation pRes = buildResponse(partner, addProduct, updateName, updateDetails, delPartner);
		return pRes;
	}
	
	public PartnerRepresentation deletePartner(int partnerID) {
		PartnerLogic pLogic = new PartnerLogic();
		Partner partner = pLogic.deletePartner(partnerID);
		Link addPartner = new Link("addPartner", "http://localhost:8081/partnerservice/partners", "application/xml");
		PartnerRepresentation pRes = buildResponse(partner, addPartner);
		return pRes;
	}
	
	public PartnerRepresentation updatePartnerName(PartnerRequest pReq) {
		PartnerLogic pLogic = new PartnerLogic();
		Partner partner = pLogic.updatePartnerName(pReq.getPartnerID(), pReq.getPartnerName());
		Link addProduct = new Link("addProduct", "http://localhost:8081/productservice/products", "application/xml");
		Link updateDetails = new Link("updatePartnerDetails", "http://localhost:8081/partnerservice/partners/details", "application/xml");
		Link delPartner = new Link("deletePartner", "http://localhost:8081/partnerservice/partners/" + pReq.getPartnerID(), "null");
		PartnerRepresentation pRes = buildResponse(partner, addProduct, updateDetails, delPartner);
		return pRes;
	}
	
	public PartnerRepresentation updatePartnerDetails(PartnerRequest pReq) {
		PartnerLogic pLogic = new PartnerLogic();
		Partner partner = pLogic.updatePartnerDetails(pReq.getPartnerID(), pReq.getPartnerDetails());
		Link addProduct = new Link("addProduct", "http://localhost:8081/productservice/products", "application/xml");
		Link updateName = new Link("updatePartnerName", "http:/localhost:8081/partnerservice/partners/name", "application/xml");
		Link delPartner = new Link("deletePartner", "http://localhost:8081/partnerservice/partners/" + pReq.getPartnerID(), "null");
		PartnerRepresentation pRes = buildResponse(partner, addProduct, updateName, delPartner);
		return pRes;
	}
	
	private PartnerRepresentation buildResponse(Partner partner, Link...links) {
		PartnerRepresentation pRes = new PartnerRepresentation();
		pRes.setPartnerID(partner.getpartnerID());
		pRes.setPartnerName(partner.getpartnerName());
		pRes.setPartnerType(partner.getpartnerType());
		pRes.setPartnerDetails(partner.getpartnerDetails());
		pRes.setLinks(links);
		return pRes;
	}
	
}
