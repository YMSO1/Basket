package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "document")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "is_removed")
    private Boolean isRemoved;

    @UpdateTimestamp
    @Column(name = "last_edited")
    private LocalDateTime lastEdited = LocalDateTime.MIN;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    private Boolean deleteFromBasket = lastEdited.plusDays(7).isAfter(LocalDateTime.now());
}