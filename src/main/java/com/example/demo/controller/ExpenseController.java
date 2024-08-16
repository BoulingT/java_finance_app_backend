package com.example.demo.controller;

import com.example.demo.dto.expenses.ExpenseDto;
import com.example.demo.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping("/api/expense")
@RequiredArgsConstructor
public class ExpenseController {


    private final ExpenseService expenseService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("/add-new-expense")
    public ExpenseDto addNewExpense(@RequestBody ExpenseDto expenseDto) throws BadRequestException {
        return expenseService.addNewExpense(expenseDto);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/current-month/{user-id}")
    public Set<ExpenseDto> getCurrentMonthExpenseList(@PathVariable("user-id") Long userId) {
        return expenseService.getCurrentMonthExpenseListDtoByUserId(userId);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @DeleteMapping("{expenseId}")
    public void deleteExpense(@PathVariable Long expenseId) {
        expenseService.deleteExpenseById(expenseId);
    }
}