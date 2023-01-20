package com.jeterson.meuorcamento.security.filters;

import com.jeterson.meuorcamento.security.utils.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import java.io.IOException;
import java.util.ArrayList;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    public static final String TOKEN_PREFIX = "Bearer ";

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        var headerToken = request.getHeader(AUTHORIZATION);

        if(headerToken == null){
            chain.doFilter(request, response);
            return;
        }
        if(!headerToken.startsWith(TOKEN_PREFIX)){
            chain.doFilter(request, response);
            return;
        }

        var token = headerToken.replace(TOKEN_PREFIX, "");

        var authenticationToken = getAuthenticationToken(token);

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request, response);

    }

    private UsernamePasswordAuthenticationToken getAuthenticationToken(String token) {

        if(!JwtUtils.getInstance().isTokenValid(token)){
            return null;
        }
        var username = JwtUtils.getInstance().extractUsername(token);

        return new UsernamePasswordAuthenticationToken(username,null, new ArrayList<>());
    }
}
