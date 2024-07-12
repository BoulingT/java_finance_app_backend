package com.example.demo.service;

import com.example.demo.dto.incomes.IncomeDto;
import com.example.demo.dto.incomes.IncomeTypeDto;
import com.example.demo.dto.incomes.MonthlyIncomeDto;
import com.example.demo.entity.incomes.Income;
import com.example.demo.entity.incomes.IncomeType;
import com.example.demo.mapper.interfaces.IIncomeMapper;
import com.example.demo.repository.incomes.IncomeRespository;
import com.example.demo.repository.incomes.IncomeTypeRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IncomeService {

    private final IncomeRespository incomeRespository;

    private final IncomeTypeRepository incomeTypeRepository;

    private final IIncomeMapper incomeMapper;

    public IncomeDto addNewIncome(IncomeDto incomeDto) throws BadRequestException {
        if (incomeDto.getId() != null) {
            throw new BadRequestException("IncomeDto must have a null id parameter");
        }
        final var income = mapDtoToEntity(incomeDto);
        final var savedIncome = incomeRespository.save(income);
        return mapIncomeEntityTodDto(savedIncome);
    }

    public MonthlyIncomeDto getCurrentMonthlyIncome() {
        YearMonth currentMonth = YearMonth.now();
        final var currentMonthIncomeSet = incomeRespository.findByUserIdAndCreationDateBetween(
                1L,
                currentMonth.atDay(1),
                currentMonth.atEndOfMonth()
        );
        return mapEntitySetToMonthlyIncomeDto(currentMonthIncomeSet);
    }

    public IncomeTypeDto addNewIncomeType(IncomeTypeDto incomeTypeDto) throws BadRequestException {
        if (incomeTypeDto.getId() != null) {
            throw new BadRequestException("IncomeTypeDto must have a null id parameter");
        }
        if (incomeTypeRepository.existsByLabel(incomeTypeDto.getLabel())) {
            throw new BadRequestException("IncomeType already exists");
        }
        final var incomeType = mapIncomeTypeDtoToIncomeTypeEntity(incomeTypeDto);
        final var savedIncomeType = incomeTypeRepository.save(incomeType);
        return mapIncomeTypeToIncomeTypeDto(savedIncomeType);
    }

    private MonthlyIncomeDto mapEntitySetToMonthlyIncomeDto(Set<Income> currentMonthIncomeSet) {
        MonthlyIncomeDto monthlyIncomeDto = new MonthlyIncomeDto();
        final var currentLocalDate = LocalDate.now();
        final var salaryIncome = findIncomeByIncomeTypeLabel(currentMonthIncomeSet, "Salaire");
        final var aidsIncome = findIncomeSetByIncomeTypeLabel(currentMonthIncomeSet, "CAF");
        monthlyIncomeDto.setActiveMonth(currentLocalDate);
        monthlyIncomeDto.setSalary(incomeMapper.entityToDto(salaryIncome));
        monthlyIncomeDto.setAids(aidsIncome.stream()
                .map(incomeMapper::entityToDto)
                .collect(Collectors.toSet())
        );
        monthlyIncomeDto.setTotalIncomeAmount(currentMonthIncomeSet);
        return monthlyIncomeDto;
    }

    private Set<Income> findIncomeSetByIncomeTypeLabel(Set<Income> currentMonthIncomeSet, String incomeTypeLabel) {
        return currentMonthIncomeSet.stream()
                .filter(income -> income.getIncomeType().getLabel().equals(incomeTypeLabel))
                .collect(Collectors.toSet());
    }

    private Income findIncomeByIncomeTypeLabel(Set<Income> currentMonthIncomeSet, String incomeTypeLabel) {
        final var salaryIncome = currentMonthIncomeSet.stream()
                .filter(income -> income.getIncomeType().getLabel().equals(incomeTypeLabel))
                .findFirst();
        return salaryIncome.orElse(null);
    }

    private Income mapDtoToEntity(IncomeDto incomeDto) {
        Income income = incomeMapper.dtoToEntity(incomeDto);
        income.setIncomeType(mapIncomeTypeDtoToIncomeTypeEntity(incomeDto.getIncomeType()));
        return income;
    }

    private IncomeType mapIncomeTypeDtoToIncomeTypeEntity(IncomeTypeDto incomeTypeDto) {
        IncomeType incomeType = new IncomeType();
        incomeType.setId(incomeTypeDto.getId());
        incomeType.setLabel(incomeTypeDto.getLabel());
        return incomeType;
    }

    private IncomeDto mapIncomeEntityTodDto(Income savedIncome) {
        IncomeDto incomeDto = incomeMapper.entityToDto(savedIncome);
        incomeDto.setIncomeType(mapIncomeTypeToIncomeTypeDto(savedIncome.getIncomeType()));
        return null;
    }

    private IncomeTypeDto mapIncomeTypeToIncomeTypeDto(IncomeType incomeType) {
        return new IncomeTypeDto(incomeType.getId(), incomeType.getLabel());
    }
}

