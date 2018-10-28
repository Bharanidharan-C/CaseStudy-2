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

import com.frosters.model.Customer;
import com.frosters.repository.CustomerRepository;

@RestController 
@RequestMapping("/customerAPI")
public class CustomerController {

	@Autowired
	CustomerRepository customerRepository;
	
	@GetMapping("/customer")
	List<Customer> getAllCustomers(){
	 return customerRepository.findAll();	
	}
	
	@GetMapping("/customer/{id}")
	Customer getCustomer(@PathVariable("id") Long id) {
		return customerRepository.getOne(id);
	}
	 
	@PostMapping("/customer")
	@ResponseBody Customer addNewCustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}
	
	@PutMapping("/customer/{id}")
	@ResponseBody Customer updateCustomer(@PathVariable("id")  Long id, @RequestBody  Customer updatedCustomer) throws Exception {
		Customer customer = customerRepository.findById(id).get();
		  if(customer== null) {
			throw new Exception();  
		  }else {
			  System.out.println(updatedCustomer);
	            return customerRepository.save(updatedCustomer);
		  }
		
	}
	
	@DeleteMapping("/customer/{id}")
   public void deleteCustomer(@PathVariable("id")  Long id) throws Exception {
		  Customer customer = customerRepository.findById(id).get();
		  if(customer== null) {
			throw new Exception();  
		  }else {
			  customerRepository.deleteById(id);
		  }
	}
	
	@DeleteMapping("/customer")
	   public void deleteCustomer() {
			 customerRepository.deleteAll();
		}
}
