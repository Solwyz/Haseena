//package com.solwyz.haseena.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("http://localhost:3000") // or "*"
//                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
//                .allowedHeaders("*")
//                .allowCredentials(true);
//    }
//}

//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
// 
//@Configuration
//@EnableWebMvc
//@Component
//public class WebConfig implements WebMvcConfigurer {
// 
//	@Autowired
//	PrivilegeInterceptor privilegeInterceptor;
// 
//	

//	    @Override
//	    public void addCorsMappings(CorsRegistry registry) {
//	        registry.addMapping("/**")
//	            .allowedOrigins("http://localhost:3000")
//	            .allowedMethods("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
//	            .allowedHeaders("*")
//	            .allowCredentials(true);
//	    }
//
//	    @Override
//	    public void addInterceptors(InterceptorRegistry registry) {
//	        registry.addInterceptor(privilegeInterceptor)
//	            .excludePathPatterns("/v3/api-docs", "/v3/api-docs/*",
//	                "/swagger-ui.html", "/swagger-ui/**", "/static/**", "/api/auth/sendpdf", "/js/**", "/webjars/**");
//	    }
//	}

//	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**").allowedMethods("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS");
//	}
// 
	
//****************************************************************	
//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//	    registry.addMapping("/**")
//	            .allowedOrigins("*") // ⚠️ Only for development!
//	            .allowedMethods("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
//	            .allowedHeaders("*")
//	            .allowCredentials(false);
//	}
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(privilegeInterceptor).excludePathPatterns("/v3/api-docs", "/v3/api-docs/*",
//				"/swagger-ui.html", "/swagger-ui/**", "/static/**", "/api/auth/sendpdf", "/js/**", "/webjars/**");
//	}
//}
