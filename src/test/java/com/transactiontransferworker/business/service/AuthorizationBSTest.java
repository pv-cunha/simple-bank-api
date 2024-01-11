package com.transactiontransferworker.business.service;

import com.transactiontransferworker.exceptions.TransactionNotAuthorizedException;
import com.transactiontransferworker.gateway.AuthorizationGateway;
import com.transactiontransferworker.gateway.dto.AuthorizationResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class AuthorizationBSTest {
    @Spy
    @InjectMocks
    private AuthorizationBS authorizationBS;

    @Mock
    private AuthorizationGateway authorizationGateway;

    @Test
    public void shouldBeAbleToAuthorizeARequest() {
        AuthorizationResponse authorizationResponse = new AuthorizationResponse();
        authorizationResponse.setMessage("Autorizado");
        ResponseEntity<AuthorizationResponse> response = ResponseEntity.ok(authorizationResponse);

        when(authorizationGateway.sendAuthorizationRequest()).thenReturn(response);

        authorizationBS.getAuthorization();
        verify(authorizationBS).getAuthorization();
    }

    @Test
    public void shouldNotBeAbleToAuthorizeARequest() {
        AuthorizationResponse authorizationResponse = new AuthorizationResponse();
        authorizationResponse.setMessage("NaoAutorizado");
        ResponseEntity<AuthorizationResponse> response = ResponseEntity.ok(authorizationResponse);

        when(authorizationGateway.sendAuthorizationRequest()).thenReturn(response);

        assertThrows(TransactionNotAuthorizedException.class, () -> authorizationBS.getAuthorization());
    }

}