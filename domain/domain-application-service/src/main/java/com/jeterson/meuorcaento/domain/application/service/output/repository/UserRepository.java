package com.jeterson.meuorcaento.domain.application.service.output.repository;

import com.jeterson.meuorcamento.domain.core.entities.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUsername(String username);
    User save(User user);
    Optional<User> findById(Long id);
}
