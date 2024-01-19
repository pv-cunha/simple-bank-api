package com.transactiontransferworker.api.exceptionhandler;

import com.transactiontransferworker.api.dtos.ResponseDefaultDTO;
import com.transactiontransferworker.api.messages.APIMessages;
import com.transactiontransferworker.exceptions.UserAlreadyExistsException;
import com.transactiontransferworker.exceptions.UserBalanceException;
import com.transactiontransferworker.exceptions.UserMerchantException;
import com.transactiontransferworker.utils.AnnotationValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class APIExceptionHandler {

    @Autowired
    private APIMessages apiMessages;

    @ExceptionHandler({UserAlreadyExistsException.class, UserMerchantException.class, UserBalanceException.class})
    public ResponseEntity<ResponseDefaultDTO<String>> handleException(RuntimeException exception) {
        String keyMessage = AnnotationValue.getClassAnnotationValue(exception.getClass(), ResponseStatus.class, "reason");

        String messageByKey = apiMessages.getMessageByKey(keyMessage);

        HttpStatus status = AnnotationValue.getClassAnnotationValue(exception.getClass(), ResponseStatus.class, "code");

        return ResponseEntity.status(status).body(ResponseDefaultDTO.error(messageByKey, String.valueOf(status.value()), ""));
    }

}
