package com.frosters;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.frosters.model.Inventory;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InventoryManagementServiceTests {
	
	private MockMvc mockMVC;
	
	@Autowired
	WebApplicationContext context;
	
	@Before
	public void setUp() {
		mockMVC = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void contextLoads() {
	}
	@Test
	public void test_12_GetInventory() throws Exception {
	
		mockMVC.perform(get("/inventoryAPI/inventory/5")).andDo(print())
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.skuId").value(5));
	}
	
	@Test
	public void test_13_addInventory() throws Exception{
		Inventory inventory = new Inventory(Long.valueOf(2),"MI A2","MI ANDROID ONE VERSION 2.0", 10, 3, 16000.00);
		String requestJSON = toJson(inventory);
		mockMVC.perform(post("/inventoryAPI/inventory").content(requestJSON).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		mockMVC.perform(get("/inventoryAPI/inventory/2")).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.skuId").value(2));
	
	}
	
	@Test
	public void test_14_UpdateInventory() throws Exception{
		Inventory inventory = new Inventory(Long.valueOf(1),"MI A1","MI ANDROID ONE VERSION", 10, 3, 15000.00);
		String requestJSON = toJson(inventory);
		System.out.println("requestJSON"+requestJSON);
		mockMVC.perform(put("/inventoryAPI/inventory/1").content(requestJSON).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
		mockMVC.perform(get("/inventoryAPI/inventory/1")).andExpect(status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$.price").value(15000.00));
	
	}
	
	@Test
	public void test_15_DeleteInventory() throws Exception{
		mockMVC.perform(delete("/inventoryAPI/inventory/1")).andExpect(status().isOk());
		mockMVC.perform(delete("/inventoryAPI/inventory")).andExpect(status().isOk());
	}


	 private String toJson(Object r) throws Exception {
	        ObjectMapper map = new ObjectMapper();
	        return map.writeValueAsString(r);
	    }

}
