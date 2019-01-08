package com.gayathri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class EcommUserApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommUserApiApplication.class, args);
	}

}

