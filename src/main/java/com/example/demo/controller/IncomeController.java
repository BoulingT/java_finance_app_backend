package com.example.demo.controller;

import com.example.demo.dto.incomes.MonthlyIncomeDto;
import com.example.demo.service.IncomeService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/income")
public class IncomeController {

    private final IncomeService incomeService;

//    @GetMapping("/monthly-income")
//    public MonthlyIncomeDto getMonthlyIncomeList() throws BadRequestException {
//        return incomeService.getMonthlyIncomeList();
//    }
}
