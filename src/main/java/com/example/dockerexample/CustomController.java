package com.example.dockerexample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomController {
	
	@GetMapping("/echo/{name}")
	public String sayName(@PathVariable String name) {
		return "Hello there, " + name;
	}
	
	/**
	 * Avoid this endpoint!
	 */
	@GetMapping("/kill")
	public void logicBomb() {
		System.out.println("GOODBYE >:)");
		System.exit(0);
	}
}
