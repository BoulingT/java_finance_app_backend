package com.example.demo.entity.expenses;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "expense_type")
public class ExpenseType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String label;
}
