package com.transactiontransferworker.api.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionDTO {

    @NotBlank
    private UUID senderId;

    @NotBlank
    private UUID receiverId;

    @NotBlank
    private BigDecimal amount;

}
