package com.jeterson.meuorcamento.domain.application.service.user.mapper;

import com.jeterson.meuorcamento.domain.application.service.dto.user.CreateUserCommand;
import com.jeterson.meuorcamento.domain.application.service.dto.user.UpdateUserCommand;
import com.jeterson.meuorcamento.domain.core.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserDataMapper {

    public User createUserCommandToUser(CreateUserCommand createUserCommand){
        return User.builder()
                .password(createUserCommand.getPassword())
                .username(createUserCommand.getUsername())
                .name(createUserCommand.getName())
                .build();
    }
    public User updateUserCommandToUser(UpdateUserCommand updateUserCommand, User user){
        return User.builder()
                .name(updateUserCommand.getName())
                .password(updateUserCommand.getPassword())
                .id(updateUserCommand.getId())
                .username(user.getUsername())
                .build();
    }
}
