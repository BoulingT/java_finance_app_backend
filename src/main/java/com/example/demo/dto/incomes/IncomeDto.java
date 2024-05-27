package com.example.demo.dto.incomes;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class IncomeDto {

    private Long id;

    @NotNull
    private Long userId;

    @NotNull
    private LocalDate creationDate;

    @NotNull
    private Double amount;

    @NotNull
    private String label;

    @NotNull
    private IncomeTypeDto incomeType;
}
