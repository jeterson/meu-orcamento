package com.jeterson.meuorcaento.domain.application.service.input.service;

import com.jeterson.meuorcamento.domain.core.entities.User;

public interface UsernameApplicationService {
    User findByUsername(String username);
}
