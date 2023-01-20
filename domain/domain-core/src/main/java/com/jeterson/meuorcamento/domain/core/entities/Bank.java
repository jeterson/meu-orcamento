package com.jeterson.meuorcamento.domain.core.entities;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Bank {
    private Long id;
    private String name;
    private String image;
}
