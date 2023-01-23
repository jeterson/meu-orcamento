package com.jeterson.meuorcamento.domain.application.service.dto.user;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UpdateUserCommand {
    @NotNull
    private Long id;
    @NotNull
    private String password;
    @NotNull
    private String name;
}
