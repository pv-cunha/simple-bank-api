package com.transactiontransferworker.business.object;

import com.transactiontransferworker.api.dtos.TransactionDTO;
import com.transactiontransferworker.business.service.AuthorizationBS;
import com.transactiontransferworker.business.service.TransactionBS;
import com.transactiontransferworker.business.service.UserBS;
import com.transactiontransferworker.repository.models.Transaction;
import com.transactiontransferworker.repository.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransactionBO {

    @Autowired
    private TransactionBS transactionBS;

    @Autowired
    private UserBS userBS;

    @Autowired
    private AuthorizationBS authorizationBS;

    @Autowired
    private UserBO userBO;

    public void createTransaction(TransactionDTO transactionDTO) {
        User sender = userBS.getById(transactionDTO.getSenderId());
        User receiver = userBS.getById(transactionDTO.getReceiverId());
        BigDecimal amount = transactionDTO.getAmount();

        userBO.validateTransaction(sender, transactionDTO.getAmount());

        authorizationBS.getAuthorization();

        Transaction transaction = new Transaction();
        transaction.setSender(sender);
        transaction.setReceiver(receiver);
        transaction.setAmount(amount);

        transactionBS.save(transaction);
        userBO.updateSenderBalance(sender, transaction.getAmount());
        userBO.updateReceiverBalance(receiver, transaction.getAmount());
    }
}
