package com.amaris.tec.assessment.employees.web.controller.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amaris.tec.assessment.employees.dto.EmployeeDTO;
import com.amaris.tec.assessment.employees.service.EmployeeService;

import feign.FeignException;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;

/**
 * Control requests about employees.
 * 
 * @author Francisco Javier Guerrero Peláez
 */
@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeesRestController {

    /**
     * Service that handles employees logic.
     */
    private final EmployeeService service;

    /**
     * Gets an employee by ID.
     * 
     * @param id - String provided as identification
     * @return Employee - Employee data
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/byId/{id}")
    @ApiResponse(description = "Returns an employee by id")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable String id) {
        ResponseEntity<EmployeeDTO> response;
        try {
            response = ResponseEntity.ok(service.getEmployee(id));
        } catch (FeignException ex) {
            response = ResponseEntity.status(ex.status()).build();
        } 
        return response;
    }

    /**
     * Gets all fetched employees and returns the list of.
     * 
     * @return List of employees from resourse.
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("")
    @ApiResponse(description = "Returns a list of employees")
    public ResponseEntity<List<EmployeeDTO>> getEmployees() {
        ResponseEntity<List<EmployeeDTO>> response;
        try {
            response = ResponseEntity.ok(service.getEmployees());
        } catch (FeignException ex) {
            response = ResponseEntity.status(ex.status()).build();
        } 
        return response;
    }

}
