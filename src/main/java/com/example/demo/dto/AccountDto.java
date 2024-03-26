package com.example.demo.dto;

import com.example.demo.entity.Transaction;
import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
public class AccountDto {

    private Long id;

    private LocalDateTime createdAt;

    private UUID userId;

    private Long balance;

    private Long typeId;

    private List<Transaction> debitTransactions;

    private List<Transaction> creditTransactions;

}
