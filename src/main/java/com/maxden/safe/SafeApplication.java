package com.maxden.safe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class SafeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SafeApplication.class, args);
	}

}
