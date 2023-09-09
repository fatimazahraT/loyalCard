package com.example.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {

		SpringApplication.run(AppApplication.class, args);

	}
	@Bean
	public CorsFilter filter() {
		UrlBasedCorsConfigurationSource url = new UrlBasedCorsConfigurationSource();
		CorsConfiguration conf = new CorsConfiguration();
		conf.setAllowCredentials(true);
		ArrayList<String> allowedIP = new ArrayList<>();
		allowedIP.add("http://localhost:4200");



		conf.setAllowedOrigins(allowedIP);
		conf.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With", "Access-Control-Request-Method", "Access-Control-Request-Headers"));
		conf.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization", "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		conf.setAllowedMethods(Arrays.asList("GET", "POST", "PUT","PATCH", "DELETE", "OPTIONS"));
		url.registerCorsConfiguration( "/**", conf);
		return new CorsFilter(url);
	}
}
