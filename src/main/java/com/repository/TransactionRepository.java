package com.repository;

import com.entity.Transaction;
import com.entity.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query("SELECT t FROM Transaction t WHERE (t.bankAccountFrom.id = :accountId OR t.bankAccountTo.id = :accountId) AND t.status = :status")
    List<Transaction> findAllByAccountIdAndStatus(@Param("accountId") Long accountId, @Param("status") Integer status);
}
