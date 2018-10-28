package com.frosters.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.frosters.model.Orders;
import com.frosters.service.OrderService;


@RestController
@RequestMapping("/order")
public class OrderController {

/**
1.	GET /order/{custId} Get all Orders for a Customer
2.	POST /order/ Add new Order for a customer
3.	GET /order/{id} Get Order by Id
4.	PATCH /order/{id} Update Order status by Id
5.	DELETE /order/{id} Delete Order by Id
*/	
	
	@Autowired
	OrderService service;
	
	@GetMapping("/customer/{id}")
	public List<Orders> getOrdersOfCustomer(@PathVariable("id") Long id){
		return service.getOrdersOfCustomer(id);
	}
	
	@PostMapping("/addNewOrder")
	public Orders addNewOrder(@RequestBody Orders order) {
		return service.addNewOrder(order);
	}
	
	@GetMapping("/{id}")
	public Orders getOrderByID(@PathVariable("id") Long id) {
		return service.getOrderById(id);
	}
	
	@PatchMapping("/{id}")
	public Orders updateOrderStatus(@PathVariable("id") Long id) {
		try {
			System.out.println("inside update order status");
			return service.updateOrder(id);
			
		} catch (Exception e) {
			System.out.println("order status updation error");
			e.printStackTrace();
			return null;
		}
	}
	
	@DeleteMapping("/{id}")
	public void deleteOrderById(@PathVariable("id") Long orderId) {
		try {
			service.deleteOrder(orderId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
