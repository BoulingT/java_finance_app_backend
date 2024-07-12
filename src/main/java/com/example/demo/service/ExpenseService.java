package com.example.demo.service;

import com.example.demo.dto.expenses.ExpenseDto;
import com.example.demo.dto.expenses.ExpenseTypeDto;
import com.example.demo.dto.expenses.MonthlyExpenseDto;
import com.example.demo.entity.expenses.Expense;
import com.example.demo.entity.expenses.ExpenseType;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.ExpenseMapperImpl;
import com.example.demo.repository.expenses.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    private final ExpenseMapperImpl expenseMapper;

    public ExpenseDto addNewExpense(ExpenseDto expenseDto) throws BadRequestException {
        if (expenseDto.getId() != null) {
            throw new BadRequestException("Expense alreadyExists");
        }
        final var expense = mapDtoToEntity(expenseDto);
        final var savedExpense = expenseRepository.save(expense);
        return mapExpenseEntityToDto(savedExpense);
    }

    public MonthlyExpenseDto getCurrentMonthlyExpenseDto() {
        return expenseMapper.expenseListToMonthlyExpenseDto(getCurrentMonthExpenseListDto());
    }

    public Set<ExpenseDto> getCurrentMonthExpenseListDto() {
        return getCurrentMonthExpenseList().stream()
                .map(this::mapExpenseEntityToDto)
                .collect(Collectors.toSet());
    }

    public void deleteExpenseById(Long expenseId) {
        if (!expenseRepository.existsById(expenseId)) {
            throw new ResourceNotFoundException("Expense not found with id " + expenseId);
        }
        expenseRepository.deleteById(expenseId);
    }

    private Set<Expense> getCurrentMonthExpenseList() {
        YearMonth currentMonth = YearMonth.now();
        return expenseRepository.findByUserIdAndCreationDateBetween(
                1L,
                currentMonth.atDay(1),
                currentMonth.atEndOfMonth()
        );
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
}