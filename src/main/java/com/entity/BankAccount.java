package com.entity;

import org.hibernate.annotations.CollectionId;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "bankAccount")
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "accountBalance")
    private BigDecimal accountBalance;

    public Long getId() {
        return id;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }
}
