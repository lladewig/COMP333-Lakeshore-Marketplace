package com.marketplace.service.customer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.marketplace.service.link.LinkRepresentation;

@XmlRootElement(name = "Customer")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class CustomerRepresentation extends LinkRepresentation {
		
		private int customerID;
		private String firstName;
		private String lastName;
		private int phoneNumber;

		public CustomerRepresentation() {}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public int getCustomerID() {
			return customerID;
		}

		public void setCustomerID(int customerID) {
			this.customerID = customerID;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
		public int getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(int phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

}
