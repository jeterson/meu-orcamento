package com.jeterson.meuorcamento.domain.application.service.input.service;

import com.jeterson.meuorcamento.domain.application.service.dto.user.CreateUserCommand;
import com.jeterson.meuorcamento.domain.application.service.dto.user.UpdateUserCommand;
import com.jeterson.meuorcamento.domain.core.entities.User;

public interface UserApplicationService extends UsernameApplicationService{

    User create(CreateUserCommand createUserCommand);
    User update(UpdateUserCommand updateUserCommand);

}
