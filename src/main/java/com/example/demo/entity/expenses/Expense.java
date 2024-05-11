package com.example.demo.entity.expenses;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity(name = "expense")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private LocalDate creationDate;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private String label;

    @ManyToOne
    private ExpenseType expenseType;
}
