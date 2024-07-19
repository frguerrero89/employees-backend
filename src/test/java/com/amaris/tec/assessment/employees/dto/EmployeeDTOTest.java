package com.amaris.tec.assessment.employees.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EmployeeDTOTest {

    @Test
    void createObject() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setAnualSalary(60000);
        employeeDTO.setEmployeeAge(33);
        employeeDTO.setEmployeeName("Pedro Perez Pereira");
        employeeDTO.setEmployeeSalary(5000);
        employeeDTO.setId(1);
        employeeDTO.setProfileImage("none");

        Assertions.assertNotNull(employeeDTO);
        Assertions.assertEquals(60000, employeeDTO.getAnualSalary());
        Assertions.assertEquals(33, employeeDTO.getEmployeeAge());
        Assertions.assertNotNull(employeeDTO.getEmployeeName());
        Assertions.assertEquals(5000, employeeDTO.getEmployeeSalary());
        Assertions.assertEquals(1, employeeDTO.getId());
        Assertions.assertNotNull(employeeDTO.getProfileImage());
    }

    @Test
    void objectToString() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setAnualSalary(60000);
        employeeDTO.setEmployeeAge(33);
        employeeDTO.setEmployeeName("Pedro Perez Pereira");
        employeeDTO.setEmployeeSalary(5000);
        employeeDTO.setId(1);
        employeeDTO.setProfileImage("none");
        String expected = "EmployeeDTO(id=1, employeeName=Pedro Perez Pereira, "
                + "employeeSalary=5000, employeeAge=33, profileImage=none, anualSalary=60000)";

        Assertions.assertEquals(expected, employeeDTO.toString());
    }


}
