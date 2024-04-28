package com.example.demo.dto.incomes;

import com.example.demo.entity.incomes.FixedIncome;
import lombok.Data;

import java.time.YearMonth;
import java.util.Set;

@Data
public class MonthlyIncomeDto {

    private Long id;

    private YearMonth yearMonth;

    private FixedIncome salary;

    private FixedIncome freelance;

    private Set<FixedIncome> aids;

    private Double totalIncomeAmount;

    public void setTotalIncomeAmount() {
        var total = salary != null ? salary.getAmount() : 0;
        total += freelance != null ? freelance.getAmount() : 0;
        total += getAidsTotalIncomeAmount();
        totalIncomeAmount = total;
    }

    private Double getAidsTotalIncomeAmount() {
        return !aids.isEmpty() ? aids.stream().mapToDouble(FixedIncome::getAmount).sum() : 0;
    }
}
