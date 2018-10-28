package com.frosters.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
	
	
	@Value("${order-api-pwd}")
	String password;
	

	@Value("${order-api-username}")
	String username;
	
	
    @Bean
    public RestTemplate myRestTemplate(RestTemplateBuilder builder) {
    	
        return builder            
                .basicAuthorization(username,password)
                .build();
    }

}