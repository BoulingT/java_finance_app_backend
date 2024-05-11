package com.example.demo.dto.incomes;

import com.example.demo.entity.incomes.Income;
import lombok.Data;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Set;

@Data
public class MonthlyIncomeDto {

    private Long id;

    private Long user_id;

    private LocalDate activeMonth;

    private IncomeDto salary;

//    private Income freelance;

    private Set<IncomeDto> aids;

    private Double totalIncomeAmount;

    public void setTotalIncomeAmount() {
//        var total = salary != null ? salary.getAmount() : 0;
//        total += freelance != null ? freelance.getAmount() : 0;
//        total += getAidsTotalIncomeAmount();
//        totalIncomeAmount = total;
    }

//    private Double getAidsTotalIncomeAmount() {
////        return !aids.isEmpty() ? aids.stream().mapToDouble(Income::getAmount).sum() : 0;
//    }
}
