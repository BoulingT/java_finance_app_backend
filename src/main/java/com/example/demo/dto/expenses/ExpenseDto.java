package com.example.demo.dto.expenses;

import com.example.demo.dto.incomes.IncomeTypeDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
public class ExpenseDto {

    private Long id;

    private Long user_id;

    private LocalDate createdAt;

    private Double amount;

    private String label;

    private ExpenseTypeDto expenseType;
}
