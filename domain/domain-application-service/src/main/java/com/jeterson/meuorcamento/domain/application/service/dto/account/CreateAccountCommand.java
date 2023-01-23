package com.jeterson.meuorcamento.domain.application.service.dto.account;

import com.jeterson.meuorcamento.domain.core.valueobjects.AccountType;
import com.jeterson.meuorcamento.domain.core.valueobjects.Color;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Builder
public class CreateAccountCommand implements Serializable {

    @NotNull
    private String name;
    @NotNull
    private Long bankId;
    @NotNull
    private AccountType accountType;
    @NotNull
    private Color accountColor;
    private BigDecimal balance;

    public BigDecimal getBalance() {
        if(balance == null)
            return BigDecimal.ZERO;

        return balance;
    }
}
