package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloWorldApplication {

	@RequestMapping("/Messages")
	String home()
	{
		return "Hello Anand!! How are you ?";
	}
	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}
}
