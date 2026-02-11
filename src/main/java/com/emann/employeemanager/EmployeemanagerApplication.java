package com.emann.employeemanager;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class EmployeemanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeemanagerApplication.class, args);
	}

	@Bean
    public CorsFilter corsFilter() {
        // Create a CORS configuration object
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); // allow cookies
        config.setAllowedOrigins(Arrays.asList("http://localhost:3000")); // allow frontend URL
        config.setAllowedHeaders(Arrays.asList("*")); // allow all headers
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")); // allow HTTP methods
        config.setExposedHeaders(Arrays.asList("Authorization", "content-type")); // headers that browsers can access

        // Map configuration to URL patterns
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}
