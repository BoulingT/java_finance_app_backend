package com.example.demo.controller;

import com.example.demo.dto.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {

//    private final AccountService accountService;

//    @GetMapping("/{id}")
//    public AccountDto getAccountById(@PathVariable Long id) {
//        return accountService.getAccountById(id);
//    }
//
//    @PostMapping("/create-account")
//    public AccountDto createAccount() {
//        return accountService.createAccount();
//    }
}
