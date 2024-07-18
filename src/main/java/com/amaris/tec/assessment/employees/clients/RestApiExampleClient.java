package com.amaris.tec.assessment.employees.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.amaris.tec.assessment.employees.dto.EmployeeDTO;
import com.amaris.tec.assessment.employees.dto.RestApiExampleResponseDTO;

/**
 * RestApiExampleClient: Handles all requests made to RestApiExample.
 * 
 * @author Francisco Javier Guerrero Peláez.
 */
@FeignClient("rest-api-example")
public interface RestApiExampleClient {

    /**
     * Gets a list of employees en data variable of RestApiExample.
     * 
     * @return Object with API response.
     */
    @GetMapping(path = "/employees")
    RestApiExampleResponseDTO<List<EmployeeDTO>> getEmployees();

    /**
     * Gets a list of employees en data variable of RestApiExample.
     * 
     * @param id - Employee identification.
     * @return Object with API response
     */
    @GetMapping(path = "/employee/{id}")
    RestApiExampleResponseDTO<EmployeeDTO> getEmployeeById(@PathVariable String id);

}
