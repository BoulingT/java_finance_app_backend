package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Data
public class MonthlyExpenseList {

    @Id
    private Long id;

//    private User userId;

    @OneToMany
    private Set<FixedExpense> billList;

    @OneToMany
    private Set<FixedExpense> subscriptionList;

    @OneToMany
    private Set<FixedExpense> creditList;

    @OneToOne
    private FixedExpense consommationBudget;

    private boolean isActive;
}
