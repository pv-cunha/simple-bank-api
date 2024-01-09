package com.transactiontransferworker.api.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionTransferDTO {

    private UserTransferDTO sender;

    private UserTransferDTO receiver;

    private BigDecimal amountTransferred;

}
