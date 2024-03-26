package com.example.demo.service;

import com.example.demo.dto.AccountDto;
import com.example.demo.entity.Account;
import com.example.demo.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountDto getAccountById(Long id) {
        Account account  = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        return AccountDto.builder()
                .id(account.getId())
                .userId(account.getUserId())
                .createdAt(account.getCreatedAt())
                .userId(account.getUserId())
                .balance(account.getBalance())
                .typeId(account.getTypeId())
                .build();
    }

    public AccountDto createAccount() {
        Account account = new Account();
        account.setUserId(UUID.randomUUID());
        account.setBalance(0L);
        account.setTypeId(1L);
        accountRepository.save(account);
        return AccountDto.builder()
                .createdAt(account.getCreatedAt())
                .userId(account.getUserId())
                .balance(account.getBalance())
                .typeId(account.getTypeId())
                .build();
    }
}
