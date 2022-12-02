package com.example.demo.repository;

import com.example.demo.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContractRepository extends JpaRepository<Contract, Long> {

    @Query("SELECT c FROM Contract c WHERE c.isRemoved = false")
    List<Contract> findAllNotRemoved();

    @Query("SELECT c FROM Contract c WHERE c.id = :id AND c.isRemoved = false")
    Contract findContractByIdIfNotRemoved(Long id);

    @Modifying
    @Query("UPDATE Contract SET isRemoved = true WHERE id = :id")
    void markContractAsRemoved(Long id);
}