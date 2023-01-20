package com.jeterson.meuorcaento.domain.application.service.output.repository;

import com.jeterson.meuorcamento.domain.core.entities.Account;
import com.jeterson.meuorcamento.domain.core.entities.User;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {
    List<Account> findAll(User user);
    Optional<Account> findById(Long id, User user);
    Account save(Account account);
}
