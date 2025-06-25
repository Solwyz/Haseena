package com.solwyz.haseena.config;

import java.util.List;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;

import io.swagger.v3.oas.models.OpenAPI;

import io.swagger.v3.oas.models.security.SecurityRequirement;

import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;

@Configuration

public class OpenAPI30Configuration {
 
	@Bean
 
	public OpenAPI customizeOpenAPI() {
 
		final String securitySchemeName = "bearerAuth";
 
		return new OpenAPI()
 
				.addSecurityItem(new SecurityRequirement()
 
						.addList(securitySchemeName))
 
				.components(new Components()
 
						.addSecuritySchemes(securitySchemeName, new SecurityScheme()
 
								.name(securitySchemeName)
 
								.type(SecurityScheme.Type.HTTP)
 
								.scheme("bearer")
 
								.bearerFormat("JWT")));
 
	}
 
}
