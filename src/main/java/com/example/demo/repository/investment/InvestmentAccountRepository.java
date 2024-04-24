package com.example.demo.repository.investment;

import com.example.demo.entity.investments.InvestmentAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestmentAccountRepository extends JpaRepository<InvestmentAccount, Long> {
}
