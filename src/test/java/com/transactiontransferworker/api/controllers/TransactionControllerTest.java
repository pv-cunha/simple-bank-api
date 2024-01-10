package com.transactiontransferworker.api.controllers;

import com.transactiontransferworker.api.dtos.ResponseDTO;
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

        ResponseDTO<TransactionTransferDTO> transferTransaction = transactionController.createTransferTransaction(transactionDTO);

        assertNotNull(transferTransaction);
    }

    @Test
    public void shouldBeAbleToDepositAnAmount() {
        UserDepositDTO userDepositDTO = new UserDepositDTO();

        doNothing().when(transactionBO).depositAmount(any());

        ResponseDTO<Object> objectResponseDTO = transactionController.depositAmount(userDepositDTO);

        assertNotNull(objectResponseDTO);
    }

    @Test
    public void shouldBeAbleToGetUserTransactions() {
        List<TransactionTransferDTO> userTransactionsByDocument = new ArrayList<>();

        when(transactionBO.getUserTransactionsByDocument(any())).thenReturn(userTransactionsByDocument);

        ResponseDTO<List<TransactionTransferDTO>> transactions = transactionController.getUserTransactions("id");

        assertNotNull(transactions);
    }

}