package com.transactiontransferworker.business.service;

import com.transactiontransferworker.repository.TransactionRepository;
import com.transactiontransferworker.repository.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionBS {

    @Autowired
    private TransactionRepository transactionRepository;

    @Transactional
    public void save(Transaction transaction) {
        transactionRepository.save(transaction);
    }
}
