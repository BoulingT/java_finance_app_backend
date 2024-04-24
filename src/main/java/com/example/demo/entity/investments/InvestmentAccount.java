package com.example.demo.entity.investments;

import com.example.demo.entity.investments.pea.PeaAccount;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import java.util.Set;

@Data
@Entity
public class InvestmentAccount {

    @Id
    private Long id;

    @OneToMany
    private Set<PeaAccount> peaAccountList;

}
