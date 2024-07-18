package com.amaris.tec.assessment.employees;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * EmployeesApplication: Main class for application.
 * @author Francisco Javier Guerrero Peláez
 */
@SpringBootApplication
@EnableFeignClients
public class EmployeesApplication {

	/**
	 * Runs the application with the given arguments.
	 * @param args application arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(EmployeesApplication.class, args);
	}

}
