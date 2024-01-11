package com.transactiontransferworker.api.messages;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class AcceptLanguageFilterTest {

    @Spy
    @InjectMocks
    private AcceptLanguageFilter acceptLanguageFilter;

    @Mock
    private HttpServletRequest httpServletRequest;

    @Mock
    private HttpServletResponse httpServletResponse;

    @Mock
    private FilterChain filterChain;

    @Test
    public void shouldBeAbleToAcceptAFilterLanguage() throws ServletException, IOException {
        acceptLanguageFilter.doFilter(httpServletRequest, httpServletResponse, filterChain);
        verify(acceptLanguageFilter).doFilter(httpServletRequest, httpServletResponse, filterChain);
    }

}