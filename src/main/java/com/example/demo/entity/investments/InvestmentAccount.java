package com.example.demo.entity.investments;

import com.example.demo.entity.investments.pea.PeaAccount;
import com.example.demo.entity.investments.per.PerAccount;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import java.util.Set;

@Data
@Entity
public class InvestmentAccount {

    @Id
    private Long id;

    @OneToMany
    private Set<PeaAccount> peaAccountList;

    @OneToOne
    private PerAccount perAccount;

}
