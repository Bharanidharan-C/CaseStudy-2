package com.frosters.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frosters.model.OrderLineItem;
import com.frosters.model.Orders;
import com.frosters.repository.LineItemRepository;
import com.frosters.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	LineItemRepository lineItemRepository;
	
	@Autowired
	MessageProducer msgProducer;
	
	@Autowired
	EmailService emailService;
	
	
	public List<Orders> getOrdersOfCustomer(Long customerId){
		return orderRepository.findByCustomerId(customerId);
	}
	
	public Orders getOrderById(Long order) {
		return orderRepository.findById(order).get();
	}
	

	@Transactional(rollbackFor = Exception.class)
	public Orders addNewOrder(Orders orderRequest)
	{
		
		List<OrderLineItem> lineItems = orderRequest.getLineItems();
		Orders order= orderRepository.save(orderRequest);
		
		//order.setLineItems(null);
		
		lineItems.forEach(lineItem -> {
				lineItem.setOrder(order);
				lineItemRepository.save(lineItem);
			});
		emailService.sendOrderConfirmationEmail(order);
		msgProducer.produceMQMsg(order);
		return order;
	}
	
	
	public Orders updateOrder(Long orderId) throws Exception{
		Orders order = orderRepository.findById(orderId).get();
		order.setOrderStatus("SHIPPED");
		orderRepository.save(order);
		return order;
	}
	
	public void deleteOrder(Long orderId) throws Exception {
		lineItemRepository.deleteByOrder(orderRepository.findById(orderId).get());
	}
	
	
}
