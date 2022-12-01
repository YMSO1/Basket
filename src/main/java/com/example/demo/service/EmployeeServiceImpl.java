package com.example.demo.service;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author YMS01
 * @date 30.11.2022 14:30
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repository;

    @Override
    public List<EmployeeDto> findAll() {
        log.info("All Employees was found");
        return EmployeeMapper.INSTANCE.toDtoList(repository.findAllNotRemoved());
    }

    @Override
    public EmployeeDto findById(Long id) {
        log.info("Employee with id = {} was found", id);
        return EmployeeMapper.INSTANCE.employeeToEmployeeDto(repository.findEmployeeByIdIfNotRemoved(id));
    }

    @Override
    @Transactional
    public void save(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.INSTANCE.employeeDtoToEmployee(employeeDto);

        employee.setIsRemoved(false);
        repository.save(employee);
        log.info("Employee was saved: {}", employee);
    }

    @Override
    @Transactional
    public void update(Long id, EmployeeDto employeeDto) {
        Employee fromDto = EmployeeMapper.INSTANCE.employeeDtoToEmployee(employeeDto);
        Employee newEmployee = repository.findEmployeeByIdIfNotRemoved(id);

        newEmployee.setName(fromDto.getName());
        repository.save(newEmployee);
        log.info("Employee was updated: {}", newEmployee);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.markEmployeeAsRemoved(id);
        log.info("Employee with id = {} was marked as removed", id);
    }
}
