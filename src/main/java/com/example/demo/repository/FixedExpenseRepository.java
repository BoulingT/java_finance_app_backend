package com.example.demo.repository;

import com.example.demo.entity.Account;
import com.example.demo.entity.FixedExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FixedExpenseRepository extends JpaRepository<FixedExpense, Long> {
}
