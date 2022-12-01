package com.example.demo.repository;

import com.example.demo.model.Company;
import com.example.demo.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query("SELECT c FROM Company c WHERE c.isRemoved = false")
    List<Company> findAllNotRemoved();

    @Query("SELECT c FROM Company c WHERE c.id = :id AND c.isRemoved = false")
    Company findCompanyByIdIfNotRemoved(Long id);

    @Modifying
    @Query("UPDATE Company SET isRemoved = true WHERE id = :id")
    void markCompanyAsRemoved(Long id);

}