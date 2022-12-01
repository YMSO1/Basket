package com.example.demo.mapper;

import com.example.demo.dto.CompanyDto;
import com.example.demo.dto.ContractDto;
import com.example.demo.model.Company;
import com.example.demo.model.Contract;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author YMS01
 * @date 01.12.2022 0:24
 */
@Mapper
public interface CompanyMapper {
    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

    List<CompanyDto> toDtoList(List<Company> contracts);

    Company companyDtoToCompany(CompanyDto companyDto);

    CompanyDto companyToCompanyDto(Company company);
}
