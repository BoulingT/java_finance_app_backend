package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
public class FixedExpense {

    @Id
    private Long id;

//    private User userId;

    private Double amount;

    private String label;

    @OneToOne
    private ExpenseType expenseType;
}
