package com.enviro.assessment.grad001.zannymaholobela;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Main entry point for the Sustainable Waste Management API application.
 * This application provides functionalities to manage waste sustainably.
 */
@SpringBootApplication
@EnableCaching // Enable Spring caching support
public class SustainableWasteManagementApiApplication {
	/**
	 * Starts the Spring Boot application.
	 *
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		//Starts the spring-boot application
		SpringApplication.run(SustainableWasteManagementApiApplication.class, args);
	}
}