package com.frosters.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="ORDERS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_id")
	Long orderId;
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", customerId=" + customerId + ", paymentChannel=" + paymentChannel
				+ ", isCod=" + isCod + ", orderStatus=" + orderStatus + ", orderCreatedOn=" + orderCreatedOn
				+ ", totalAmount=" + totalAmount + ", shippingAddress=" + shippingAddress + ", lineItems=" + lineItems
				+ "]";
	}
	@Column(name="customer_id",nullable=false)
	Long customerId;
	
	@Column(name="payment_channel",nullable=false)
	String paymentChannel;
	
	@Column(name="iscod",nullable=false)
	boolean isCod;
	
	@Column(name="order_status",nullable=false)
	String orderStatus;
	
	@Column(name="order_createdon",nullable=false)
	Long orderCreatedOn;
	
	@Column(name="total_amount",nullable=false)
	double totalAmount;
	@Column(name="shipping_address",nullable=false)
	String shippingAddress;
	
	@Transient	
	List<OrderLineItem> lineItems;
	
	

	/**
	 * @param orderId
	 * @param customerId
	 * @param paymentChannel
	 * @param isCod
	 * @param orderStatus
	 * @param orderCreatedOn
	 * @param totalAmount
	 * @param shippingAddress
	 * @param lineItems
	 */
	public Orders( Long customerId, String paymentChannel, boolean isCod, String orderStatus,
			Long orderCreatedOn, double totalAmount, String shippingAddress, List<OrderLineItem> lineItems) {
		super();
		this.customerId = customerId;
		this.paymentChannel = paymentChannel;
		this.isCod = isCod;
		this.orderStatus = orderStatus;
		this.orderCreatedOn = orderCreatedOn;
		this.totalAmount = totalAmount;
		this.shippingAddress = shippingAddress;
		this.lineItems = lineItems;
	}
	
	

	/**
	
	 */
	public Orders() {

		super();
	}
	
	
	/**
	 * @return the lineItems
	 */
	public List<OrderLineItem> getLineItems() {
		return lineItems;
	}
	/**
	 * @param lineItems the lineItems to set
	 */
	public void setLineItems(List<OrderLineItem> lineItems) {
		this.lineItems = lineItems;
	}
	/**
	 * @return the orderId
	 */
	public Long getOrderId() {
		return orderId;
	}
	/**
	 * @return the customerId
	 */
	public Long getCustomerId() {
		return customerId;
	}
	/**
	 * @return the paymentChannel
	 */
	public String getPaymentChannel() {
		return paymentChannel;
	}
	/**
	 * @return the isCod
	 */
	public boolean isCod() {
		return isCod;
	}
	/**
	 * @return the orderStatus
	 */
	public String getOrderStatus() {
		return orderStatus;
	}
	/**
	 * @return the orderCreatedOn
	 */
	public Long getOrderCreatedOn() {
		return orderCreatedOn;
	}
	/**
	 * @return the totalAmount
	 */
	public double getTotalAmount() {
		return totalAmount;
	}
	/**
	 * @return the shippingAddress
	 */
	public String getShippingAddress() {
		return shippingAddress;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	/**
	 * @param paymentChannel the paymentChannel to set
	 */
	public void setPaymentChannel(String paymentChannel) {
		this.paymentChannel = paymentChannel;
	}
	/**
	 * @param isCod the isCod to set
	 */
	public void setCod(boolean isCod) {
		this.isCod = isCod;
	}
	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	/**
	 * @param orderCreatedOn the orderCreatedOn to set
	 */
	public void setOrderCreatedOn(Long orderCreatedOn) {
		this.orderCreatedOn = orderCreatedOn;
	}
	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	/**
	 * @param shippingAddress the shippingAddress to set
	 */
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	

}
