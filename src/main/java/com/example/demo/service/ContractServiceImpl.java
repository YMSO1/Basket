package com.example.demo.service;

import com.example.demo.dto.ContractDto;
import com.example.demo.mapper.ContractMapper;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.model.Contract;
import com.example.demo.model.Employee;
import com.example.demo.repository.ContractRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author YMS01
 * @date 30.11.2022 22:15
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ContractServiceImpl implements ContractService {
    private final ContractRepository repository;

    @Override
    public List<ContractDto> findAll() {

        log.info("All Contracts was found");
        return ContractMapper.INSTANCE.toDtoList(repository.findAllNotRemoved());
    }

    @Override
    public ContractDto findById(Long id) {
        log.info("Contract with id = {} was found", id);
        return ContractMapper.INSTANCE.contractToContractDto(repository.findContractByIdIfNotRemoved(id));
    }

    @Override
    @Transactional
    public void save(ContractDto contractDto) {
        Contract contract = ContractMapper.INSTANCE.contractDtoToContract(contractDto);

        contract.setIsRemoved(false);
        repository.save(contract);
        log.info("Contract was saved: {}", contract);
    }

    @Override
    @Transactional
    public void update(Long id, ContractDto contractDto) {
        Contract fromDto = ContractMapper.INSTANCE.contractDtoToContract(contractDto);
        Contract newContract = repository.findContractByIdIfNotRemoved(id);

        newContract.setContragent(fromDto.getContragent());
        newContract.setIsRemoved(false);
        repository.save(newContract);
        log.info("Contract was updated: {}", newContract);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.markContractAsRemoved(id);
        log.info("Contract with id = {} was marked as removed", id);
    }
}
