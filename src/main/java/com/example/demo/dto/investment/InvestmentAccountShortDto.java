package com.example.demo.dto.investment;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InvestmentAccountShortDto {

    private Long id;

    private String brokerName;

    private Double totalValue;
}
