package com.example.demo.dto.investment;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Set;

@Data
@AllArgsConstructor
public class InvestmentAccountDto {

    private Long id;

    private Set<InvestmentAccountDto> investmentAccounts;

    private Double totalValue;
}
