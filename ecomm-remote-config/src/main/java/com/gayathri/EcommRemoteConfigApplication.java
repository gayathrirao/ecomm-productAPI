package com.gayathri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class EcommRemoteConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommRemoteConfigApplication.class, args);
	}

}

