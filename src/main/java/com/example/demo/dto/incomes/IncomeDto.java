package com.example.demo.dto.incomes;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class IncomeDto {

    private Long id;

    private Long user_id;

    private LocalDate createdAt;

    private Double amount;

    private String label;

    private IncomeTypeDto incomeType;
}
