package com.amaris.tec.assessment.employees.dto;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RestApiExampleResponseDTOTest {
    
  
    @Test
    void createObject() {
        RestApiExampleResponseDTO obj =  new RestApiExampleResponseDTO<String>();
        obj.setData("Test data");
        obj.setMessage("message");
        obj.setStatus("success");

        Assertions.assertNotNull(obj);
        Assertions.assertNotNull(obj.getData());
        Assertions.assertNotNull(obj.getMessage());
        Assertions.assertNotNull(obj.getStatus());
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

    @Test
    void objectHash() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setAnualSalary(60000);
        employeeDTO.setEmployeeAge(33);
        employeeDTO.setEmployeeName("Pedro Perez Pereira");
        employeeDTO.setEmployeeSalary(5000);
        employeeDTO.setId(1);
        employeeDTO.setProfileImage("none");
        var employee2 = employeeDTO;
        int expected = employee2.hashCode();

        Assertions.assertEquals(expected, employeeDTO.hashCode());
    }

    @Test
    void objectEquals() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setAnualSalary(60000);
        employeeDTO.setEmployeeAge(33);
        employeeDTO.setEmployeeName("Pedro Perez Pereira");
        employeeDTO.setEmployeeSalary(5000);
        employeeDTO.setId(1);
        employeeDTO.setProfileImage("none");
        var employee2 = employeeDTO;
        var equals = employeeDTO.equals(employee2);
        Assertions.assertTrue(equals);
    }

    @Test
    void objectNotEquals() {
        EmployeeDTO employee = new EmployeeDTO();
        employee.setAnualSalary(60000);
        employee.setEmployeeAge(33);
        employee.setEmployeeName("Pedro Perez Pereira");
        employee.setEmployeeSalary(5000);
        employee.setId(1);
        employee.setProfileImage("none");
        var employee2 = new EmployeeDTO();
        employee2.setAnualSalary(152000);
        employee2.setEmployeeAge(34);
        employee2.setEmployeeName("Pedro Perez Pereira");
        employee2.setEmployeeSalary(5100);
        employee2.setId(2);
        employee2.setProfileImage("nones");
        var equals = employee.equals(employee2);
        Assertions.assertFalse(equals);
    }
}
