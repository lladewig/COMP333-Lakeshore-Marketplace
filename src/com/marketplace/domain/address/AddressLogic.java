package com.marketplace.domain.address;

import java.util.List;

import com.marketplace.dal.address.AddressDAL;

public class AddressLogic {
	
	public Address getAddressByID(int addressID) {
		return AddressDAL.getAddressByID(addressID);
	}
	
	public List<Address> getAllAddressForCustomer(int custID){
		return AddressDAL.getAllAddressForCustomer(custID);
	}

	public Address addAddress(int custID, String streetAddress, String unitNumber, int zipCode, String city, String state) {
		return AddressDAL.addAddress(custID, streetAddress, unitNumber, zipCode, city, state);
	}
	
	public Address deleteAddress(int addressID) {
		return AddressDAL.deleteAddress(addressID);
	}
}

