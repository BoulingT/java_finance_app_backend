package com.example.demo.entity.investments.pea;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class PeaTransactionType {

    @Id
    private Long id;

    private String label;
}
