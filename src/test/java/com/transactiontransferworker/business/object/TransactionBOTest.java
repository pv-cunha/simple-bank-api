package com.transactiontransferworker.business.object;

import com.transactiontransferworker.api.dtos.TransactionDTO;
import com.transactiontransferworker.api.dtos.TransactionTransferDTO;
import com.transactiontransferworker.api.dtos.UserDepositDTO;
import com.transactiontransferworker.business.service.AuthorizationBS;
import com.transactiontransferworker.business.service.NotificationBS;
import com.transactiontransferworker.business.service.TransactionBS;
import com.transactiontransferworker.business.service.UserBS;
import com.transactiontransferworker.converters.TransactionConverter;
import com.transactiontransferworker.repository.models.Transaction;
import com.transactiontransferworker.repository.models.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class TransactionBOTest {
    @Spy
    @InjectMocks
    private TransactionBO transactionBO;

    @Mock
    private TransactionBS transactionBS;

    @Mock
    private UserBS userBS;

    @Mock
    private NotificationBS notificationBS;

    @Mock
    private AuthorizationBS authorizationBS;

    @Mock
    private UserBO userBO;

    @Mock
    private TransactionConverter transactionConverter;

    @Test
    public void shouldBeAbleToCreateATransaction() {
        User sender = new User();
        User receiver = new User();
        TransactionTransferDTO transactionTransferDTO = new TransactionTransferDTO();

        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setAmount(new BigDecimal("10"));
        transactionDTO.setSenderDocument(UUID.randomUUID().toString());
        transactionDTO.setReceiverDocument(UUID.randomUUID().toString());

        when(userBS.getByDocument(any())).thenReturn(sender);
        when(userBS.getByDocument(any())).thenReturn(receiver);
        doNothing().when(userBO).validateTransaction(any(), any());
        doNothing().when(authorizationBS).getAuthorization();
        doNothing().when(transactionBS).save(any());
        doNothing().when(userBO).updateSenderBalance(any(), any());
        doNothing().when(userBO).updateReceiverBalance(any(), any());
        doNothing().when(notificationBS).sendNotification();
        when(transactionConverter.convertToTransactionTransferDTO(any())).thenReturn(transactionTransferDTO);

        TransactionTransferDTO transaction = transactionBO.createTransaction(transactionDTO);

        assertNotNull(transaction);
    }

    @Test
    public void shouldBeAbleToDepositAnAmount() {
        User user = new User();
        UserDepositDTO userDepositDTO = new UserDepositDTO();

        when(userBS.getByDocument(any())).thenReturn(user);

        transactionBO.depositAmount(userDepositDTO);
        verify(transactionBO).depositAmount(userDepositDTO);
    }

    @Test
    public void shouldBeAbleToGetUserTransactionsByDocument() {
        List<Transaction> transactionList = new ArrayList<>();
        List<TransactionTransferDTO> transferDTOList = new ArrayList<>();

        when(transactionBS.getUserTransactionsByDocument(any())).thenReturn(transactionList);
        when(transactionConverter.convertToTransactionTransferDTOList(any())).thenReturn(transferDTOList);

        List<TransactionTransferDTO> userTransactionsByDocument = transactionBO.getUserTransactionsByDocument(UUID.randomUUID().toString());

        assertNotNull(userTransactionsByDocument);
    }
}