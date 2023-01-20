package com.jeterson.meuorcaento.domain.application.service.input.service;

import com.jeterson.meuorcaento.domain.application.service.dto.account.CreateAccountCommand;
import com.jeterson.meuorcaento.domain.application.service.dto.account.UpdateAccountCommand;
import com.jeterson.meuorcaento.domain.application.service.dto.user.CreateUserCommand;
import com.jeterson.meuorcamento.domain.core.entities.Account;
import com.jeterson.meuorcamento.domain.core.entities.User;
import jakarta.validation.Valid;

import java.util.List;

public interface AccountApplicationService {

    Account create(@Valid CreateAccountCommand createAccountCommand);
    Account createWithUser(@Valid CreateAccountCommand createAccountCommand, User user);
    Account update(@Valid UpdateAccountCommand updateAccountCommand);
    Account findById(Long id);
    List<Account> findAll();
}
