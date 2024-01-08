package com.transactiontransferworker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY, reason = "transaction.not.authorized")
public class TransactionNotAuthorizedException extends RuntimeException {
}
