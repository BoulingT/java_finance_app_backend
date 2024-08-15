package com.example.demo.entity.expenses;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity(name = "expense_type")
public class ExpenseType {

    public ExpenseType(Long id, String label) {
        this.id = id;
        this.label = label;
    }

    public ExpenseType() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String label;

}
