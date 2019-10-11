package com.marketplace.domain.address;

import java.util.List;

import com.marketplace.dal.address.AddressDAL;

public class AddressLogic {
	
	public Address getAddressByID(int addressID) {
		AddressDAL ad = new AddressDAL();
		return ad.getAddressByID(addressID);
	}
	
	public List<Address> getAllAddressForCustomer(int custID){
		AddressDAL ad = new AddressDAL();
		return ad.getAllAddressForCustomer(custID);
	}

	public Address addAddress(int custID, String streetAddress, String unitNumber, int zipCode, String city, String state) {
		AddressDAL ad = new AddressDAL();
		return ad.addAddress(custID, streetAddress, unitNumber, zipCode, city, state);
	}
	
	public Address deleteAddress(int addressID) {
		AddressDAL ad = new AddressDAL();
		return ad.deleteAddress(addressID);
	}
}

