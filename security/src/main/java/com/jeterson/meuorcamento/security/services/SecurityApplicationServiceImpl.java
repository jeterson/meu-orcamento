package com.jeterson.meuorcamento.security.services;

import com.jeterson.meuorcamento.domain.application.service.input.service.SecurityApplicationService;
import com.jeterson.meuorcamento.domain.application.service.input.service.UsernameApplicationService;
import com.jeterson.meuorcamento.domain.core.entities.User;
import com.jeterson.meuorcamento.security.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecurityApplicationServiceImpl implements SecurityApplicationService {

    @Qualifier("usernameApplicationService")
    private final UsernameApplicationService usernameApplicationService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User getAuthenticatedUser() {
        if(SecurityContextHolder.getContext().getAuthentication() == null)
            throw new RuntimeException("No one user authenticated");

        var username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(username == null)
            throw new RuntimeException("Username not found in authentication");

        var user = usernameApplicationService.findByUsername(username);

        return user;
    }

    @Override
    public boolean isTokenValid(String token) {
        if(token == null || token.isEmpty() || token.isBlank())
            return false;

        return JwtUtils.getInstance().isTokenValid(token);
    }

    @Override
    public String encode(String rawText) {
        return passwordEncoder.encode(rawText);
    }
}
