package com.example.demo.entity.incomes;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "income")
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false, length = 50)
    private String label;

    private Double amount;

    @ManyToOne
    private IncomeType incomeType;
}