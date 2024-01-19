package com.transactiontransferworker.api.controllers;

import com.transactiontransferworker.api.dtos.ResponseDefaultDTO;
import com.transactiontransferworker.api.dtos.TransactionDTO;
import com.transactiontransferworker.api.dtos.TransactionTransferDTO;
import com.transactiontransferworker.api.dtos.UserDepositDTO;
import com.transactiontransferworker.api.messages.APIMessages;
import com.transactiontransferworker.business.object.TransactionBO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class TransactionControllerTest {

    @InjectMocks
    private TransactionController transactionController;

    @Mock
    private APIMessages apiMessages;

    @Mock
    private TransactionBO transactionBO;

    @Test
    public void shouldBeAbleToCreateATransferTransaction() {
        TransactionDTO transactionDTO = new TransactionDTO();
        TransactionTransferDTO transactionTransferDTO = new TransactionTransferDTO();

        when(transactionBO.createTransaction(any())).thenReturn(transactionTransferDTO);

        ResponseDefaultDTO<TransactionTransferDTO> transferTransaction = transactionController.transfer(transactionDTO);

        assertNotNull(transferTransaction);
    }

    @Test
    public void shouldBeAbleToDepositAnAmount() {
        UserDepositDTO userDepositDTO = new UserDepositDTO();

        doNothing().when(transactionBO).depositAmount(any());

        ResponseDefaultDTO<Object> objectResponseDefaultDTO = transactionController.deposit(userDepositDTO);

        assertNotNull(objectResponseDefaultDTO);
    }

    @Test
    public void shouldBeAbleToGetUserTransactions() {
        List<TransactionTransferDTO> userTransactionsByDocument = new ArrayList<>();

        when(transactionBO.getUserTransactionsByDocument(any())).thenReturn(userTransactionsByDocument);

        ResponseDefaultDTO<List<TransactionTransferDTO>> transactions = transactionController.getTransactions("id");

        assertNotNull(transactions);
    }

}