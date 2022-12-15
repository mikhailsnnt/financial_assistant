package com.gb.tech.apioperation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApiOperationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiOperationApplication.class, args);
	}

}
