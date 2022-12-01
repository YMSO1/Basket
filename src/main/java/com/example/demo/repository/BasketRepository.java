package com.example.demo.repository;

import com.example.demo.model.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Set;

public interface BasketRepository extends JpaRepository<Basket, Long> {
}