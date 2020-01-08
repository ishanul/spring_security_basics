package com.ishan.security.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder);
		//In memory authentication..
//		auth
//		.inMemoryAuthentication()
//		.passwordEncoder(passwordEncoder)
//		.withUser("ishan")
//		.password("$2a$10$.NJ0Ku8hDM5TTu44HbA15OMEX258tdD6ogNSA25R.rY5VtlQLdC2e")
//		.roles("USER", "ADMIN");
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		//.csrf().disable()
		.authorizeRequests()
		.antMatchers("/admin/**")
		.hasAnyRole("ADMIN")
		.anyRequest()
		.hasAnyRole("USER").and()
		.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/dashboard")
		.permitAll();
		
	}
}
