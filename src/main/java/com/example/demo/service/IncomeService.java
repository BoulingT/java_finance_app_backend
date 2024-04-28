package com.example.demo.service;

import com.example.demo.dto.incomes.MonthlyIncomeDto;
import com.example.demo.entity.incomes.FixedIncome;
import com.example.demo.entity.incomes.MonthlyIncomeList;
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

    public MonthlyIncomeDto getMonthlyIncomeList() throws BadRequestException {
        Optional<MonthlyIncomeList> monthlyIncomeOptional = monthlyIncomeListRepository.findById(1L);
        if (monthlyIncomeOptional.isPresent()) {
            MonthlyIncomeList monthlyIncome = monthlyIncomeOptional.get();
            return mapMonthlyIncomeDto(monthlyIncome);
        } else {
            throw new BadRequestException("No monthly income list found");
        }
    }

    private MonthlyIncomeDto mapMonthlyIncomeDto(MonthlyIncomeList monthlyIncome) {
        MonthlyIncomeDto monthlyIncomeDto = new MonthlyIncomeDto();
        monthlyIncomeDto.setId(monthlyIncome.getId());
        monthlyIncomeDto.setYearMonth(monthlyIncome.getActiveMonth());
        monthlyIncomeDto.setSalary(getDesiredFixedIncome("salary", monthlyIncome.getFixedIncomeList()));
        monthlyIncomeDto.setFreelance(getDesiredFixedIncome("freelance", monthlyIncome.getFixedIncomeList()));
        monthlyIncomeDto.setAids(getAidsList(monthlyIncome.getFixedIncomeList()));
        monthlyIncomeDto.setTotalIncomeAmount();

        return monthlyIncomeDto;
    }

    private Set<FixedIncome> getAidsList(Set<FixedIncome> fixedIncomeList) {
        return fixedIncomeList.stream()
                .filter(fixedIncome -> fixedIncome.getIncomeType().getLabel().equals("aids"))
                .collect(Collectors.toSet());
    }

    private FixedIncome getDesiredFixedIncome(String incomeTypeLabel, Set<FixedIncome> fixedIncomeList) {
        return fixedIncomeList.stream()
                .filter(fixedIncome -> fixedIncome.getIncomeType().getLabel().equals(incomeTypeLabel))
                .findFirst()
                .orElse(null);
    }
}

