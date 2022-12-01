package com.example.demo.service;

import com.example.demo.dto.InvoiceDto;

import java.util.List;

/**
 * @author YMS01
 * @date 30.11.2022 14:25
 */
public interface InvoiceService {

    List<InvoiceDto> findAll();

    InvoiceDto findById(Long id);

    void save(InvoiceDto invoiceDto);

    void update(Long id, InvoiceDto invoiceDto);

    void deleteById(Long id);
}
