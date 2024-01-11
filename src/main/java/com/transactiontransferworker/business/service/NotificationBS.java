package com.transactiontransferworker.business.service;

import com.transactiontransferworker.exceptions.TransactionNotAuthorizedException;
import com.transactiontransferworker.gateway.NotificationGateway;
import com.transactiontransferworker.gateway.dto.NotificationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class NotificationBS {

    @Autowired
    private NotificationGateway notificationGateway;

    public void sendNotification() {
        ResponseEntity<NotificationResponse> response = notificationGateway.sendNotificationRequest();

        if (!(response.getStatusCode() == HttpStatus.OK) || validateNotificationMessage(response.getBody().isMessage())) {
            throw new TransactionNotAuthorizedException();
        }
    }

    private boolean validateNotificationMessage(boolean notificationMessage) {
        return !notificationMessage;
    }
}
