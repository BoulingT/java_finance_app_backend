package com.example.demo.service;

import com.example.demo.dto.investment.InvestmentRecapDto;
import com.example.demo.entity.investments.InvestmentAccount;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.InvestmentAccountMapper;
import com.example.demo.repository.investment.InvestmentAccountRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AccountService {

    private final InvestmentAccountRepository investmentAccountRepository;

    private final InvestmentAccountMapper investmentAccountMapper;

    public AccountService(InvestmentAccountRepository investmentAccountRepository, InvestmentAccountMapper investmentAccountMapper) {
        this.investmentAccountRepository = investmentAccountRepository;
        this.investmentAccountMapper = investmentAccountMapper;
    }

    public InvestmentRecapDto getAllInvestmentRecap() {
        Optional<InvestmentAccount> investmentAccounts = investmentAccountRepository.findAll().stream()
                .findFirst();

        if (investmentAccounts.isEmpty()) {
            throw new ResourceNotFoundException("Investment Account not found");
        }
        InvestmentRecapDto investmentRecapDto = investmentAccountMapper.investmentAccountToInvestmentRecapDto(investmentAccounts.get());
        return investmentRecapDto;
    }
}
