package com.marketplace.service.address;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.marketplace.domain.address.Address;
import com.marketplace.domain.address.AddressLogic;
import com.marketplace.service.customer.CustomerRepresentation;
import com.marketplace.service.link.Link;

public class AddressActivity {
	
	public AddressRepresentation getAddressByID(int addressID) {
		AddressLogic aLogic = new AddressLogic();
		Address address = aLogic.getAddressByID(addressID);
		
		AddressRepresentation aRes = buildResponse(address);
		return aRes;
	}
	
	public List<AddressRepresentation> getAllAddress(int offset, int limit){
		AddressLogic aLogic = new AddressLogic();	
		List<Address> addresses = new ArrayList<Address>();
		List<AddressRepresentation> aResponses = new ArrayList<AddressRepresentation>();
		addresses = aLogic.getAllAddress(offset, limit);
		
		Iterator<Address> it = addresses.iterator();
		while(it.hasNext()) {
          Address address = (Address)it.next();
          
        AddressRepresentation aRes = buildResponse(address);
        aResponses.add(aRes);
        }
		
		return aResponses;
	}
	
	public AddressRepresentation addAddress(AddressRequest aReq) {
		AddressLogic aLogic = new AddressLogic();
		Address address = aLogic.addAddress(aReq.getCustomerID(), aReq.getStreetAddress(), aReq.getUnitNumber(), aReq.getZipCode(), aReq.getCity(), aReq.getState());

		Link payment = new Link("addPayment", 
				"http://localhost:8081/paymentservice/payments", "application/xml");	
		Link delAddr = new Link("deleteAddress", 
				"http://localhost:8081/addressservice/" + address.getaddressID(), "null");	
		AddressRepresentation aRes = buildResponse(address, payment, delAddr);
		return aRes;
	}
	
	public AddressRepresentation deleteAddress(int addressID) {
		AddressLogic aLogic = new AddressLogic();
		Address address = aLogic.deleteAddress(addressID);
		
		AddressRepresentation aRes = buildResponse(address);
		return aRes;
	}
	
	private AddressRepresentation buildResponse(Address address, Link...links) {
		AddressRepresentation aRes = new AddressRepresentation();
		
		CustomerRepresentation cRes = new CustomerRepresentation();
		cRes.setCustomerID(address.getcustomer().getcustomerID());
		cRes.setFirstName(address.getcustomer().getfirstName());
		cRes.setLastName(address.getcustomer().getlastName());
		
		aRes.setAddressID(address.getaddressID());
		aRes.setCustomer(cRes);
		aRes.setStreetAddress(address.getstreetAddress());
		aRes.setUnitNUmber(address.getunitNumber());
		aRes.setZipCode(address.getzipCode());
		aRes.setCity(address.getcity());
		aRes.setState(address.getstate());
		aRes.setLinks(links);
		return aRes;
	}

}
