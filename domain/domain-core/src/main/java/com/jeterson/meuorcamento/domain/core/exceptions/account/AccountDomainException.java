package com.jeterson.meuorcamento.domain.core.exceptions.account;

import com.jeterson.meuorcamento.common.domain.exceptions.DomainException;

public class AccountDomainException extends DomainException {
    public AccountDomainException(String message) {
        super(message);
    }

    public AccountDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
