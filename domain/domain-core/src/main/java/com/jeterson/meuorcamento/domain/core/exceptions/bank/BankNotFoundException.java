package com.jeterson.meuorcamento.domain.core.exceptions.bank;

import com.jeterson.meuorcamento.common.domain.exceptions.NotFoundException;
import com.jeterson.meuorcamento.domain.core.entities.User;

public class BankNotFoundException extends NotFoundException {

    public BankNotFoundException(Long id) {
        this(String.format("Bank with id %s not found", id));
    }

    public BankNotFoundException(String message) {
        super(message);
    }

    public BankNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
