package com.example.demo.mapper;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author YMS01
 * @date 30.11.2022 14:17
 */
@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    List<EmployeeDto> toDtoList(List<Employee> employees);

    Employee employeeDtoToEmployee(EmployeeDto employeeDto);

    EmployeeDto employeeToEmployeeDto(Employee employee);
}
