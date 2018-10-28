package com.frosters.controller;



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

import com.frosters.model.Vendor;
import com.frosters.repository.VendorRepository;

@RestController 
@RequestMapping("/vendorAPI")
public class VendorController {

	@Autowired
	VendorRepository vendorRepository;
	
	@GetMapping("/vendor")
	Iterable<Vendor> getAllVendors(){
		System.out.println(vendorRepository.findAll());
	 return vendorRepository.findAll();	
	}
	
	@GetMapping("/vendor/{id}")
	Vendor getVendor(@PathVariable("id") Long id) {
		return vendorRepository.getOne(id);
	}
	 
	@PostMapping("/vendor")
	@ResponseBody Vendor addNewVendor(@RequestBody Vendor vendor) {
		System.out.println("add new vendor");
		return vendorRepository.save(vendor);
	}
	
	@PutMapping("/vendor/{id}")
	@ResponseBody Vendor updateVendor(@PathVariable("id")  Long id, @RequestBody  Vendor updatedVendor) throws Exception {
		System.out.println("add updated vendor");
		Vendor vendor = vendorRepository.findById(id).get();
		  if(vendor== null) {
			throw new Exception();  
		  }else {
			  System.out.println(updatedVendor);
	            return vendorRepository.save(updatedVendor);
		  }
		
	}
	
	@DeleteMapping("/vendor/{id}")
   public void deleteVendor(@PathVariable("id")  Long id) throws Exception {
		  Vendor vendor = vendorRepository.findById(id).get();
		  if(vendor== null) {
			throw new Exception();  
		  }else {
			  vendorRepository.deleteById(id);
		  }
	}
	
	@DeleteMapping("/vendor")
	   public void deleteVendor() {
			 vendorRepository.deleteAll();
		}
}
