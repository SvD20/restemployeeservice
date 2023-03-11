package com.svyatdanilov.rest_employee_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication
public class RestEmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestEmployeeServiceApplication.class, args);
	}

}
