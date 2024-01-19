package com.transactiontransferworker.api.controllers;

import com.transactiontransferworker.api.dtos.ResponseDefaultDTO;
import com.transactiontransferworker.api.dtos.TransactionDTO;
import com.transactiontransferworker.api.dtos.TransactionTransferDTO;
import com.transactiontransferworker.api.dtos.UserDepositDTO;
import com.transactiontransferworker.api.messages.APIMessages;
import com.transactiontransferworker.business.object.TransactionBO;
import com.transactiontransferworker.utils.Constants;
import com.transactiontransferworker.utils.PathConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = PathConstants.PATH_TRANSACTION_TRANSFER_WORKER_TRANSACTION)
public class TransactionController {

    @Autowired
    private APIMessages apiMessages;

    @Autowired
    private TransactionBO transactionBO;

    @PostMapping()
    public @ResponseBody ResponseDefaultDTO<TransactionTransferDTO> transfer(@RequestBody @Valid TransactionDTO transactionDTO) {

        TransactionTransferDTO transaction = transactionBO.createTransaction(transactionDTO);

        return ResponseDefaultDTO.success(apiMessages.getSuccessFullMessage(), Constants.SUCCESS_CODE, transaction);
    }

    @PostMapping(PathConstants.PATH_POST_DEPOSIT_TRANSACTION)
    public @ResponseBody ResponseDefaultDTO<Object> deposit(@RequestBody @Valid UserDepositDTO userDepositDTO) {

        transactionBO.depositAmount(userDepositDTO);

        return ResponseDefaultDTO.success(apiMessages.getSuccessFullMessage(), Constants.SUCCESS_CODE, "ok");
    }

    @GetMapping()
    public @ResponseBody ResponseDefaultDTO<List<TransactionTransferDTO>> getTransactions(@RequestParam String userID) {

        List<TransactionTransferDTO> userTransactionsByDocument = transactionBO.getUserTransactionsByDocument(userID);

        return ResponseDefaultDTO.success(apiMessages.getSuccessFullMessage(), Constants.SUCCESS_CODE, userTransactionsByDocument);
    }
}
