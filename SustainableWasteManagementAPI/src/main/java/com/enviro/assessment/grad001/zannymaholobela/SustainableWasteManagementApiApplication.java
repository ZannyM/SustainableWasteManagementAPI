package com.enviro.assessment.grad001.zannymaholobela;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SustainableWasteManagementApiApplication {

	public static void main(String[] args) {
		//Starts the spring-boot application
		SpringApplication.run(SustainableWasteManagementApiApplication.class, args);
	}

}


// curl -X POST -H "Content-Type: application/json" -d '{"name": "Plastic", "description": "Non-biodegradable waste"}'
// http://localhost:8080/api/waste-categories
// mvn spring-boot:run