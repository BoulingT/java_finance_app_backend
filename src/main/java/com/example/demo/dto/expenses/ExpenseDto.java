package com.example.demo.dto.expenses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseDto {

    private Long id;

    private Long userId;

    private LocalDate createdAt;

    private Double amount;

    private String label;

    private ExpenseTypeDto expenseType;
}
