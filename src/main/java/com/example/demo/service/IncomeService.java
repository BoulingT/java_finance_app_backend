package com.example.demo.service;

import com.example.demo.dto.incomes.MonthlyIncomeDto;
import com.example.demo.entity.incomes.FixedIncome;
import com.example.demo.entity.incomes.MonthlyIncomeList;
import com.example.demo.mapper.MonthlyIncomeMapper;
import com.example.demo.repository.incomes.MonthlyIncomeListRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IncomeService {

    private final MonthlyIncomeListRepository monthlyIncomeListRepository;

    private final MonthlyIncomeMapper monthlyIncomeMapper;

    public MonthlyIncomeDto getMonthlyIncomeList() throws BadRequestException {
        Optional<MonthlyIncomeList> monthlyIncomeOptional = monthlyIncomeListRepository.findById(1L);
        if (monthlyIncomeOptional.isPresent()) {
            MonthlyIncomeList monthlyIncome = monthlyIncomeOptional.get();
            return monthlyIncomeMapper.mapMonthlyIncomeDto(monthlyIncome);
        } else {
            throw new BadRequestException("No monthly income list found");
        }
    }
}

