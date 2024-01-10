package com.transactiontransferworker.api.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionDTO {

    @NotBlank
    private String senderDocument;

    @NotBlank
    private String receiverDocument;

    @NotNull
    private BigDecimal amount;

}
