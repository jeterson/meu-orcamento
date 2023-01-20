package com.jeterson.meuorcamento.domain.core.exceptions.bank;

import com.jeterson.meuorcamento.common.domain.exceptions.DomainException;

public class BankDomainException extends DomainException {
    public BankDomainException(String message) {
        super(message);
    }

    public BankDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
