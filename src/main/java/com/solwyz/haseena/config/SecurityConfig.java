package com.solwyz.haseena.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import



@Configuration
public class SecurityConfig {

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .cors() // enable CORS
//            .and()
//            .csrf().disable()
//            .authorizeHttpRequests(auth -> auth
//                .anyRequest().permitAll()
//            );
//
//        return http.build();
//    }
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http
	        .cors()  // Enable CORS
	        .and()
	        .csrf().disable()
	        .authorizeHttpRequests(auth -> auth.anyRequest().permitAll());

	    return http.build();
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
	    CorsConfiguration config = new CorsConfiguration();

	    config.setAllowedOrigins(List.of(
	        "http://localhost:3000",
	        "https://solwyz.medocpharmacy.com",
	        "https://haziproducts.com"
	    ));

	    config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));

	    // Instead of *, specify typical headers you expect:
	    config.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));

	    config.setAllowCredentials(true);

	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", config);

	    return source;
	}
}