package com.transactiontransferworker.api.controllers;

import com.transactiontransferworker.api.dtos.ResponseDTO;
import com.transactiontransferworker.api.dtos.TransactionDTO;
import com.transactiontransferworker.api.dtos.TransactionTransferDTO;
import com.transactiontransferworker.api.dtos.UserDepositDTO;
import com.transactiontransferworker.api.messages.APIMessages;
import com.transactiontransferworker.business.object.TransactionBO;
import com.transactiontransferworker.utils.Constants;
import com.transactiontransferworker.utils.PathConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = PathConstants.PATH_SIMPLE_BANK_TRANSACTION)
public class TransactionController {

    @Autowired
    private APIMessages apiMessages;

    @Autowired
    private TransactionBO transactionBO;

    @PostMapping()
    public @ResponseBody ResponseDTO<TransactionTransferDTO> createTransferTransaction(@RequestBody @Valid TransactionDTO transactionDTO) {

        TransactionTransferDTO transaction = transactionBO.createTransaction(transactionDTO);

        return ResponseDTO.success(apiMessages.getSuccessFullMessage(), Constants.SUCCESS_CODE, transaction);
    }

    @PostMapping(PathConstants.PATH_POST_DEPOSIT_TRANSACTION)
    public @ResponseBody ResponseDTO<Object> depositAmount(@RequestBody @Valid UserDepositDTO userDepositDTO) {

        transactionBO.depositAmount(userDepositDTO);

        return ResponseDTO.success(apiMessages.getSuccessFullMessage(), Constants.SUCCESS_CODE, "ok");
    }

    @GetMapping()
    public @ResponseBody ResponseDTO<List<TransactionTransferDTO>> getUserTransactions(@RequestParam String userID) {

        List<TransactionTransferDTO> userTransactionsByDocument = transactionBO.getUserTransactionsByDocument(userID);

        return ResponseDTO.success(apiMessages.getSuccessFullMessage(), Constants.SUCCESS_CODE, userTransactionsByDocument);
    }
}
