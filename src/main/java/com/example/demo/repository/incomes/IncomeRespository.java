package com.example.demo.repository.incomes;

import com.example.demo.entity.incomes.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeRespository extends JpaRepository<Income, Long> {
}
