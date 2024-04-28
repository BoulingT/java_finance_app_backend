package com.example.demo.mapper;

import com.example.demo.dto.investment.InvestmentRecapDto;
import com.example.demo.entity.investments.InvestmentAccount;

public interface InvestmentAccountMapper {

    InvestmentRecapDto investmentAccountToInvestmentRecapDto(InvestmentAccount investmentAccount);

}
