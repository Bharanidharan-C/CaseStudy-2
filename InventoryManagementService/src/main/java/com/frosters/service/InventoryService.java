package com.frosters.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.frosters.model.Inventory;
import com.frosters.repository.InventoryRepository;

@Service
public class InventoryService {

	@Autowired
	InventoryRepository inventoryRepository;
	
	public List<Inventory> getAllInventorys(){
	 return inventoryRepository.findAll();	
	}
	
	public Inventory getInventory(Long id) {
		return inventoryRepository.getOne(id);
	}
	 
	public Inventory addNewInventory(Inventory inventory) {
		return inventoryRepository.save(inventory);
	}
	
	public Inventory updateInventory(Long id, Inventory updatedInventory) throws Exception {
		Inventory inventory = inventoryRepository.findById(id).get();
		  if(inventory== null) {
			throw new Exception();  
		  }else {
			  System.out.println(updatedInventory);
	            return inventoryRepository.save(updatedInventory);
		  }
		
	}
	
   public void deleteInventory(Long id) throws Exception {
		  Inventory inventory = inventoryRepository.findById(id).get();
		  if(inventory== null) {
			throw new Exception();  
		  }else {
			  inventoryRepository.deleteById(id);
		  }
	}
	
	 public void deleteInventory() {
			 inventoryRepository.deleteAll();
	}
	
	public void deductInventoryQuantity(Long id,int orderQty) throws Exception{
		 Inventory inventory = inventoryRepository.findById(id).get();
		  if(inventory== null) {
			throw new Exception();  
		  }else {
			  inventory.setInventoryOnHand(inventory.getInventoryOnHand()-orderQty);
			  inventoryRepository.save(inventory);
		  }
	}
	
}
