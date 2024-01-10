package com.transactiontransferworker.business.service;

import com.transactiontransferworker.repository.TransactionRepository;
import com.transactiontransferworker.repository.models.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class TransactionBSTest {
    @Spy
    @InjectMocks
    private TransactionBS transactionBS;

    @Mock
    private TransactionRepository transactionRepository;

    @Test
    public void shouldBeAbleToSaveATransaction() {
        Transaction transaction = new Transaction();

        when(transactionRepository.save(any())).thenReturn(transaction);

        transactionBS.save(transaction);
        verify(transactionBS).save(transaction);
    }
}