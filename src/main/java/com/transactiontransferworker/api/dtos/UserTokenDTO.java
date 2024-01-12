package com.transactiontransferworker.api.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserTokenDTO {

    private String token;

    public UserTokenDTO(String token) {
        this.token = token;
    }
}
