package com.frosters.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.frosters.model.Inventory;



@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
	
	@Query(value = "SELECT i FROM Inventory i where i.inventoryOnHand < i.minQtyReq")
	public List<Inventory> findProductsOnShortage();
}
