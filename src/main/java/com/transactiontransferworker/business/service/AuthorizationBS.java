package com.transactiontransferworker.business.service;

import com.transactiontransferworker.exceptions.TransactionNotAuthorizedException;
import com.transactiontransferworker.gateway.AuthorizationGateway;
import com.transactiontransferworker.gateway.dto.AuthorizationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationBS {

    @Autowired
    private AuthorizationGateway authorizationGateway;

    public void getAuthorization() {
        ResponseEntity<AuthorizationResponse> response = authorizationGateway.sendAuthorizationRequest();

        HttpStatus statusCode = response.getStatusCode();

        if (!(statusCode == HttpStatus.OK) || !(validateAuthorizationMessage(response.getBody().getMessage()))) {
            throw new TransactionNotAuthorizedException();
        }
    }

    private boolean validateAuthorizationMessage(String authorizationMessage) {
        return authorizationMessage.equalsIgnoreCase("Autorizado");
    }

}
