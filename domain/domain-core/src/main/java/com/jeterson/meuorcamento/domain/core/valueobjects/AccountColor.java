package com.jeterson.meuorcamento.domain.core.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.jeterson.meuorcamento.domain.core.exceptions.account.AccountDomainException;
import lombok.Getter;

@Getter
public enum AccountColor {

    BLUE("#1976D2"),
    BLUE_1("#31CCEC"),
    GREEN("#21BA45"),
    GREEN_1("#26A69A"),
    PURPLE("#9C27B0"),
    YELLOW("#F2C037"),
    BLACK("#000"),
    WHITE("#fff"),
    RED("#C10015");

    private String code;

    AccountColor(String code) {
        this.code = code;
    }

    @JsonCreator
    public static AccountColor of(String code) {
        for(var accountColor: AccountColor.values()){
            if(code.toLowerCase().equals(accountColor.code.toLowerCase()))
                return accountColor;
        }
        for(var accountColor: AccountColor.values()){
            if(code.equals(accountColor.name()))
                return accountColor;
        }
        throw new AccountDomainException("AccountType with value " + code + " not found");
    }

    @Override
    public String toString() {
        return code;
    }
}
