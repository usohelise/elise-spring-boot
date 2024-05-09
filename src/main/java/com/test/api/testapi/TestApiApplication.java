package com.test.api.testapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TestApiApplication {

	@GetMapping("/deployed")
	public String message(){
		return "Elise's spring boot application status: Deployed to Azure";
	}

	public static void main(String[] args) {
		SpringApplication.run(TestApiApplication.class, args);
	}

}
