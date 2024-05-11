package com.example.demo.service;

import com.example.demo.dto.MonthlyRessourceDto;
import com.example.demo.entity.MonthlyRessource;
import com.example.demo.repository.MonthlyResourceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class RessourceService {

    private final MonthlyResourceRepository monthlyRessourceRepository;

    public MonthlyRessourceDto currentMonthRessourcesByUserId() {
        Long userId = 1L;
        MonthlyRessource monthlyRessource = monthlyRessourceRepository.findByUserIdAndAndActiveMonth(userId, LocalDate.now());

        return null;
    }
}
