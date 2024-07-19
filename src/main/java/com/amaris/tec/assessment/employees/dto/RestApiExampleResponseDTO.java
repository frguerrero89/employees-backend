package com.amaris.tec.assessment.employees.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * RestApiExampleDTO<T>: Represents th.e reponse of restapiexample.com.
 * 
 * @param <T> Is the object included on data.
 * @author Francisco Javier Guerrero Peláez
 */
@Getter
@Setter
@ToString
public class RestApiExampleResponseDTO<T> {
    /** status. */
    private String status;
    /** data. */
    private T data;
    /** message. */
    private String message;
}
