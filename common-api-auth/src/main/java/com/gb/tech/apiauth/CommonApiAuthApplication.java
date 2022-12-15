package com.gb.tech.apiauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CommonApiAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommonApiAuthApplication.class, args);
	}

}
