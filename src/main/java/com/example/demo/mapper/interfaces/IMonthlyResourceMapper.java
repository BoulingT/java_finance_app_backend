package com.example.demo.mapper.interfaces;

import com.example.demo.dto.MonthlyRessourceDto;
import com.example.demo.dto.expenses.MonthlyExpenseDto;
import com.example.demo.dto.incomes.MonthlyIncomeDto;

public interface IMonthlyResourceMapper {
    MonthlyRessourceDto mapMonthlyRessourceDto(MonthlyIncomeDto monthlyIncomeDto, MonthlyExpenseDto monthlyExpenseDto);
}
