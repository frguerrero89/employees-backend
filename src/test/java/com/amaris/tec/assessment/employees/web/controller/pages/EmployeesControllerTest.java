package com.amaris.tec.assessment.employees.web.controller.pages;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class EmployeesControllerTest {
    @Test
    void testIndex() {
        EmployeesController controller = new EmployeesController();
        String templateName = controller.index();
        assertEquals("index.html", templateName);
    }
}
