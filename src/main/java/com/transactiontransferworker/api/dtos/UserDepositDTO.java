package com.transactiontransferworker.api.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Getter
@Setter
public class UserDepositDTO {

    @NotBlank
    private String document;

    private BigDecimal depositAmount;

}
