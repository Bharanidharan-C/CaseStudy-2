package com.frosters.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.frosters.model.Inventory;
import com.frosters.repository.InventoryRepository;
import com.frosters.service.InventoryService;

@RestController 
@RequestMapping("/inventoryAPI")
public class InventoryController {

	@Autowired
	InventoryService inventoryService;
	
	@GetMapping("/inventory")
	List<Inventory> getAllInventorys(){
	 return inventoryService.getAllInventorys();	
	}
	
	@GetMapping("/inventory/{id}")
	Inventory getInventory(@PathVariable("id") Long id) {
		return inventoryService.getInventory(id);
	}
	 
	@PostMapping("/inventory")
	@ResponseBody Inventory addNewInventory(@RequestBody Inventory inventory) {
		return inventoryService.addNewInventory(inventory);
	}
	
	@PutMapping("/inventory/{id}")
	@ResponseBody Inventory updateInventory(@PathVariable("id")  Long id, @RequestBody  Inventory updatedInventory) throws Exception {
		return inventoryService.updateInventory(id,updatedInventory);
	}
	
	@DeleteMapping("/inventory/{id}")
   public void deleteInventory(@PathVariable("id")  Long id) throws Exception {
		 inventoryService.deleteInventory(id);
	}
	
	@DeleteMapping("/inventory")
	   public void deleteInventory() {
			 inventoryService.deleteInventory();
		}
}
