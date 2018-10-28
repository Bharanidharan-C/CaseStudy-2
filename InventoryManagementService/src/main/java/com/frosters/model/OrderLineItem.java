package com.frosters.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ORDER_LINEITEM")
public class OrderLineItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="orderlineitem_id")
	Long orderLineItemId;
	
	
	/**
	 * 
	 */
	public OrderLineItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param orderLineItemId
	 * @param skuId
	 * @param itemQty
	 * @param order
	 */
	public OrderLineItem(Long skuId, int itemQty) {
		super();
		this.skuId = skuId;
		this.itemQty = itemQty;
	}



	@Column(name="sku_id",nullable=false)
	Long skuId;
	

	@Column(name="item_qty",nullable=false)
	int itemQty;
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrderLineItem [orderLineItemId=" + orderLineItemId + ", skuId=" + skuId + ", itemQty=" + itemQty
				+ ", order=" + order + "]";
	}



	@ManyToOne(optional=false) 
    @JoinColumn(name="order_id",nullable =false)
	Orders order;
	
	/**
	 * @return the order
	 */
	public Orders getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(Orders order) {
		this.order = order;
	}



	
	
	/**
	 * @return the orderLineItemId
	 */
	public Long getOrderLineItemId() {
		return orderLineItemId;
	}

	/**
	 * @return the skuId
	 */
	public Long getSkuId() {
		return skuId;
	}

	

	/**
	 * @return the itemQty
	 */
	public int getItemQty() {
		return itemQty;
	}

	/**
	 * @param orderLineItemId the orderLineItemId to set
	 */
	public void setOrderLineItemId(Long orderLineItemId) {
		this.orderLineItemId = orderLineItemId;
	}

	/**
	 * @param skuId the skuId to set
	 */
	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}

	

	/**
	 * @param itemQty the itemQty to set
	 */
	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}

	
	
	
}
