package com.example.demo.entity;

import com.example.demo.entity.expenses.Expense;
import com.example.demo.entity.incomes.Income;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Table(name = "monthly_resource", uniqueConstraints = @UniqueConstraint(columnNames = {"userId", "activeMonth"}))
public class MonthlyRessource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private LocalDate activeMonth;

    @OneToMany
    @Column(nullable = false)
    private Set<Income> incomeSet;

    @OneToMany
    @Column(nullable = false)
    private Set<Expense> expenseSet;
}
