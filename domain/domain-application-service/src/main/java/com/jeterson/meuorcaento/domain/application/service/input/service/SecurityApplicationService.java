package com.jeterson.meuorcaento.domain.application.service.input.service;

import com.jeterson.meuorcamento.domain.core.entities.User;

public interface SecurityApplicationService {
    User getAuthenticatedUser();
    boolean isTokenValid(String token);

    String encode(String rawText);
}
