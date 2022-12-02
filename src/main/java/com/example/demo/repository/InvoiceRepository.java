package com.example.demo.repository;

import com.example.demo.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    @Query("SELECT i FROM Invoice i WHERE i.isRemoved = false")
    List<Invoice> findAllNotRemoved();

    @Query("SELECT i FROM Invoice i WHERE i.id = :id AND i.isRemoved = false")
    Invoice findInvoiceByIdIfNotRemoved(Long id);

    @Modifying
    @Query("UPDATE Invoice SET isRemoved = true WHERE id = :id")
    void markInvoiceAsRemoved(Long id);
}