package com.example.demo.dto.expenses;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
public class MonthlyExpenseDto {
    private Long id;

    private Long user_id;

    private LocalDate activeMonth;

    private Set<ExpenseDto> billList;

    private Set<ExpenseDto> subscriptionList;

    private Set<ExpenseDto> creditList;

    private int consommationBudget;

    private Double totalExpenseAmount;
}
