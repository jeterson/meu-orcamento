package com.jeterson.meuorcamento.domain.core.exceptions.account;

import com.jeterson.meuorcamento.common.domain.exceptions.NotFoundException;
import com.jeterson.meuorcamento.domain.core.entities.User;

public class AccountNotFoundException extends NotFoundException {

    public AccountNotFoundException(Long id, User user) {
        this(String.format("Account with id %s and user %s not found", id, user.getId()));
    }

    public AccountNotFoundException(String message) {
        super(message);
    }

    public AccountNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
