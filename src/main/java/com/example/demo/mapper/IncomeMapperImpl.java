package com.example.demo.mapper;

import com.example.demo.dto.incomes.IncomeDto;
import com.example.demo.entity.incomes.Income;
import com.example.demo.mapper.interfaces.IIncomeMapper;
import org.springframework.stereotype.Service;

@Service
public class IncomeMapperImpl implements IIncomeMapper {
    @Override
    public Income dtoToEntity(IncomeDto incomeDto) {
        Income income = new Income();
        if (incomeDto.getId() != null) {
            income.setId(incomeDto.getId());
        }
        income.setUserId(incomeDto.getUserId());
        income.setCreationDate(incomeDto.getCreationDate());
        income.setAmount(incomeDto.getAmount());
        income.setLabel(incomeDto.getLabel());
        return income;
    }

    @Override
    public IncomeDto entityToDto(Income income) {
        IncomeDto incomeDto = new IncomeDto();
        incomeDto.setId(income.getId());
        incomeDto.setUserId(income.getUserId());
        incomeDto.setCreationDate(income.getCreationDate());
        incomeDto.setAmount(income.getAmount());
        incomeDto.setLabel(income.getLabel());
        return incomeDto;
    }

}
