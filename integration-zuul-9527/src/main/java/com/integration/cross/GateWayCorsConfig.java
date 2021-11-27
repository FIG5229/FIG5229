package com.integration.cross;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Component
@Configuration
public class GateWayCorsConfig {

	@Bean
	public CorsFilter corsFilter() {
/*		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration corsConfiguration = new CorsConfiguration();
		// corsConfiguration.setAllowCredentials(true);
		corsConfiguration.addAllowedHeader("*");
		corsConfiguration.addAllowedOrigin("*");
		corsConfiguration.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(source);*/
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();  
        final CorsConfiguration config = new CorsConfiguration();  
        config.setAllowCredentials(true);  
        config.addAllowedOrigin("*");  
        config.addAllowedHeader("*");  
        //config.addAllowedMethod("OPTIONS");  
        //config.addAllowedMethod("HEAD");  
        //config.addAllowedMethod("GET");  
        //config.addAllowedMethod("PUT");  
        //config.addAllowedMethod("POST");  
        //config.addAllowedMethod("DELETE");  
        //config.addAllowedMethod("PATCH");  
        config.addAllowedMethod("*");  
        source.registerCorsConfiguration("/**", config);  
        return new CorsFilter(source);  
	}

}
