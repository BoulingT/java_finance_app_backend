package com.example.demo.entity.incomes;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity(name = "income_type")
public class IncomeType {

    public IncomeType(Long id, String label) {
        this.id = id;
        this.label = label;
    }

    public IncomeType() {
    }

    @Id
    private Long id;

    private String label;
}
