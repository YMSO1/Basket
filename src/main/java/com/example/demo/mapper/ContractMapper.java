package com.example.demo.mapper;

import com.example.demo.dto.ContractDto;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.model.Contract;
import com.example.demo.model.Employee;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author YMS01
 * @date 30.11.2022 22:10
 */
@Mapper
public interface ContractMapper {
    ContractMapper INSTANCE = Mappers.getMapper(ContractMapper.class);

    List<ContractDto> toDtoList(List<Contract> contracts);

    Contract contractDtoToContract(ContractDto contractDto);

    ContractDto contractToContractDto(Contract contract);
}
