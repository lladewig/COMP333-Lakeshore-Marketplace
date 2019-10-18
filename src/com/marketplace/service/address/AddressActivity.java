package com.marketplace.service.address;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.marketplace.domain.address.Address;
import com.marketplace.domain.address.AddressLogic;

public class AddressActivity {
	
	public AddressRepresentation getAddressByID(int addressID) {
		AddressLogic aLogic = new AddressLogic();
		Address address = aLogic.getAddressByID(addressID);
		
		AddressRepresentation aRes = new AddressRepresentation();
		aRes.setAddressID(address.getaddressID());
		aRes.setCustomer(address.getcustomer());
		aRes.setStreetAddress(address.getstreetAddress());
		aRes.setUnitNUmber(address.getunitNumber());
		aRes.setZipCode(address.getzipCode());
		aRes.setCity(address.getcity());
		aRes.setState(address.getstate());
		return aRes;
	}
	
	public List<AddressRepresentation> getAllAddress(){
		AddressLogic aLogic = new AddressLogic();	
		List<Address> addresses = new ArrayList<Address>();
		List<AddressRepresentation> aResponses = new ArrayList<AddressRepresentation>();
		addresses = aLogic.getAllAddress();
		
		Iterator<Address> it = addresses.iterator();
		while(it.hasNext()) {
          Address address = (Address)it.next();
          
        AddressRepresentation aRes = new AddressRepresentation();
  		aRes.setAddressID(address.getaddressID());
  		aRes.setCustomer(address.getcustomer());
  		aRes.setStreetAddress(address.getstreetAddress());
  		aRes.setUnitNUmber(address.getunitNumber());
  		aRes.setZipCode(address.getzipCode());
  		aRes.setCity(address.getcity());
  		aRes.setState(address.getstate());
        aResponses.add(aRes);
        }
		
		return aResponses;
	}
	
	public AddressRepresentation addAddress(AddressRequest aReq) {
		AddressLogic aLogic = new AddressLogic();
		Address address = aLogic.addAddress(aReq.getCustomerID(), aReq.getStreetAddress(), aReq.getUnitNumber(), aReq.getZipCode(), aReq.getCity(), aReq.getState());
		
		AddressRepresentation aRes = new AddressRepresentation();
		aRes.setAddressID(address.getaddressID());
		aRes.setCustomer(address.getcustomer());
		aRes.setStreetAddress(address.getstreetAddress());
		aRes.setUnitNUmber(address.getunitNumber());
		aRes.setZipCode(address.getzipCode());
		aRes.setCity(address.getcity());
		aRes.setState(address.getstate());
		return aRes;
	}
	
	public AddressRepresentation deleteAddress(int addressID) {
		AddressLogic aLogic = new AddressLogic();
		Address address = aLogic.deleteAddress(addressID);
		
		AddressRepresentation aRes = new AddressRepresentation();
		aRes.setAddressID(address.getaddressID());
		aRes.setCustomer(address.getcustomer());
		aRes.setStreetAddress(address.getstreetAddress());
		aRes.setUnitNUmber(address.getunitNumber());
		aRes.setZipCode(address.getzipCode());
		aRes.setCity(address.getcity());
		aRes.setState(address.getstate());
		return aRes;
	}

}
