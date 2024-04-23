package com.example.demo.dto;

import com.example.demo.entity.ExpenseType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FixedExpenseDto {

    private Long id;

    private Double amount;

    private String label;

    private ExpenseType expenseType;
}