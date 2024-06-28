package com.Publication.Publication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.Publication.Publication.Model.UserPublications;
import com.Publication.Publication.repository.UserRepository;

@EnableWebSecurity
@Configuration
public class PublicationConfiguration {
	@Autowired

	private UserRepository userRepository;

	@Autowired
	public CustomAuthenticationSuccessHandler successhandler;

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsService() {
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				// TODO Auto-generated method stub
				System.out.println("User Name :- "+username);
				UserPublications user = userRepository.findByEmail(username);
				System.out.println("Find User By email :- "+user);

				if(user==null) {
					throw new UsernameNotFoundException("User not found.");
				}
				return new CustomUsers(user);
			}
		};
	}

	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeHttpRequests()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.successHandler(successhandler)
		.permitAll()
		.and()
		.logout()
		.permitAll();

		return http.build();
	}



}
