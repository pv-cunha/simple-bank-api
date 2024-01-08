package com.transactiontransferworker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY, reason = "user.merchant")
public class UserMerchantException extends RuntimeException {
}
