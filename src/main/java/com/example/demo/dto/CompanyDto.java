package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.demo.model.Company} entity
 */

@Getter
@Setter
public class CompanyDto implements Serializable {
    private Long id;
    private BasketDto basket;
}