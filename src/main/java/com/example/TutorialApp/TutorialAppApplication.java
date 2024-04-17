package com.example.TutorialApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.example.TutorialApp.model"})
public class TutorialAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TutorialAppApplication.class, args);
	}

}
