package com.amaris.tec.assessment.employees.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RestApiExampleResponseDTOTest {

    @Test
    void createObject() {
        RestApiExampleResponseDTO<String> obj = new RestApiExampleResponseDTO<String>();
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
        RestApiExampleResponseDTO<String> obj = new RestApiExampleResponseDTO<String>();
        obj.setData("Test data");
        obj.setMessage("message");
        obj.setStatus("success");
        String expected = "RestApiExampleResponseDTO(status=success, data=Test data, message=message)";

        Assertions.assertEquals(expected, obj.toString());
    }

}