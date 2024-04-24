package com.example.demo.service;

import com.example.demo.dto.investment.InvestmentAccountDto;
import com.example.demo.mapper.InvestmentAccountMapper;
import com.example.demo.repository.investment.InvestmentAccountRepository;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AccountService {

    private final InvestmentAccountRepository investmentAccountRepository;

    private final InvestmentAccountMapper investmentAccountMapper;

    public AccountService(InvestmentAccountRepository investmentAccountRepository, InvestmentAccountMapper investmentAccountMapper) {
        this.investmentAccountRepository = investmentAccountRepository;
        this.investmentAccountMapper = investmentAccountMapper;
    }

    public Set<InvestmentAccountDto> getAllInvestments() {
        return investmentAccountRepository.findAll().stream()
                .map(investmentAccountMapper::investmentAccountToInvestmentAccountDto)
                .collect(Collectors.toSet());
    }
}
