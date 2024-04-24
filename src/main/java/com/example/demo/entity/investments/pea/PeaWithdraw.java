package com.example.demo.entity.investments.pea;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class PeaWithdraw {

    @Id
    private Long id;

    private LocalDateTime withdrawDate;

    @ManyToOne
    private PeaAccount peaAccount;

    private Double amount;
}
