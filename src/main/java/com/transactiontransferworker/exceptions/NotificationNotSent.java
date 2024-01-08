package com.transactiontransferworker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY, reason = "notification.not.sent")
public class NotificationNotSent extends RuntimeException {
}
