package com.example.demo.controller;

import com.example.demo.dto.expenses.ExpenseDto;
import com.example.demo.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping("/api/expense")
@RequiredArgsConstructor
public class ExpenseController {


    private final ExpenseService expenseService;

    @PostMapping("/add-new-expense")
    public ExpenseDto addNewExpense(@RequestBody ExpenseDto expenseDto) throws BadRequestException {
        return expenseService.addNewExpense(expenseDto);
    }

    @GetMapping("/current-month")
    public Set<ExpenseDto> getCurrentMonthExpenseList() {
        return expenseService.getCurrentMonthExpenseList();
    }

    @DeleteMapping("{expenseId}")
    public void deleteExpense(@PathVariable Long expenseId) {
        expenseService.deleteExpenseById(expenseId);
    }
}