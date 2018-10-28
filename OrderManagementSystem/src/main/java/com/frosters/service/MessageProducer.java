package com.frosters.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.frosters.model.Orders;



@Component
public class MessageProducer {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${jsa.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${jsa.rabbitmq.routingkey}")
	private String routingkey;

	public void produceMQMsg(Orders order){
		amqpTemplate.convertAndSend(exchange, routingkey, order);
		System.out.println("Send msg = " + order);
	}
}