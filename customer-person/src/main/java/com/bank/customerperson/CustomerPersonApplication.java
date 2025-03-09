package com.bank.customerperson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CustomerPersonApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerPersonApplication.class, args);
	}

}
