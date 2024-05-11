package com.example.demo.service;

import com.example.demo.dto.incomes.MonthlyIncomeDto;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class IncomeService {

//    private final MonthlyIncomeListRepository monthlyIncomeListRepository;
//
//    private final MonthlyIncomeMapper monthlyIncomeMapper;
//
//    public MonthlyIncomeDto getMonthlyIncomeList() throws BadRequestException {
//        Optional<MonthlyIncomeList> monthlyIncomeOptional = monthlyIncomeListRepository.findById(1L);
//        if (monthlyIncomeOptional.isPresent()) {
//            MonthlyIncomeList monthlyIncome = monthlyIncomeOptional.get();
//            return monthlyIncomeMapper.mapMonthlyIncomeDto(monthlyIncome);
//        } else {
//            throw new BadRequestException("No monthly income list found");
//        }
//    }
}

