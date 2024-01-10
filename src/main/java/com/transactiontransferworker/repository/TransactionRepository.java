package com.transactiontransferworker.repository;

import com.transactiontransferworker.repository.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {

    @Query("select transaction from transactions transaction where transaction.sender.id = :userId")
    List<Transaction> getUserTransactionsByUserId(UUID userId);

}
