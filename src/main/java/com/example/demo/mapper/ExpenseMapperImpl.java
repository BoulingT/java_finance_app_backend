package com.example.demo.mapper;

import com.example.demo.dto.expenses.ExpenseDto;
import com.example.demo.entity.expenses.Expense;
import org.springframework.stereotype.Service;

@Service
public class ExpenseMapperImpl {


    public Expense dtoToEntity(ExpenseDto expenseDto) {
        Expense expense = new Expense();
        expense.setId(expenseDto.getId());
        expense.setUserId(expenseDto.getUser_id());
        expense.setCreationDate(expenseDto.getCreatedAt());
        expense.setAmount(expenseDto.getAmount());
        expense.setLabel(expenseDto.getLabel());

        return expense;
    }

    public ExpenseDto entityToDto(Expense expense) {
        ExpenseDto expenseDto = new ExpenseDto();
        if (expense.getId() != null) {
            expenseDto.setId(expense.getId());
        }
        expenseDto.setUser_id(expense.getUserId());
        expenseDto.setCreatedAt(expense.getCreationDate());
        expenseDto.setAmount(expense.getAmount());
        expenseDto.setLabel(expense.getLabel());
        return expenseDto;
    }
}
