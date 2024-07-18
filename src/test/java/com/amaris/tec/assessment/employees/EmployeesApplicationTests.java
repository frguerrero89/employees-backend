package com.amaris.tec.assessment.employees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import lombok.RequiredArgsConstructor;

@SpringBootTest
@RequiredArgsConstructor
class EmployeesApplicationTests {

	private final ApplicationContext context;
	

	@Test
	void contextLoads() {
		Assertions.assertNotNull(context);
	}

}
