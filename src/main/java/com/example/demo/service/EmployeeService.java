package com.example.demo.service;

import com.example.demo.dto.EmployeeDto;

import java.util.List;

/**
 * @author YMS01
 * @date 30.11.2022 14:24
 */
public interface EmployeeService {

    List<EmployeeDto> findAll();

    EmployeeDto findById(Long id);

    void save(EmployeeDto employeeDto);

    void update(Long id, EmployeeDto employeeDto);

    void deleteById(Long id);
}
