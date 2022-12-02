package com.example.demo.service;

import com.example.demo.dto.DocumentDto;

import java.util.List;

/**
 * @author YMS01
 * @date 30.11.2022 14:23
 */
public interface DocumentService {

    List<DocumentDto> findAll();

    List<DocumentDto> findAllToBasket();

    DocumentDto findById(Long id);

    void save(DocumentDto documentDto);

    void update(Long id, DocumentDto documentDto);

    void deleteById(Long id);

    void recover(Long id);
}
