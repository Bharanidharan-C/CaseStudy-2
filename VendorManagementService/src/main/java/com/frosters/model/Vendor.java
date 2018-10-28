package com.frosters.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="VENDOR")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Vendor {


	@Id
	@Column(name="vendor_id",nullable=false)
	Long vendorId ;

	@Column(name="vendor_name",nullable=false)
	String vendorName;

	@Column(name="vendor_contactno",nullable=false)
	Long vendorContactNo;

	@Column(name="vendor_email",nullable=false)
	String vendorEmail;

	@Column(name="vendor_username",nullable=false)
	String vendorUsername;

	@Column(name="vendor_address",nullable=false)
	String vendorAddress;
	
	
	public Vendor() {
		super();
	}

	
	public Vendor(Long vendorId, String vendorName, Long vendorContactNo, String vendorEmail, String vendorUsername,
			String vendorAddress) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.vendorContactNo = vendorContactNo;
		this.vendorEmail = vendorEmail;
		this.vendorUsername = vendorUsername;
		this.vendorAddress = vendorAddress;
	}
	
	@JsonProperty("vendorId")
	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}
	@JsonProperty("vendorName")
	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	
	@JsonProperty("vendorContactNo")
	public Long getVendorContactNo() {
		return vendorContactNo;
	}

	public void setVendorContactNo(Long vendorContactNo) {
		this.vendorContactNo = vendorContactNo;
	}

	@JsonProperty("vendorEmail")
	public String getVendorEmail() {
		return vendorEmail;
	}

	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}

	@JsonProperty("vendorUsername")
	public String getVendorUsername() {
		return vendorUsername;
	}

	public void setVendorUsername(String vendorUsername) {
		this.vendorUsername = vendorUsername;
	}
	
	@JsonProperty("vendorAddress")
	public String getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}



}
