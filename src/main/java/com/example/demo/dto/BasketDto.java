package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * A DTO for the {@link com.example.demo.model.Basket} entity
 */
@Getter
@Setter
public class BasketDto {
    private Long id;
    private Set<DocumentDto> documentList = new LinkedHashSet<>();
}