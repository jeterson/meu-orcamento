package com.jeterson.meuorcaento.domain.application.service.dto.account;

import com.jeterson.meuorcamento.domain.core.valueobjects.AccountColor;
import com.jeterson.meuorcamento.domain.core.valueobjects.AccountType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateAccountCommand {

    @NotNull
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Long bankId;
    @NotNull
    private AccountType accountType;
    @NotNull
    private AccountColor accountColor;
}
