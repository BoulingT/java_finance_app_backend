package com.example.demo.controller;

import com.example.demo.dto.MonthlyExpenseListDto;
import com.example.demo.service.ExpenseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/expense")
public class ExpenseController {


    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/monthly-expense-list")
    public MonthlyExpenseListDto getMonthlyExpenseList() {
        return expenseService.getMonhtlyExpenseList();
    }
}