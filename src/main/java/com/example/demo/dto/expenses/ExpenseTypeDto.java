package com.example.demo.dto.expenses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExpenseTypeDto {
    
    private Long id;

    private String label;
}
