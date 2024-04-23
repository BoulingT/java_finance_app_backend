package com.example.demo.mapper;

import com.example.demo.dto.MonthlyExpenseListDto;
import com.example.demo.entity.MonthlyExpenseList;

public interface ExpenseMapper {

    MonthlyExpenseListDto monthlyExpenseListToMonthlyExpenseListDto(MonthlyExpenseList monthlyExpenseList);

}