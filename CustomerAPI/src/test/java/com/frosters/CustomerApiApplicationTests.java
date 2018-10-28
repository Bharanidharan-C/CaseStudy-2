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
import com.frosters.model.Customer;



@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerApiApplicationTests {
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
	public void test_2_RetrieveAllCustomer() throws Exception {
		mockMVC.perform(get("/customerAPI/customer")).andDo(print())
		.andExpect(status().isOk());
	
	
	}
	
	@Test
	public void test_1_GetCustomer() throws Exception{
		
		mockMVC.perform(get("/customerAPI/customer/0")).andDo(print())
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.customerId").value(0));
		
	}
	
	@Test
	public void test_3_addCustomer() throws Exception{
		Customer customer = new Customer();
		customer.setCustomerId(Long.valueOf(2));
		customer.setCustomerName("Akash");
		customer.setAddress("Chennai");
		customer.setContactNumber(Long.valueOf(1234567890));
		customer.setGender("male");
		String requestJSON = toJson(customer);
		mockMVC.perform(post("/customerAPI/customer").content(requestJSON).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		mockMVC.perform(get("/customerAPI/customer/2")).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.customerId").value(2));
	
	}
	
	@Test
	public void test_4_UpdateCustomer() throws Exception{
		Customer customer = new Customer(Long.valueOf(0), "Anu",Long.valueOf(1234567891), "Chennai", "Female");
	String requestJSON = toJson(customer);
		System.out.println("requestJSON"+requestJSON);
		mockMVC.perform(put("/customerAPI/customer/1").content(requestJSON).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
		mockMVC.perform(get("/customerAPI/customer/1")).andExpect(status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$.contactNumber").value(1234567891));
	
	}
	
	@Test
	public void test_5_DeleteCustomer() throws Exception{
		mockMVC.perform(delete("/customerAPI/customer/1")).andExpect(status().isOk());
		mockMVC.perform(delete("/customerAPI/customer")).andExpect(status().isOk());
	}
	

	 private String toJson(Object r) throws Exception {
	        ObjectMapper map = new ObjectMapper();
	        return map.writeValueAsString(r);
	    }

}
