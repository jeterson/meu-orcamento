package com.jeterson.meuorcamento.domain.core.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.jeterson.meuorcamento.common.domain.exceptions.DomainException;
import com.jeterson.meuorcamento.domain.core.exceptions.account.AccountDomainException;
import lombok.Getter;

@Getter
public enum Color {

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

    Color(String code) {
        this.code = code;
    }

    @JsonCreator
    public static Color of(String code) {
        for(var color: Color.values()){
            if(code.toLowerCase().equals(color.code.toLowerCase()))
                return color;
        }
        for(var color: Color.values()){
            if(code.equals(color.name()))
                return color;
        }
        throw new DomainException("Color with value " + code + " not found");
    }

    @Override
    public String toString() {
        return code;
    }
}
