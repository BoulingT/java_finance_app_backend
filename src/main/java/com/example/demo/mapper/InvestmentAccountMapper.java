package com.example.demo.mapper;

import com.example.demo.dto.investment.InvestmentAccountDto;
import com.example.demo.entity.investments.InvestmentAccount;

public interface InvestmentAccountMapper {

    InvestmentAccountDto investmentAccountToInvestmentAccountDto(InvestmentAccount investmentAccount);
}
