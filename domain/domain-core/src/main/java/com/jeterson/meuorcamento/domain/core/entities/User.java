package com.jeterson.meuorcamento.domain.core.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    private Long id;
    private String username;
    private String password;
    private String name;

    public void setPassword(String password) {
        this.password = password;
    }

    public void removePassword() {
        password = null;
    }
}
