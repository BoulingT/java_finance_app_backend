package com.example.demo.controller;

import com.example.demo.dto.investment.InvestmentRecapDto;
import com.example.demo.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/investments")
    private InvestmentRecapDto getAllInvestments() {
        return accountService.getAllInvestmentRecap();
    }
}
