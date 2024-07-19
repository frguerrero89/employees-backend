package com.amaris.tec.assessment.employees.service;

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

import com.amaris.tec.assessment.employees.clients.RestApiExampleClient;
import com.amaris.tec.assessment.employees.dto.EmployeeDTO;
import com.amaris.tec.assessment.employees.dto.RestApiExampleResponseDTO;

import feign.FeignException;
import feign.Request;
import feign.RequestTemplate;

@SpringBootTest
class EmployeeServiceTest {

    @Mock
    RestApiExampleClient client;

    @InjectMocks
    EmployeeService service;
    private EmployeeDTO employee = null;
    private List<EmployeeDTO> employees = null;

    @BeforeEach
    void setUp() {
        employee = Instancio.create(EmployeeDTO.class);
        employees = Instancio.ofList(EmployeeDTO.class).size(3).create();
    }

    @Test
    void testGetEmployee() {
        RestApiExampleResponseDTO<EmployeeDTO> response = new RestApiExampleResponseDTO<EmployeeDTO>();
        response.setData(employee);
        response.setMessage("done");
        response.setStatus("success");
        Mockito.when(client.getEmployeeById(ArgumentMatchers.anyString())).thenReturn(response);
        var result = service.getEmployee("1");
        Mockito.verify(client, Mockito.atLeastOnce()).getEmployeeById("1");
        Assertions.assertNotNull(result);
        Assertions.assertEquals(response.getData(), result);
    }

    @Test
    void testGetEmployeeError() {
        Request request = Request.create(Request.HttpMethod.GET, "url", new HashMap<>(), null, new RequestTemplate());
        Mockito.when(client.getEmployeeById(ArgumentMatchers.anyString()))
                .thenThrow(new FeignException.TooManyRequests("", request, null, null));
        Assertions.assertThrows(FeignException.TooManyRequests.class, ()->{
            service.getEmployee("1");
        });
        Mockito.verify(client, Mockito.atLeastOnce()).getEmployeeById("1");
    }

    @Test
    void testGetEmployees() {
        RestApiExampleResponseDTO<List<EmployeeDTO>> response = new RestApiExampleResponseDTO<List<EmployeeDTO>>();
        response.setData(employees);
        response.setMessage("done");
        response.setStatus("success");
        Mockito.when(client.getEmployees()).thenReturn(response);
        var result = service.getEmployees();
        Mockito.verify(client, Mockito.atLeastOnce()).getEmployees();
        Assertions.assertNotNull(result);
        Assertions.assertEquals(response.getData(), result);
    }

    @Test
    void testGetEmployeesError() {
        Request request = Request.create(Request.HttpMethod.GET, "url", new HashMap<>(), null, new RequestTemplate());
        Mockito.when(client.getEmployees())
                .thenThrow(new FeignException.TooManyRequests("", request, null, null));
        Assertions.assertThrows(FeignException.TooManyRequests.class, ()->{
            service.getEmployees();
        });
        Mockito.verify(client, Mockito.atLeastOnce()).getEmployees();
    }
}
