package com.example.demo.entity.investments.pea;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Data
@Entity
public class PeaAccount {

    @Id
    private Long id;

    private String brokerName;

    @ManyToMany
    private Set<Stock> stockSet;

    @OneToMany
    private Set<PeaTransaction> peaTransactionSet;

    @OneToMany
    private Set<PeaDeposit> peaDepositSet;

    @OneToMany
    private Set<PeaWithdraw> peaWithdrawSet;
}
