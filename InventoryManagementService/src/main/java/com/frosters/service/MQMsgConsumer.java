package com.frosters.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.frosters.model.Orders;

@Component
public class MQMsgConsumer {
	
	@Autowired
	InventoryService inventoryService;
	
	@RabbitListener(queues="${jsa.rabbitmq.queue}", containerFactory="jsaFactory")
    public void recievedMessage(Orders order) {
		order.getLineItems().forEach(lineitem ->{
		      try {
				inventoryService.deductInventoryQuantity(lineitem.getSkuId(), lineitem.getItemQty());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
    }
}