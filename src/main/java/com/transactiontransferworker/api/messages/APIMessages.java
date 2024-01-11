package com.transactiontransferworker.api.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

@Configuration
public class APIMessages {

    @Autowired
    private MessageSource messageSource;

    @Bean
    public LocaleResolver getLocaleResolver() {
        AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
        localeResolver.setDefaultLocale(new Locale("pt", "BR"));
        return localeResolver;
    }

    public String getSuccessFullMessage() {
        return getMessageByKey("success.operation");
    }

    public String getMessageByKey(String key) {
        return messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
    }

}
