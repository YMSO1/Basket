package com.example.demo.service;

import com.example.demo.dto.CompanyDto;

import java.util.List;

/**
 * @author YMS01
 * @date 01.12.2022 0:29
 */
public interface CompanyService {

    List<CompanyDto> findAll();

    CompanyDto findById(Long id);

    void save(CompanyDto companyDto);

    void update(Long id, CompanyDto companyDto);

    void deleteById(Long id);
}
