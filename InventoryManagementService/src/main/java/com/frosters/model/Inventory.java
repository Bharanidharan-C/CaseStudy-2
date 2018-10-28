package com.frosters.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Inventory")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Inventory {
	@Id
	@Column(name="sku_id")	
	Long skuId;
	
	@Column(name="product_name",nullable=false)
	String productName;

    @Column(name="poduct_label",nullable=false)
	String productLabel;

    @Column(name="inventory_onhand",nullable=false)
	int inventoryOnHand ;

    @Column(name="reqminqty",nullable=false)
	int minQtyReq;

    @Column(nullable=false)
	double price ;

    public Inventory() {
		super();
		
	}

	public Inventory(Long skuId, String productName, String productLabel, int inventoryOnHand, int minQtyReq,
			double price) {
		super();
		this.skuId = skuId;
		this.productName = productName;
		this.productLabel = productLabel;
		this.inventoryOnHand = inventoryOnHand;
		this.minQtyReq = minQtyReq;
		this.price = price;
	}

	public Long getSkuId() {
		return skuId;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductLabel() {
		return productLabel;
	}

	public void setProductLabel(String productLabel) {
		this.productLabel = productLabel;
	}

	public int getInventoryOnHand() {
		return inventoryOnHand;
	}

	public void setInventoryOnHand(int inventoryOnHand) {
		this.inventoryOnHand = inventoryOnHand;
	}

	public int getMinQtyReq() {
		return minQtyReq;
	}

	public void setMinQtyReq(int minQtyReq) {
		this.minQtyReq = minQtyReq;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	


}
