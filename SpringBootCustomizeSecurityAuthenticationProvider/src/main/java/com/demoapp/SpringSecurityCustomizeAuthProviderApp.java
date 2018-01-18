package com.demoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@SpringBootApplication
public class SpringSecurityCustomizeAuthProviderApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityCustomizeAuthProviderApp.class, args);
	}
}
