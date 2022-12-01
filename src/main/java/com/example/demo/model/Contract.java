package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Contract extends Document {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;
    private String contragent;
}