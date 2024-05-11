package com.example.demo.repository;

import com.example.demo.entity.MonthlyRessource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface MonthlyResourceRepository extends JpaRepository<MonthlyRessource, Long> {

    MonthlyRessource findByUserIdAndAndActiveMonth(Long userId, LocalDate activeMonth);
}
