package com.example.demo.entity.investments.pea;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class PeaTransaction {

    @Id
    private Long id;

    private LocalDateTime purchaseDate;

    @ManyToOne
    private PeaAccount peaAccount;

    @ManyToOne
    private Stock stock;

    private Long stockValue;

    private Long quantity;

    @ManyToOne
    private PeaTransactionType peaTransactionType;
}
