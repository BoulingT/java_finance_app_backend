package com.example.demo.repository.expenses;

import com.example.demo.entity.expenses.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Set;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    Set<Expense> findByUserIdAndCreationDateBetween(Long userId, LocalDate startDate, LocalDate endDate);
}
