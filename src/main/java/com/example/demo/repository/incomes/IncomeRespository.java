package com.example.demo.repository.incomes;

import com.example.demo.entity.incomes.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Set;

@Repository
public interface IncomeRespository extends JpaRepository<Income, Long> {

    Set<Income> findByUserIdAndCreationDateBetween(Long userId, LocalDate startDate, LocalDate endDate);
}
