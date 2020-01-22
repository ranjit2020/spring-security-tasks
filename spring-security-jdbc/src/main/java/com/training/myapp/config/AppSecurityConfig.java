package com.training.myapp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	/*
	 * //implementaion for Authentication
	 * 
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * 
	 * auth.jdbcAuthentication() .dataSource(dataSource) .withDefaultSchema()
	 * .withUser(User.withUsername("alex") .password("") .roles("USER"))
	 * .withUser(User.withUsername("admin") .password("admin@123")
	 * .roles("ADMIN","USER")); }
	 * 
	 * //This method is for Authorization
	 * 
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.authorizeRequests() .antMatchers("/admin/**").hasRole("ADMIN")
	 * .antMatchers("/user/**").hasAnyRole("ADMIN","USER")
	 * .antMatchers("/**").permitAll() .and().formLogin(); super.configure(http); }
	 */
	
	//implementaion for Authentication
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			
			auth.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery("select username,password,enabled from my_users where username = ?")
			.authoritiesByUsernameQuery("select username,authority from user_authorities where username = ?");
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
