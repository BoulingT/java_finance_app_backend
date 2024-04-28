package com.example.demo.entity.investments.per;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class PerDeposit {

    @Id
    private Long id;

    @OneToOne
    private PerAccount perAccount;

    private LocalDateTime depositDate;

    private Double amount;
}
