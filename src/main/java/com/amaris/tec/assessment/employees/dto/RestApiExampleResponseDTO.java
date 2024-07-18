package com.amaris.tec.assessment.employees.dto;

import lombok.Data;

/**
 * RestApiExampleDTO<T>: Represents th.e reponse of restapiexample.com.
 * 
 * @param <T> Is the object included on data.
 * @author Francisco Javier Guerrero Peláez
 */
@Data
public class RestApiExampleResponseDTO<T> {
    /** status. */
    private String status;
    /** data. */
    private T data;
    /** message. */
    private String message;
}
