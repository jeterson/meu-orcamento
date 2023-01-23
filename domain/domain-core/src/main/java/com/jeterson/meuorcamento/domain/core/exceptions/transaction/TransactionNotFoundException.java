package com.jeterson.meuorcamento.domain.core.exceptions.transaction;

import com.jeterson.meuorcamento.common.domain.exceptions.NotFoundException;

public class TransactionNotFoundException extends NotFoundException {
    public TransactionNotFoundException(String message) {
        super(message);
    }

    public TransactionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
