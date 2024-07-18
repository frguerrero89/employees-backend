package com.amaris.tec.assessment.employees.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * EmployeeDTO: Representation of an employee.
 * @author Francisco Javier Guerrero Peláez.
 */
@Data
public class EmployeeDTO {
    /** id. */
    private int id;
    /** employeeName. */
    @JsonProperty("employee_name")
    private String employeeName;
    /** employeeSalary. */
    @JsonProperty("employee_salary")
    private int employeeSalary;
    /** employeeAge. */
    @JsonProperty("employee_age")
    private int employeeAge;
    /** profileImage. */
    @JsonProperty("profile_image")
    private String profileImage;
    /** anualSalary. */
    @JsonProperty("anual_salary")
    private int anualSalary;
}
