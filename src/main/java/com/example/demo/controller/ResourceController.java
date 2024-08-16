package com.example.demo.controller;

import com.example.demo.dto.MonthlyRessourceDto;
import com.example.demo.service.RessourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/resources")
public class ResourceController {

    private final RessourceService ressourceService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/current-month/{user-id}")
    public MonthlyRessourceDto getCurrentMonthResourcesByUserId(@PathVariable("user-id") Long userId) {
        return ressourceService.currentMonthResourcesByUserId(userId);
    }
}
