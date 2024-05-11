package com.example.demo.controller;

import com.example.demo.dto.MonthlyRessourceDto;
import com.example.demo.service.RessourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ressources")
public class RessourceController {

    private final RessourceService ressourceService;

    @GetMapping
    public MonthlyRessourceDto getCurrentMonthRessourcesByUserId() {
        return ressourceService.currentMonthRessourcesByUserId();
    }
}
