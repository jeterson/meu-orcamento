package com.jeterson.meuorcaento.domain.application.service.dto.user;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserCommand {
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String name;

}
