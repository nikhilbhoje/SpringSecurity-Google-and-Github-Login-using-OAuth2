package com.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		this specifies that any request coming should be authenticated otherwise the request will bypass the security and all the
//		resources can be accessed
//		using oauth2 we are specifying that we want to login through oauth2
		http.authorizeHttpRequests(auth->auth.anyRequest().authenticated())
		.oauth2Login(Customizer.withDefaults());
		
//		the build method returns the object of security filter chain
		return http.build();
	}

}
