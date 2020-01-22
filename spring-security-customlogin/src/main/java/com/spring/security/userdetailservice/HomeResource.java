package com.spring.security.userdetailservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.security.userdetailservice.model.User;

@Controller
public class HomeResource {
	
	@Autowired
	UserRepository reposiory;

    @GetMapping("/")
    public String home() {
        return "index";
    }
    
    @RequestMapping("/home")
    public String goHome() {
    	return "index";
    }
    
    @RequestMapping("/login")
    public String loginPage() {
    	return "login";
    }
    
    @RequestMapping("/logout-success")
    public String logoutPage() {
    	return "logout";
    }

    @GetMapping("/user")
    public String user() {
        return ("<h1>Welcome User</h1>");
    }

    @GetMapping("/admin")
    @ResponseBody
    public String admin() {
        return ("<h1>Welcome Admin</h1>");
    }
    
    @PostMapping("/save-user")
    @ResponseBody
    public String saveUser(@RequestParam String username, @RequestParam String password, @RequestParam String role) {
    	User user = new User(username,password,role);
    	reposiory.save(user);
    	return "User Saved Successfully....";
    }
    
    @RequestMapping("/register")
    public String registerPage() {
    	return "register";
    }
}

