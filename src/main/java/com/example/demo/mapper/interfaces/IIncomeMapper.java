package com.example.demo.mapper.interfaces;

import com.example.demo.dto.incomes.IncomeDto;
import com.example.demo.dto.incomes.MonthlyIncomeDto;
import com.example.demo.entity.incomes.Income;

import java.util.Set;

public interface IIncomeMapper {

    Income dtoToEntity(IncomeDto incomeDto);

    IncomeDto entityToDto(Income income);

}
