package com.ejemplo2.divinaComedia.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"com.ejemplo2.divinaComedia.demo.model"})
@SpringBootApplication
public class DivinaComediaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DivinaComediaApplication.class, args);
	}

}
