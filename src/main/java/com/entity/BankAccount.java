package com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CollectionId;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
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

    @OneToMany(mappedBy = "bankAccount",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    @JsonIgnore
    private List<Transaction> transactions = new ArrayList<>();

    @Column(name = "active", nullable = false)
    private Boolean isActive;

    @Column(name = "CREATED_AT")
    private Instant createdAt;

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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
