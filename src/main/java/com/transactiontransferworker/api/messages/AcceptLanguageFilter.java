package com.transactiontransferworker.api.messages;

import org.apache.logging.log4j.util.Strings;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class AcceptLanguageFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String acceptLanguage = Optional.ofNullable(request.getHeader(HttpHeaders.ACCEPT_LANGUAGE))
                .filter(Strings::isEmpty)
                .orElse(LocaleContextHolder.getLocale().toLanguageTag());

        response.addHeader(HttpHeaders.CONTENT_LANGUAGE, acceptLanguage);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
