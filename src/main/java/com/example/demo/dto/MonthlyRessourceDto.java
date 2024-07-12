package com.example.demo.dto;

import com.example.demo.dto.expenses.MonthlyExpenseDto;
import com.example.demo.dto.incomes.MonthlyIncomeDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class MonthlyRessourceDto {

    private Long userId;

    private LocalDate activeMonth;

    private MonthlyIncomeDto monthlyIncome;

    private MonthlyExpenseDto monthlyExpense;

//  monthlyInvestment : MonthlyInvestmentDto
}
