package com.frosters.service;


import org.springframework.batch.item.data.RepositoryItemWriter;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.frosters.model.Inventory;
import com.frosters.repository.InventoryRepository;
import org.springframework.core.io.ClassPathResource;

	@Configuration
	public class Step1Configuration {
		
		@Autowired
		InventoryRepository inventoryRepo;

		@Bean
		public FlatFileItemReader<Inventory> fileReader() throws Exception {

			return new FlatFileItemReaderBuilder<Inventory>()
					.name("file-reader")
					.resource(new ClassPathResource("BatchProcessingData.csv"))
					.targetType(Inventory.class)
					.delimited().delimiter(",").names(new String[]{"skuId", "productName", "productLabel","inventoryOnHand","minQtyReq","price"})
					.build();
		}
		
		@Bean
		public RepositoryItemWriter<Inventory> repositoryItemWriter() {
			RepositoryItemWriter<Inventory> writer = new RepositoryItemWriter<Inventory>();
	        writer.setRepository(inventoryRepo);
	        writer.setMethodName("save");
			return writer;
		}
	}

	