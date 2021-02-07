package com.anto.info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MovieInfoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MovieInfoApplication.class, args);
	}

}
