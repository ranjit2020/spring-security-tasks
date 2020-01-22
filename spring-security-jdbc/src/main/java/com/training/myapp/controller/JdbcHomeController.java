package com.training.myapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JdbcHomeController {


	@GetMapping("/")
	public String homePage() {
		return "<h1>Home Page</h1>";
	}
	
	@GetMapping("/about")
	public String aboutPage() {
		return "<h1>About Page</h1>";
	}
	
	@GetMapping("/user")
	public String userDashboardPage() {
		return "<h1>User Dashboard Page </h1";
	}
	
	@GetMapping("/admin")
	public String adminDashboardPage() {
		return "<h1>Admin Dashboard Page </h1";
	}
}
