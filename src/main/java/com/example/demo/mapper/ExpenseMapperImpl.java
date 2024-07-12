package com.example.demo.mapper;

import com.example.demo.dto.expenses.ExpenseDto;
import com.example.demo.dto.expenses.MonthlyExpenseDto;
import com.example.demo.entity.expenses.Expense;
import com.example.demo.enums.ExpenseTypeEnum;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

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

    public MonthlyExpenseDto expenseListToMonthlyExpenseDto(Set<ExpenseDto> expenseDtoSet) {
        MonthlyExpenseDto monthlyExpenseDto = new MonthlyExpenseDto();
        ExpenseDto referenceExpense = expenseDtoSet.stream()
                .findAny()
                .orElseThrow(() -> new IllegalStateException("ExpenseMapper expenseListToMonthlyExpenseDto: No reference expense found"));
        monthlyExpenseDto.setUserId(referenceExpense.getUser_id());
        monthlyExpenseDto.setActiveMonth(referenceExpense.getCreatedAt());
        monthlyExpenseDto.setBillList(expenseDtoSet.stream()
                .filter(expense -> ExpenseTypeEnum.fromValue(expense.getExpenseType().getId()) == ExpenseTypeEnum.BILL)
                .collect(Collectors.toSet()));
        monthlyExpenseDto.setSubscriptionList(expenseDtoSet.stream()
                .filter(expense -> ExpenseTypeEnum.fromValue(expense.getExpenseType().getId()) == ExpenseTypeEnum.SUBSCRIPTION)
                .collect(Collectors.toSet()));
        monthlyExpenseDto.setCreditList(expenseDtoSet.stream()
                .filter(expense -> ExpenseTypeEnum.fromValue(expense.getExpenseType().getId()) == ExpenseTypeEnum.CONSUMPTION_CREDIT)
                .collect(Collectors.toSet()));
        final var consumptionBudgetExpense = expenseDtoSet.stream()
                .filter(expense -> ExpenseTypeEnum.fromValue(expense.getExpenseType().getId()) == ExpenseTypeEnum.CONSUMPTION)
                .findAny()
                .orElse(null);
        if (consumptionBudgetExpense != null) {
            monthlyExpenseDto.setConsommationBudget(consumptionBudgetExpense.getAmount());
        } else {
            monthlyExpenseDto.setConsommationBudget(0.0);
        }
        monthlyExpenseDto.setTotalExpenseAmount(expenseDtoSet.stream()
                .mapToDouble(ExpenseDto::getAmount)
                .sum());

        return monthlyExpenseDto;
    }
}
