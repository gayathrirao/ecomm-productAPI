package com.gayathri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EcommProductApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommProductApiApplication.class, args);
	}

}

