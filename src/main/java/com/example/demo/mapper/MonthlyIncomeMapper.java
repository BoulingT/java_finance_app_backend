package com.example.demo.mapper;

import com.example.demo.dto.incomes.MonthlyIncomeDto;
import com.example.demo.entity.incomes.FixedIncome;
import com.example.demo.entity.incomes.MonthlyIncomeList;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@NoArgsConstructor
public class MonthlyIncomeMapper {

    public MonthlyIncomeDto mapMonthlyIncomeDto(MonthlyIncomeList monthlyIncome) {
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
