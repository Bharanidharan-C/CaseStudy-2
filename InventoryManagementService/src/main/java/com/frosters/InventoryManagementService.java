package com.frosters;

import java.util.Date;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import com.frosters.model.Inventory;
import com.frosters.service.Step1Configuration;

@EnableBatchProcessing
@EnableScheduling
@SpringBootApplication
public class InventoryManagementService {

	
	@Bean
	Job job(JobBuilderFactory jbf, StepBuilderFactory sbf , Step1Configuration config) throws Exception {
		
		Step step = sbf.get("file-db")
				.<Inventory, Inventory>chunk(5)
				.reader(config.fileReader())
				.writer(config.repositoryItemWriter())
				.build();
		
		return jbf.get("etl")
				.incrementer(new RunIdIncrementer())
				.flow(step)
				.end()
				.build();
		
	}
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(InventoryManagementService.class, args);
	}
}
