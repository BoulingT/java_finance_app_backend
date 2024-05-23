package com.example.demo.service;

import com.example.demo.dto.expenses.ExpenseDto;
import com.example.demo.dto.expenses.ExpenseTypeDto;
import com.example.demo.entity.expenses.Expense;
import com.example.demo.entity.expenses.ExpenseType;
import com.example.demo.mapper.ExpenseMapperImpl;
import com.example.demo.repository.expenses.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    private final ExpenseMapperImpl expenseMapper;

    public ExpenseDto addNewExpense(ExpenseDto expenseDto) throws BadRequestException {
        // Check if exists
        if (isExpenseNotExist(expenseDto)) {
            throw new BadRequestException("Expense alreadyExists");
        }
        // Map to entity
        Expense expense = mapDtoToEntity(expenseDto);

        // Save
        expense = expenseRepository.save(expense);
        // Map to dto

        // return dto
        return mapExpenseEntityToDto(expense);
    }

    private ExpenseDto mapExpenseEntityToDto(Expense expense) {
        ExpenseDto expenseDto = expenseMapper.entityToDto(expense);
        expenseDto.setExpenseType(getExpenseTypeEntityDto(expense.getExpenseType()));
        return expenseDto;
    }

    private ExpenseTypeDto getExpenseTypeEntityDto(ExpenseType expenseType) {
        ExpenseTypeDto expenseTypeDto = new ExpenseTypeDto();
        expenseTypeDto.setId(expenseType.getId());
        expenseTypeDto.setLabel(expenseType.getLabel());
        return expenseTypeDto;
    }

    private Expense mapDtoToEntity(ExpenseDto expenseDto) {
        Expense expense = expenseMapper.dtoToEntity(expenseDto);
        expense.setExpenseType(getExpenseTypeEntity(expenseDto.getExpenseType()));
        return expense;
    }

    private ExpenseType getExpenseTypeEntity(ExpenseTypeDto expenseTypeDto) {
        ExpenseType expenseType = new ExpenseType();
        expenseType.setId(expenseTypeDto.getId());
        expenseType.setLabel(expenseTypeDto.getLabel());
        return expenseType;
    }

    private boolean isExpenseNotExist(ExpenseDto expenseDto) {
        var expenseId = expenseDto.getId();
        if (expenseId == null) {
            return false;
        }
        return !expenseRepository.existsById(expenseId);
    }
}