package com.example.demo.service;

import com.example.demo.dto.CompanyDto;
import com.example.demo.mapper.CompanyMapper;
import com.example.demo.model.Company;
import com.example.demo.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author YMS01
 * @date 01.12.2022 0:30
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository repository;

    @Override
    public List<CompanyDto> findAll() {
        log.info("All Companies was found");
        return CompanyMapper.INSTANCE.toDtoList(repository.findAllNotRemoved());
    }

    @Override
    public CompanyDto findById(Long id) {
        log.info("Company with id = {} was found", id);
        return CompanyMapper.INSTANCE.companyToCompanyDto(repository.findCompanyByIdIfNotRemoved(id));
    }

    @Override
    @Transactional
    public void save(CompanyDto companyDto) {
        Company company = CompanyMapper.INSTANCE.companyDtoToCompany(companyDto);

        company.setIsRemoved(false);
        repository.save(company);
        log.info("Company was saved: {}", company);
    }

    @Override
    @Transactional
    public void update(Long id, CompanyDto companyDto) {
        Company fromDto = CompanyMapper.INSTANCE.companyDtoToCompany(companyDto);
        Company newCompany = repository.findCompanyByIdIfNotRemoved(id);

        newCompany.setBasket(fromDto.getBasket());
        newCompany.setIsRemoved(false);
        repository.save(newCompany);
        log.info("Company was updated: {}", newCompany);

    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.markCompanyAsRemoved(id);
        log.info("Company with id = {} was marked as removed", id);
    }
}
