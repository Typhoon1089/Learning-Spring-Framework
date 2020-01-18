package com.typhoon.rest.webservices.restfulwebservices;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
// import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.LocaleResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class RestfulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}

  // // Create a bean to resolve the locate with default as US 
  // // It will be revoked when transfering param "locate" to the controller
	// @Bean
	// public LocaleResolver localeResolver() {
	// 	SessionLocaleResolver localeResolver = new SessionLocaleResolver();
	// 	localeResolver.setDefaultLocale(Locale.US);
	// 	return localeResolver;
	// }

	@Bean
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

	/** 
	 * This could be remove because we already configured
	 * spring.messages.basename=messages
	 */
	// // This will handle the message resource, 
	// // It is used to lookup all the property files and return a proper message.
	// @Bean
	// public ResourceBundleMessageSource messageSource() {
  //   ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
  //   // This will refer the all files that starts with "messages"
	// 	messageSource.setBasename("messages");
	// 	return messageSource;
	// }

}
