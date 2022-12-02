package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.isRemoved = false")
    List<Employee> findAllNotRemoved();

    @Query("SELECT e FROM Employee e WHERE e.id = :id AND e.isRemoved = false")
    Employee findEmployeeByIdIfNotRemoved(Long id);

    @Modifying
    @Query("UPDATE Employee SET isRemoved = true WHERE id = :id")
    void markEmployeeAsRemoved(Long id);
}