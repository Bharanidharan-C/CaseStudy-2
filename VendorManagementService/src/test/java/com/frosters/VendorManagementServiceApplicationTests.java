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
import com.frosters.model.Vendor;



@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VendorManagementServiceApplicationTests {
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

	@Test
	public void test1_GetVendor() throws Exception{
		
		mockMVC.perform(get("/vendorAPI/vendor/0").accept(MediaType.APPLICATION_JSON)).andDo(print())
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.vendorId").value(0));
		
	}
	
	@Test
	public void test2_addVendor() throws Exception{
		Vendor vendor = new Vendor(Long.valueOf(3), "vendor2", Long.valueOf(1234567890), "123@xx.com", "vendor2", "chennai");
		
		String requestJSON = toJson(vendor);
		mockMVC.perform(post("/vendorAPI/vendor").content(requestJSON).contentType(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk());
		mockMVC.perform(get("/vendorAPI/vendor/3")).andExpect(status().isOk()).andDo(print())
				.andExpect(MockMvcResultMatchers.jsonPath("$.vendorId").value(3));
	
	}
	
	@Test
	public void test3_UpdateVendor() throws Exception{
		Vendor vendor = new Vendor(Long.valueOf(1), "vendor2", Long.valueOf(1234567890), "123@xx.com", "vendor2", "chennai");
	String requestJSON = toJson(vendor);
		System.out.println("requestJSON"+requestJSON);
		mockMVC.perform(put("/vendorAPI/vendor/1").content(requestJSON).contentType(MediaType.APPLICATION_JSON)).andDo(print())
			.andExpect(status().isOk());
		mockMVC.perform(get("/vendorAPI/vendor/1")).andExpect(status().isOk()).andDo(print())
			.andExpect(MockMvcResultMatchers.jsonPath("$.vendorContactNo").value(1234567890));
	
	}
	
	@Test	
	public void testz4_DeleteVendor() throws Exception{
		mockMVC.perform(delete("/vendorAPI/vendor/1")).andExpect(status().isOk());
		mockMVC.perform(delete("/vendorAPI/vendor")).andExpect(status().isOk());
	}
	

	 private String toJson(Object r) throws Exception {
	        ObjectMapper map = new ObjectMapper();
	        return map.writeValueAsString(r);
	    }

	
}
