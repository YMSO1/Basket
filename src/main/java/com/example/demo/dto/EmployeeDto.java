package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.demo.model.Employee} entity
 */
@Getter
@Setter
public class EmployeeDto implements Serializable {
    private Long id;
    private String name;
    private Boolean isRemoved;
}