package com.example.demo.repository;

import com.example.demo.entity.Account;
import com.example.demo.entity.MonthlyExpenseList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MonthlyExpenseListRepository extends JpaRepository<MonthlyExpenseList, Long> {

    MonthlyExpenseList findMonthlyExpenseListByIsActive(boolean isActive);

}
