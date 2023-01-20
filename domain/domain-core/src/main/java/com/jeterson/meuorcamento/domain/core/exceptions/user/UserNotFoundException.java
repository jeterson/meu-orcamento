package com.jeterson.meuorcamento.domain.core.exceptions.user;

import com.jeterson.meuorcamento.common.domain.exceptions.NotFoundException;

public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
