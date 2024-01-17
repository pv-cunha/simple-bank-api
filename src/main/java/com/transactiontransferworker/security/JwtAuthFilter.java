package com.transactiontransferworker.security;

import com.transactiontransferworker.business.service.JwtBS;
import com.transactiontransferworker.business.service.UserBS;
import com.transactiontransferworker.repository.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    private JwtBS jwtBS;

    @Autowired
    private UserBS userBS;

    @Transactional
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String token = recoverToken(httpServletRequest);

        if (Objects.nonNull(token)) {
            String subject = jwtBS.decodeToken(token);

            User user = userBS.getByEmail(subject);
            Collection<GrantedAuthority> authorities = getAuthorities(user);

            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, null, authorities);

            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private String recoverToken(HttpServletRequest httpServletRequest) {
        String authorizationToken = httpServletRequest.getHeader("Authorization");

        if (authorizationToken == null) {
            return null;
        }

        return authorizationToken.replace("Bearer ", "");
    }

    private Collection<GrantedAuthority> getAuthorities(User user) {
        return user.getPermissionsGroup()
                .stream()
                .flatMap(group -> group.getPermissions().stream())
                .map(permission -> new SimpleGrantedAuthority(permission.getName().toUpperCase()))
                .collect(Collectors.toSet());
    }
}
