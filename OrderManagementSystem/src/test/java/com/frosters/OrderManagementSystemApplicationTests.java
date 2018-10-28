package com.frosters;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.frosters.model.OrderLineItem;
import com.frosters.model.Orders;
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderManagementSystemApplicationTests {
	
	private MockMvc mockMVC;
	
	
	@Autowired
	WebApplicationContext context;

	@Test
	public void contextLoads() {
	}
	
	@Before
	public void setUp() {
		mockMVC = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	 private String toJson(Object r) throws Exception {
	        ObjectMapper map = new ObjectMapper();
	        return map.writeValueAsString(r);
	    }
	 
	 @Test
		public void test1addOrder() throws Exception{
		 
		 
		 OrderLineItem lineItem1 = new OrderLineItem(Long.valueOf(1),1);
		 
		 OrderLineItem lineItem2 = new OrderLineItem(Long.valueOf(2),2);
		 List<OrderLineItem> lineItemList = Arrays.asList(lineItem1,lineItem2);
		
		 
		 Orders testOrder = new Orders(Long.valueOf(1), "cash", true, "confirmed", System.currentTimeMillis(), Long.valueOf(1000), "xxx", lineItemList);
		
		 
		
			String requestJSON = toJson(testOrder);
			System.out.println("RequestJson" + requestJSON);
		
			mockMVC.perform(post("/order/addNewOrder").content(requestJSON).contentType(MediaType.APPLICATION_JSON)).andDo(print())
					.andExpect(status().isOk());
			mockMVC.perform(get("/order/1")).andExpect(status().isOk())
					.andExpect(MockMvcResultMatchers.jsonPath("$.orderId").value(1));
		
		}
	 
	 @Test
		public void tes2GetInventory() throws Exception {
		
		 mockMVC.perform(get("/order/1")).andExpect(status().isOk()).andDo(print())
			.andExpect(MockMvcResultMatchers.jsonPath("$.orderId").value(1));
		 
		 mockMVC.perform(get("/order/customer/1")).andExpect(status().isOk()).andDo(print())
			.andExpect(MockMvcResultMatchers.jsonPath("$.[0].orderId").value(1));
		 
		}
	 
	 @Test
		public void tes3updateInventory() throws Exception {
		
		 mockMVC.perform(patch("/order/1")).andExpect(status().isOk()).andDo(print())
		 .andExpect(MockMvcResultMatchers.jsonPath("$.orderStatus").value("SHIPPED"));
		 
		 
		}
	 
	 @Test
		public void tes4DeleteInventory() throws Exception {
		 mockMVC.perform(delete("/order/1")).andExpect(status().isOk()).andDo(print());
		}
	 

}
