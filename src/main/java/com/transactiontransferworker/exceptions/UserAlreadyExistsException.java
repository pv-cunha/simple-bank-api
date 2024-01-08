package com.transactiontransferworker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY, reason = "user.already.exists")
public class UserAlreadyExistsException  extends RuntimeException {
}
