package com.jeterson.meuorcamento.application.exception;

import com.jeterson.meuorcamento.common.application.handler.ErrorDTO;
import com.jeterson.meuorcamento.domain.core.exceptions.account.AccountNotFoundException;
import com.jeterson.meuorcamento.domain.core.exceptions.bank.BankNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class BankApplicationExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = {BankNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handleException(BankNotFoundException exception) {
        log.error(exception.getMessage(), exception);
        return ErrorDTO.builder()
                .code(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(exception.getMessage())
                .build();
    }
}
