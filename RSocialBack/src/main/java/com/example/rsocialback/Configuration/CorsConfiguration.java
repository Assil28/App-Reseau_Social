package com.example.rsocialback.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CorsConfiguration {

    private static final String GET = "GET";
    private static final String PUT = "PUT";
    private static final String DELETE = "DELETE";
    private static final String POST = "POST";

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry
                                                registry) {

                registry.addMapping("/**")
                        .allowedMethods(GET, PUT, DELETE, POST)
                        .allowedHeaders("*")
                        .allowedOriginPatterns("*")
                        .allowedOrigins("http://localhost:4200")
                        .allowCredentials(true);


            }
        };
    }

}