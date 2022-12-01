package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.example.demo.model.Document} entity
 */

@Setter
@Getter
public class DocumentDto {
    private Long id;
    private Boolean isRemoved;
    private LocalDateTime lastEdited;
}