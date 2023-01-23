package com.jeterson.meuorcamento.domain.core.entities;

import com.jeterson.meuorcamento.common.domain.valueobjects.Money;
import com.jeterson.meuorcamento.domain.core.valueobjects.AccountType;
import com.jeterson.meuorcamento.domain.core.valueobjects.Color;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Account {
    private Long id;
    private String name;
    private Bank bank;
    private AccountType type;
    private User user;
    private Money balance;
    private Color color = Color.BLACK;

    public String getColorHex() {
        return color.getCode();
    }
    public String getAccountTypeDescription() {
        return type.getDescription();
    }


}
