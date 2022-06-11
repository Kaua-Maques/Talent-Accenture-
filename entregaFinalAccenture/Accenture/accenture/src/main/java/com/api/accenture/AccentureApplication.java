package com.api.accenture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AccentureApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccentureApplication.class, args);
	}

	@GetMapping("/")
	public String index() {
		return "Olá do mundo!";
	}

}
