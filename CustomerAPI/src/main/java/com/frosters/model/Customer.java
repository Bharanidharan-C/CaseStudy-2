package com.frosters.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType; 
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="CUSTOMER") 
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer {

	 
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", contactNumber="
				+ contactNumber + ", address=" + address + ", gender=" + gender + "]";
	}
	public Customer(){
		super();
	}
	

	public Customer(Long customerId, @JsonProperty("customerName") String customerName, @JsonProperty("contactNumber") Long contactNumber, @JsonProperty("address") String address,@JsonProperty("gender") String gender) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.contactNumber = contactNumber;
		this.address = address;
		this.gender = gender;
	}

	@JsonProperty("customerId")
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	@JsonProperty("customerName")
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@JsonProperty("contactNumber")
	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	@JsonProperty("address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	@JsonProperty("gender")
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Id
	@Column(name="customer_id",nullable=false)
	private Long customerId;

	@Column(name="customer_name",nullable=false)
	private String customerName;

	@Column(name="contact_number",nullable=false)
	private Long contactNumber ;

	@Column(nullable=false)
	private String address;

	@Column(nullable=false)
	private String gender;
}
