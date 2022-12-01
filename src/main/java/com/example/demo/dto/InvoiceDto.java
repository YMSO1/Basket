package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.demo.model.Invoice} entity
 */
@Getter
@Setter
public class InvoiceDto implements Serializable {
    private Long id;
    private Long number;
}