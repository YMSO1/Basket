package com.example.demo.service;

import com.example.demo.dto.ContractDto;

import java.util.List;

/**
 * @author YMS01
 * @date 30.11.2022 22:14
 */
public interface ContractService {

    List<ContractDto> findAll();

    ContractDto findById(Long id);

    void save(ContractDto contractDto);

    void update(Long id, ContractDto contractDto);

    void deleteById(Long id);
}
