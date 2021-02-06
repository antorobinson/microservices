package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class BookApplication {
	
	@GetMapping("/get-book")
	public String getMethod() {
		return "Inside Book Service";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
	}

}
