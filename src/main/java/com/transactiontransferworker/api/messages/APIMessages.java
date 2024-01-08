package com.transactiontransferworker.api.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;

@Configuration
public class APIMessages {

    @Autowired
    private MessageSource messageSource;

    public String getSuccessFullMessage() {
        return getMessageByKey("success.operation");
    }

    public String getMessageByKey(String key) {
        return messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
    }

}
