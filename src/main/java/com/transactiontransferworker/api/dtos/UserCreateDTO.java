package com.transactiontransferworker.api.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserCreateDTO {

    private String firstName;

    private String lastName;

    private String document;

    private String email;

}
