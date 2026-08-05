package com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bankAccount")
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "accountBalance")
    private BigDecimal accountBalance;

    @Column(name = "account_number", nullable = false, unique = true, length = 20)
    private String accountNumber;

    @OneToMany(mappedBy = "bankAccountFrom",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    @JsonIgnore
    private List<Transaction> transactionsFrom = new ArrayList<>();

    @OneToMany(mappedBy = "bankAccountTo",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    @JsonIgnore
    private List<Transaction> transactionsTo = new ArrayList<>();

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "CREATED_AT")
    private Instant createdAt;


    public boolean isActive() {
        return status == AccountStatus.ACTIVE.getCode();
    }

    public boolean hasEnoughMoney(BigDecimal amount) {
        return accountBalance.compareTo(amount) >= 0;
    }

    public void debit(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("Amount must be greater than zero");
        }

        if (!isActive()) {
            throw new RuntimeException("Account is not active");
        }

        if (!hasEnoughMoney(amount)) {
            throw new RuntimeException("Insufficient funds");
        }

        this.accountBalance = this.accountBalance.subtract(amount);
    }

    public void credit(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("Amount must be greater than zero");
        }

        if (!isActive()) {
            throw new RuntimeException("Account is not active");
        }

        this.accountBalance = this.accountBalance.add(amount);
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public AccountStatus getStatus() {
        return AccountStatus.fromCode(status);
    }

    public void setStatus(AccountStatus status) {
        this.status = status.getCode();
    }
}
