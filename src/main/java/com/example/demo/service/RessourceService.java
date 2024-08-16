package com.example.demo.service;

import com.example.demo.dto.MonthlyRessourceDto;
import com.example.demo.mapper.interfaces.IMonthlyResourceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RessourceService {

    private final IncomeService incomeService;

    private final ExpenseService expenseService;

    private final IMonthlyResourceMapper monthlyResourceMapper;

    public MonthlyRessourceDto currentMonthResourcesByUserId(Long userId) {
        final var currentMonthlyIncome = incomeService.getCurrentMonthlyIncomeByUserId(userId);
        final var currentMonthlyExpense = expenseService.getCurrentMonthlyExpenseDtoByUserId(userId);
        return monthlyResourceMapper.mapMonthlyRessourceDto(currentMonthlyIncome, currentMonthlyExpense);
    }
}
