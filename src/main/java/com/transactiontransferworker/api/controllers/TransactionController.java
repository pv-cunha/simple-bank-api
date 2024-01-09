package com.transactiontransferworker.api.controllers;

import com.transactiontransferworker.api.dtos.ResponseDTO;
import com.transactiontransferworker.api.dtos.TransactionDTO;
import com.transactiontransferworker.api.dtos.TransactionTransferDTO;
import com.transactiontransferworker.api.messages.APIMessages;
import com.transactiontransferworker.business.object.TransactionBO;
import com.transactiontransferworker.utils.Constants;
import com.transactiontransferworker.utils.PathConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = PathConstants.PATH_SIMPLE_BANK_TRANSACTION)
public class TransactionController {

    @Autowired
    private APIMessages APIMessages;

    @Autowired
    private TransactionBO transactionBO;

    @PostMapping()
    public @ResponseBody ResponseDTO<TransactionTransferDTO> createTransferTransaction(@RequestBody @Valid TransactionDTO transactionDTO) {

        TransactionTransferDTO transaction = transactionBO.createTransaction(transactionDTO);

        return ResponseDTO.success(APIMessages.getSuccessFullMessage(), Constants.SUCCESS_CODE, transaction);
    }
}
