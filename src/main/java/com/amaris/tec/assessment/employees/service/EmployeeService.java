package com.amaris.tec.assessment.employees.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.amaris.tec.assessment.employees.clients.RestApiExampleClient;
import com.amaris.tec.assessment.employees.dto.EmployeeDTO;

import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * EmployeeService: handles the employees logic.
 * 
 * @author Francisco Javier Guerrero Peláez
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeService {
    /** MONTHS_PER_YEAR. */
    private static final int MONTHS_PER_YEAR = 12;

    /** client. */
    private final RestApiExampleClient client;

    /**
     * Returns an employee data by ID.
     * 
     * @param id - Employee Identification.
     * @return Employee data object.
     */
    public EmployeeDTO getEmployee(String id) {
        EmployeeDTO employeeDTO;
        try {
            var response = client.getEmployeeById(id);
            employeeDTO = response.getData();
            employeeDTO.setAnualSalary(
                    this.getAnualSalary(employeeDTO.getEmployeeSalary()));
        } catch (FeignException ex) {
            log.error(ex.getMessage());
            throw ex;
        }
        return employeeDTO;
    }

    /**
     * Gets all fetched employees on rest api and returns the list of.
     * 
     * @return List of employees.
     */
    public List<EmployeeDTO> getEmployees() {
        List<EmployeeDTO> employees;
        try {
            var response = client.getEmployees();
            employees = response.getData();
            employees.forEach(employee -> employee
                    .setAnualSalary(this.getAnualSalary(employee.getEmployeeSalary())));
        } catch (FeignException ex) {
            log.error(ex.getMessage());
            throw ex;
        }

        return employees;
    }

    /**
     * Calculates the anual salary for an employee.
     * 
     * @param monthlySalary Actual monthly salary.
     * @return anual salary value.
     */
    private int getAnualSalary(int monthlySalary) {
        return monthlySalary * MONTHS_PER_YEAR;
    }
}
