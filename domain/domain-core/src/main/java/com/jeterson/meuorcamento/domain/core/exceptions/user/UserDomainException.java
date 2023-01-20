package com.jeterson.meuorcamento.domain.core.exceptions.user;

import com.jeterson.meuorcamento.common.domain.exceptions.DomainException;

public class UserDomainException extends DomainException {
    public UserDomainException(String message) {
        super(message);
    }

    public UserDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
