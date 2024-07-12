package com.example.demo.mapper;

import com.example.demo.dto.MonthlyRessourceDto;
import com.example.demo.dto.expenses.MonthlyExpenseDto;
import com.example.demo.dto.incomes.MonthlyIncomeDto;
import com.example.demo.mapper.interfaces.IMonthlyResourceMapper;
import org.springframework.stereotype.Component;

@Component
public class MonthlyResourceMapper implements IMonthlyResourceMapper {

    public MonthlyRessourceDto mapMonthlyRessourceDto(
            MonthlyIncomeDto monthlyIncomeDto,
            MonthlyExpenseDto monthlyExpenseDto
    ) {
        return new MonthlyRessourceDto(
                monthlyExpenseDto.getUserId(),
                monthlyIncomeDto.getActiveMonth(),
                monthlyIncomeDto,
                monthlyExpenseDto
        );
    }
}
