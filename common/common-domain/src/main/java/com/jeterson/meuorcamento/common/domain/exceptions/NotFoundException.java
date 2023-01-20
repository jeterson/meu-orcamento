package com.jeterson.meuorcamento.common.domain.exceptions;

public class NotFoundException extends DomainException{
    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
