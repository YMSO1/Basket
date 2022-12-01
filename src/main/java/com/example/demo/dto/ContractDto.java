package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.example.demo.model.Contract} entity
 */

@Getter
@Setter
public class ContractDto implements Serializable {
    private Long id;
    private LocalDateTime lastEdited;
    private Long number;
    private String contragent;
}