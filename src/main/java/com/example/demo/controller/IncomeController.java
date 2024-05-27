package com.example.demo.controller;

import com.example.demo.dto.expenses.ExpenseDto;
import com.example.demo.dto.incomes.IncomeDto;
import com.example.demo.dto.incomes.MonthlyIncomeDto;
import com.example.demo.service.IncomeService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/income")
public class IncomeController {

    private final IncomeService incomeService;

    @PostMapping("/add-new-income")
    public IncomeDto addNewIncome(@RequestBody IncomeDto incomeDto) throws BadRequestException {
        return incomeService.addNewIncome(incomeDto);
    }

    @GetMapping("/current-month")
    public MonthlyIncomeDto getCurrentMonthIncomeList() {
        return incomeService.getCurrentMonthlyIncome();
    }
//
//    @DeleteMapping("{expenseId}")
//    public void deleteIncome(@PathVariable Long expenseId) {
//        incomeService.deleteIncomeById(incomeId);
//    }
}
