package com.example.demo.dto.expenses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonthlyExpenseDto {

    private Long userId;

    private LocalDate activeMonth;

    private Set<ExpenseDto> billList;

    private Set<ExpenseDto> subscriptionList;

    private Set<ExpenseDto> creditList;

    private Double consommationBudget;

    private Double totalExpenseAmount;
}
