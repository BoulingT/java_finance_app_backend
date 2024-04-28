package com.example.demo.entity.investments.per;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class PerAccount {

    @Id
    private Long id;

    private String brokerName;

    @OneToMany
    private Set<PerDeposit> perDepositSet;
}
