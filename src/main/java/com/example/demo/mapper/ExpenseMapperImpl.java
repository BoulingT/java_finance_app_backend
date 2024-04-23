package com.example.demo.mapper;

import com.example.demo.dto.MonthlyExpenseListDto;
import com.example.demo.entity.MonthlyExpenseList;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Data
@Component
public class ExpenseMapperImpl implements ExpenseMapper {

    private final ModelMapper modelMapper;

    @Override
    public MonthlyExpenseListDto monthlyExpenseListToMonthlyExpenseListDto(MonthlyExpenseList monthlyExpenseList) {
        return modelMapper.map(monthlyExpenseList, MonthlyExpenseListDto.class);
    }

    //MonthlyExpenseList monthlyExpenseListDtoToMonthlyExpenseList(MonthlyExpenseListDto monthlyExpenseListDto);
}