package com.frosters.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.frosters.model.Orders;

@Service
public class EmailService {
	
	
	@Value("${emailServerURL}")
	private String emailServerURL;
 
	void sendOrderConfirmationEmail(Orders order) {
		//RestTemplate restTemplate = new RestTemplate();
	//restTemplate.postForObject(emailServerURL, order, String.class); 
 }

}
