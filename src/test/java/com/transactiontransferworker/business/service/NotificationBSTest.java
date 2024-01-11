package com.transactiontransferworker.business.service;

import com.transactiontransferworker.exceptions.TransactionNotAuthorizedException;
import com.transactiontransferworker.gateway.NotificationGateway;
import com.transactiontransferworker.gateway.dto.NotificationResponse;
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
public class NotificationBSTest {

    @Spy
    @InjectMocks
    private NotificationBS notificationBS;

    @Mock
    private NotificationGateway notificationGateway;

    @Test
    public void shouldBeAbleToSendANotification() {
        NotificationResponse notificationResponse = new NotificationResponse();
        notificationResponse.setMessage(true);
        ResponseEntity<NotificationResponse> response = ResponseEntity.ok(notificationResponse);

        when(notificationGateway.sendNotificationRequest()).thenReturn(response);

        notificationBS.sendNotification();
        verify(notificationBS).sendNotification();
    }

    @Test
    public void shouldNotBeAbleToSendANotification() {
        NotificationResponse notificationResponse = new NotificationResponse();
        notificationResponse.setMessage(false);
        ResponseEntity<NotificationResponse> response = ResponseEntity.ok(notificationResponse);

        when(notificationGateway.sendNotificationRequest()).thenReturn(response);

        assertThrows(TransactionNotAuthorizedException.class, () -> notificationBS.sendNotification());
    }

}