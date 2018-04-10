package com.rest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.rest.domain.Data;
import com.rest.util.DocumentService;
import com.rest.util.HTTPClient;
import com.rest.util.JsonService;

@SpringBootApplication
@ComponentScan("com.rest.util")
@EntityScan("com.rest.domain")
@EnableJpaRepositories("com.rest.dao")
public class Application implements CommandLineRunner {

	@Autowired
	DataSource dataSource;
	@Autowired
	HTTPClient httpClient;
	@Autowired
	DocumentService documentService;
	@Autowired
	JsonService jsonService;
	
	public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
	
	@Override
	public void run(String... args) throws Exception {
		
		String jsonData = httpClient.doGetRequest(
				"https://lb.api-sandbox.openprocurement.org/api/2.4/contracts/6aa21ab58b0f402591ef4cc6abebe6c3/documents");
		
		Data data = jsonService.JsonDeserialisation(jsonData);
		documentService.saveDocument(data);
		
		
	}
	
}
