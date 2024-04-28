package com.example.demo.entity.incomes;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class IncomeType {

    @Id
    private Long id;

    private String label;
}
