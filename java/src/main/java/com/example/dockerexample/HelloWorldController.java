package com.example.dockerexample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@GetMapping("/hello")
	public String getResponse() {
		return "Hello there!";
	}
	
	@GetMapping("/")
	public String defaultResponse() {
		return "This is /";
	}
}
