package com.example.demo.repository;

import com.example.demo.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    @Query("select d from Document d where d.isRemoved = true and d.lastEdited between current_date AND current_date-7")
    List<Document> findAllRemovedToBasket();

    @Query("SELECT d FROM Document d WHERE d.isRemoved = false")
    List<Document> findAllNotRemoved();

    @Query("SELECT d FROM Document d WHERE d.id = :id AND d.isRemoved = false")
    Document findDocumentByIdIfNotRemoved(Long id);

    @Modifying
    @Query("UPDATE Document SET isRemoved = true WHERE id = :id")
    void markDocumentAsRemoved(Long id);

    @Modifying
    @Query("UPDATE Document SET isRemoved = false WHERE id = :id")
    void markDocumentAsNotRemoved(Long id);
}