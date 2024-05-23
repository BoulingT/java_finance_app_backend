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

    //    @Query("SELECT e FROM Expense e WHERE YEAR(e.creationDate) = :year AND MONTH(e.creationDate) = :month AND user_id = :userId")
//    Set<Expense> findByMonth(@Param("year") int year, @Param("month") int month, Long userId);
//
//    Set<Expense> findByUserIdAndCreationDate
    Set<Expense> findByUserIdAndCreationDateBetween(Long userId, LocalDate startDate, LocalDate endDate);
}
