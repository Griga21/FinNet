package com.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "Transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ACCOUNT_ID")
    private UUID accountId;
    @Column(name = "TYPE")
    private Integer type;
    @Column(name = "AMOUNT")
    private BigDecimal amount;
    @Column(name = "CREATED_AT")
    private Instant createdAt;

    public Long getId() {
        return id;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public void setAccountId(UUID accountId) {
        this.accountId = accountId;
    }

    public TransactionType getType() {
        return TransactionType.fromCode(type);
    }

    public void setType(TransactionType type) {
        this.type = type.getCode();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
