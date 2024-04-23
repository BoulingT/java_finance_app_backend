package com.example.demo.service;

import com.example.demo.dto.MonthlyExpenseListDto;
import com.example.demo.entity.MonthlyExpenseList;
import com.example.demo.mapper.ExpenseMapper;
import com.example.demo.repository.ExpenseTypeRepository;
import com.example.demo.repository.MonthlyExpenseListRepository;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

    private final MonthlyExpenseListRepository monthlyExpenseListRepository;

    private final ExpenseMapper expenseMapper;

    public ExpenseService(MonthlyExpenseListRepository monthlyExpenseListRepository, ExpenseMapper expenseMapper) {
        this.monthlyExpenseListRepository = monthlyExpenseListRepository;
        this.expenseMapper = expenseMapper;
    }

    public MonthlyExpenseListDto getMonhtlyExpenseList() {
        MonthlyExpenseList monthlyExpenseList = monthlyExpenseListRepository.findMonthlyExpenseListByIsActive(true);

        return expenseMapper.monthlyExpenseListToMonthlyExpenseListDto(monthlyExpenseList);
    }
}