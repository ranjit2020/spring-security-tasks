package com.training.myapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public String homePage() {
		return "<h1>Home Page</h1>";
	}
	
	@GetMapping("/about")
	public String aboutPage() {
		return "<h1>About Page</h1>";
	}
}
