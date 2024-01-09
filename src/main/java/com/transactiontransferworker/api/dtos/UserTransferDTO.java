package com.transactiontransferworker.api.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.transactiontransferworker.repository.enuns.UserType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserTransferDTO {

    private String firstName;

    private String lastName;

    private String document;

    private String email;

    private BigDecimal balance;

    private UserType userType;

}
