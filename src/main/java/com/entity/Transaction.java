package com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_from_id", nullable = false)
    @JsonIgnore
    private BankAccount bankAccountFrom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_to_id", nullable = false)
    @JsonIgnore
    private BankAccount bankAccountTo;

    @Column(name = "TYPE")
    private Integer type;
    @Column(name = "AMOUNT")
    private BigDecimal amount;
    @Column(name = "CREATED_AT")
    private Instant createdAt;
    @Column(name = "STATUS")
    private Integer status;

    public Long getId() {
        return id;
    }

    public BankAccount getBankAccountFrom() {
        return bankAccountFrom;
    }

    public void setBankAccountFrom(BankAccount bankAccountFrom) {
        this.bankAccountFrom = bankAccountFrom;
    }

    public BankAccount getBankAccountTo() {
        return bankAccountTo;
    }

    public void setBankAccountTo(BankAccount bankAccountTo) {
        this.bankAccountTo = bankAccountTo;
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

    public TransactionStatus getStatus() {
        return TransactionStatus.fromCode(status);
    }

    public void setStatus(TransactionStatus status) {
        this.status = status.getCode();
    }
}
