package com.example.demo.repository.incomes;

import com.example.demo.entity.incomes.FixedIncome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FixedIncomeRepository extends JpaRepository<FixedIncome, Long> {
}
