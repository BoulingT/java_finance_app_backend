package com.example.demo.repository.incomes;

import com.example.demo.entity.incomes.IncomeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeTypeRepository extends JpaRepository<IncomeType, Long> {
    boolean existsByLabel(String label);
}
