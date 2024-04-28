package com.example.demo.entity.incomes;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class FixedIncome {

    @Id
    private Long id;

    private String label;

    private Double amount;

    @ManyToOne
    private IncomeType incomeType;
}