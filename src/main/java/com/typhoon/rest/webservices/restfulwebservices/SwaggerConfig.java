package com.typhoon.rest.webservices.restfulwebservices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// Configuration
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    // This Bean will controll which class in a package is documented
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2);
    }
}