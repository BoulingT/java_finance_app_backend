package com.example.demo.dto;

import com.example.demo.entity.FixedExpense;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MonthlyExpenseListDto {

    private Long id;

    private Set<FixedExpenseDto> billList;

    private Set<FixedExpenseDto> subscriptionList;

    private Set<FixedExpenseDto> creditList;

    private FixedExpense consommationBudget;

    private boolean isActive;
}