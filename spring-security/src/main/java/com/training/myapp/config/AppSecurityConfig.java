package com.training.myapp.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	//implementaion for Authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication()
		.withUser("alex")
		.password("alex@123")
		.roles("USER")
		.and()
		.withUser("admin")
		.password("admin@123")
		.roles("ADMIN");
	}
	
		//This method is for Authorization
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
			.antMatchers("/admin/**").hasRole("ADMIN")
			.antMatchers("/user/**").hasAnyRole("ADMIN","USER")
			.antMatchers("/**").permitAll()
			.and().formLogin();
			super.configure(http);
		}
	

}
