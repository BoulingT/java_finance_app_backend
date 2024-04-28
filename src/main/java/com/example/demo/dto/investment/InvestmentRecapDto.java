package com.example.demo.dto.investment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvestmentRecapDto {

    private Long id;

    private Set<InvestmentAccountShortDto> investmentPeaAccountList;

    private InvestmentAccountShortDto investmentPerAccountList;

    private Double totalValue;

    public void setTotalValue() {
        
    }
}
