package com.jeterson.meuorcamento.domain.core.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.jeterson.meuorcamento.domain.core.exceptions.account.AccountDomainException;
import lombok.Getter;

@Getter
public enum AccountType {

    CONTA_CORRENTE("CONTA_CORRENTE", "Conta Corrente"),
    POUPANCA("POUPANCA", "Poupança"),
    INVESTIMENTOS("INVESTIMENTOS", "Investimentos"),
    CARTEIRA("CARTEIRA", "Carteira"),
    OUTROS("OUTROS", "Outros");

    private String code;
    private String description;

    AccountType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonCreator
    public static AccountType of(String code) {
        for(var accountType:AccountType.values()){
            if(code.toLowerCase().equals(accountType.code.toLowerCase()))
                return accountType;
        }
        throw new AccountDomainException("AccountType with value " + code + " not found");
    }

    @Override
    public String toString() {
        return code;
    }
}
