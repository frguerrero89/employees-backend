package com.amaris.tec.assessment.employees.web.controller.api;

import java.util.HashMap;
import java.util.List;

import org.instancio.Instancio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.amaris.tec.assessment.employees.dto.EmployeeDTO;
import com.amaris.tec.assessment.employees.service.EmployeeService;

import feign.FeignException;
import feign.Request;
import feign.RequestTemplate;

@SpringBootTest
class EmployeesRestControllerTest {

    @Mock
    EmployeeService service;
    @InjectMocks
    EmployeesRestController controller;
    private EmployeeDTO employee = null;
    private List<EmployeeDTO> employees = null;

    @BeforeEach
    void setUp(){
        employee = Instancio.create(EmployeeDTO.class);
        employees = Instancio.ofList(EmployeeDTO.class).size(3).create();
    }

    @Test
    void testGetEmployeeById() {
        Mockito.when(service.getEmployee(ArgumentMatchers.anyString())).thenReturn(employee);
        var result = controller.getEmployeeById("11");
        Mockito.verify(service, Mockito.atLeastOnce()).getEmployee("11");
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertEquals(employee, result.getBody());
    }

    @Test
    void testGetEmployeeByIdManyRequests() {
        Request request = Request.create(Request.HttpMethod.GET, "url", new HashMap<>(), null, new RequestTemplate());
        Mockito.when(service.getEmployee(ArgumentMatchers.anyString())).thenThrow(new FeignException.TooManyRequests("",request, null, null));
        var result = controller.getEmployeeById("11");
        Mockito.verify(service, Mockito.atLeastOnce()).getEmployee("11");
        Assertions.assertEquals(HttpStatus.TOO_MANY_REQUESTS, result.getStatusCode());
    }

    @Test
    void testGetEmployees() {
        Mockito.when(service.getEmployees()).thenReturn(employees);
        var result = controller.getEmployees();
        Mockito.verify(service, Mockito.atLeastOnce()).getEmployees();
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertEquals(employees, result.getBody());
    }

    @Test
    void testGetEmployeesManyRequests() {
        Request request = Request.create(Request.HttpMethod.GET, "url", new HashMap<>(), null, new RequestTemplate());
        Mockito.when(service.getEmployees()).thenThrow(new FeignException.TooManyRequests("",request, null, null));
        var result = controller.getEmployees();
        Mockito.verify(service, Mockito.atLeastOnce()).getEmployees();
        Assertions.assertEquals(HttpStatus.TOO_MANY_REQUESTS, result.getStatusCode());
    }
}
