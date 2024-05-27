package com.example.demo.dto.incomes;

import com.example.demo.entity.incomes.Income;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Set;

@Data
@NoArgsConstructor
public class MonthlyIncomeDto {

    @NotNull
    private LocalDate activeMonth;

    private IncomeDto salary;

    private Set<IncomeDto> aids;

    private Double totalIncomeAmount;

    public void setTotalIncomeAmount(Set<Income> allIncomeSet) {
        totalIncomeAmount = allIncomeSet.stream().mapToDouble(Income::getAmount).sum();
    }
}
