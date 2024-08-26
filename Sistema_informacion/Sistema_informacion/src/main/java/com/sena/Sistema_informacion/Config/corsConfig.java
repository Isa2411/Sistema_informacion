package com.sena.Sistema_informacion.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class corsConfig {
	
	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration Config = new CorsConfiguration();
		
		Config.addAllowedOrigin("*");
		
		Config.addAllowedMethod("GET");
		Config.addAllowedMethod("POST");
		Config.addAllowedMethod("PUT");
		Config.addAllowedMethod("DELETE");
		
		Config.addAllowedHeader("Authorization");
		Config.addAllowedHeader("Content-Type");
		
		source.registerCorsConfiguration("/**", Config);
		return new CorsFilter(source);
		
	}

}
