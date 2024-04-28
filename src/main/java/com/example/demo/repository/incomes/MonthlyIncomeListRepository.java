package com.example.demo.repository.incomes;

import com.example.demo.entity.incomes.MonthlyIncomeList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonthlyIncomeListRepository extends JpaRepository<MonthlyIncomeList, Long> {
}
