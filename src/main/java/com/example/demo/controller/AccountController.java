package com.example.demo.controller;

import com.example.demo.dto.investment.InvestmentAccountDto;
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
    private Set<InvestmentAccountDto> getAllInvestments() {
        return accountService.getAllInvestments();
    }
}
