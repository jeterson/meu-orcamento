package com.jeterson.meuorcamento.domain.core.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.jeterson.meuorcamento.domain.core.exceptions.transaction.TransactionDomainException;
import lombok.Getter;

@Getter
public enum TransactionType {

    DEBITO("DEBITO", "Débito"),CREDITO("CREDITO", "Crédito");
    private String code;
    private String description;

    TransactionType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonCreator
    public static TransactionType of(String code) {
        for(var t : TransactionType.values()) {
            if(code.toLowerCase().equals(t.code.toLowerCase()))
                return t;
            if(t.name().toLowerCase().equals(code.toLowerCase()))
                return t;
        }

        throw new TransactionDomainException("TransactionType with code " + code + " not found");
    }
    @Override
    public String toString() {
        return code;
    }
}
