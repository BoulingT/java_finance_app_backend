package com.example.demo.mapper;

import com.example.demo.dto.investment.InvestmentAccountDto;
import com.example.demo.entity.investments.InvestmentAccount;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Data
@Component
public class InvestmentAccountMapperImpl  implements InvestmentAccountMapper {

    private final ModelMapper modelMapper;

    @Override
    public InvestmentAccountDto investmentAccountToInvestmentAccountDto(InvestmentAccount investmentAccount) {
        return modelMapper.map(investmentAccount, InvestmentAccountDto.class);
    }
}
