package com.example.demo.controller;

import com.example.demo.dto.incomes.IncomeDto;
import com.example.demo.dto.incomes.IncomeTypeDto;
import com.example.demo.dto.incomes.MonthlyIncomeDto;
import com.example.demo.service.IncomeService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/income")
public class IncomeController {

    private final IncomeService incomeService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("/add-new-income")
    public IncomeDto addNewIncome(@RequestBody IncomeDto incomeDto) throws BadRequestException {
        return incomeService.addNewIncome(incomeDto);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/current-month/{user-id}")
    public MonthlyIncomeDto getCurrentMonthIncomeListByUserId(@PathVariable("user-id") Long userId) {
        return incomeService.getCurrentMonthlyIncomeByUserId(userId);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("/add-new-income-type")
    public IncomeTypeDto addNewIncomeType(@RequestBody IncomeTypeDto incomeTypeDto) throws BadRequestException {
        return incomeService.addNewIncomeType(incomeTypeDto);
    }
}
