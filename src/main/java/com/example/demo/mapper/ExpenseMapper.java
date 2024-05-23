package com.example.demo.mapper;

import com.example.demo.dto.expenses.ExpenseDto;
import com.example.demo.entity.expenses.Expense;

public interface ExpenseMapper {

    Expense dtoToEntity(ExpenseDto expenseDto);

    ExpenseDto entityToDto(Expense expense);
}
