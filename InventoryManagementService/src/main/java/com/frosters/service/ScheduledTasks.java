package com.frosters.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpMethod;

import com.frosters.model.Inventory;
import com.frosters.model.OrderLineItem;
import com.frosters.model.Orders;
import com.frosters.repository.InventoryRepository;

@Component
public class ScheduledTasks {
	
	@Autowired
	InventoryRepository repo;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${addNewOrderAPIURL}")
	String addNewOrderAPIURL;
	
	@Scheduled(fixedRate = 300000)
	public void makeSureMinQunatity() {
		System.out.println("scheduler running for every 1 min");
		List<Inventory> iventoriesOnShortage = repo.findProductsOnShortage();
		placeAnOrder(iventoriesOnShortage);
	
	}



	public void placeAnOrder(List<Inventory> inventoryList) {
		
		
	    ArrayList<OrderLineItem> lineItemList = new ArrayList<OrderLineItem>();
	    
	    inventoryList.forEach(inventory ->{
	    	lineItemList.add( new OrderLineItem(inventory.getSkuId(),inventory.getMinQtyReq()));
	    });
	    
	  
		 Orders testOrder = new Orders(Long.valueOf(1), "cash", true, "confirmed", System.currentTimeMillis(), Long.valueOf(1000), "xxx", lineItemList);
		
		Orders response= restTemplate.postForObject(addNewOrderAPIURL, testOrder, Orders.class);
		System.out.println(response.toString());
	}
	
}
