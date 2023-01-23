package com.jeterson.meuorcamento.domain.core.exceptions.transaction;

import com.jeterson.meuorcamento.common.domain.exceptions.DomainException;

public class TransactionDomainException extends DomainException {
    public TransactionDomainException(String message) {
        super(message);
    }

    public TransactionDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
