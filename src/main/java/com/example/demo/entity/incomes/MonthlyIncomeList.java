package com.example.demo.entity.incomes;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.YearMonth;
import java.util.Set;

@Data
@Entity
public class MonthlyIncomeList {

    @Id
    private Long id;

    private YearMonth activeMonth;

    @OneToMany
    private Set<FixedIncome> fixedIncomeList;
}
