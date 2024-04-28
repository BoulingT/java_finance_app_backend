package com.example.demo.mapper;

import com.example.demo.dto.investment.InvestmentRecapDto;
import com.example.demo.entity.investments.InvestmentAccount;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Data
@Component
public class InvestmentAccountMapperImpl  implements InvestmentAccountMapper {

    @Override
    public InvestmentRecapDto investmentAccountToInvestmentRecapDto(InvestmentAccount investmentAccount) {

        InvestmentRecapDto investmentRecapDto = new InvestmentRecapDto();
        investmentRecapDto.setId(investmentAccount.getId());
//        investmentRecapDto.setTotalValue(investmentRecapDto.setTotalValue());
        return null;
    }
}
